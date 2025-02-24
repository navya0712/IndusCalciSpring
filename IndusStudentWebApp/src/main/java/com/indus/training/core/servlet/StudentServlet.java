package com.indus.training.core.servlet;

import com.indus.training.persist.dao.StudentDao;
import com.indus.training.persist.impl.StudentDaoImpl;
import com.indus.training.persist.entity.Student;
import com.indus.training.persist.exceptions.StudentHibernateJPAException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class StudentServlet extends HttpServlet {
	private StudentDao studentDao;

	@Override
	public void init() throws ServletException {
		studentDao = new StudentDaoImpl(); // Instantiate the DAO
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (action == null) {
			out.println("<h1>Student Operations</h1>");
			out.println("<ul>");
			out.println("<li><a href='?action=insert'>Insert Student</a></li>");
			out.println("<li><a href='?action=update'>Update Student</a></li>");
			out.println("<li><a href='?action=delete'>Delete Student</a></li>");
			out.println("<li><a href='?action=fetch'>Fetch Student</a></li>");
			out.println("</ul>");
		} else {
			switch (action) {
			case "insert":
				displayInsertForm(out);
				break;
			case "update":
				displayUpdateForm(out);
				break;
			case "delete":
				displayDeleteForm(out);
				break;
			case "fetch":
				displayFetchForm(out);
				break;
			default:
				out.println("<h2>Invalid action</h2>");
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();

		switch (action) {
		case "insert":
			insertStudent(request, response, out);
			break;
		case "update":
			updateStudent(request, response, out);
			break;
		case "delete":
			deleteStudent(request, response, out);
			break;
		case "fetch":
			fetchStudent(request, response, out);
			break;
		default:
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
		}
	}

	private void displayInsertForm(PrintWriter out) {
		out.println("<h1>Insert Student</h1>");
		out.println("<form action='student' method='post'>");
		out.println("<input type='hidden' name='action' value='insert'>");
		out.println("<label for='StudentId'>StudentId:</label>");
		out.println("<input type='text' id='studentId' name='studentId' required><br>");
		out.println("<input type='hidden' name='action' value='insert'>");
		out.println("<label for='firstName'>First Name:</label>");
		out.println("<input type='text' id='firstName' name='firstName' required><br>");
		out.println("<label for='lastName'>Last Name:</label>");
		out.println("<input type='text' id='lastName' name='lastName' required><br>");
		out.println("<input type='submit' value='Add Student'>");
		out.println("</form>");
	}

	private void displayUpdateForm(PrintWriter out) {
		out.println("<h1>Update Student</h1>");
		out.println("<form action='student' method='post'>");
		out.println("<input type='hidden' name='action' value='update'>");
		out.println("<label for='studentId'>Student ID:</label>");
		out.println("<input type='text' id='studentId' name='studentId' required><br>");
		out.println("<label for='firstName'>New First Name:</label>");
		out.println("<input type='text' id='firstName' name='firstName'><br>");
		out.println("<label for='lastName'>New Last Name:</label>");
		out.println("<input type='text' id='lastName' name='lastName'><br>");
		out.println("<input type='submit' value='Update Student'>");
		out.println("</form>");
	}

	private void displayDeleteForm(PrintWriter out) {
		out.println("<h1>Delete Student</h1>");
		out.println("<form action='student' method='post'>");
		out.println("<input type='hidden' name='action' value='delete'>");
		out.println("<label for='studentId'>Student ID:</label>");
		out.println("<input type='text' id='studentId' name='studentId' required><br>");
		out.println("<input type='submit' value='Delete Student'>");
		out.println("</form>");
	}

	private void displayFetchForm(PrintWriter out) {
		out.println("<h1>Fetch Student</h1>");
		out.println("<form action='student' method='post'>");
		out.println("<input type='hidden' name='action' value='fetch'>");
		out.println("<label for='studentId'>Student ID:</label>");
		out.println("<input type='text' id='studentId' name='studentId' required><br>");
		out.println("<input type='submit' value='Fetch Student'>");
		out.println("</form>");
	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
			throws IOException {
		Integer studentId = Integer.valueOf(request.getParameter("studentId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Student student = new Student();
		student.setStudentId(studentId);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		System.out.println(student.getStudentId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		try {
			boolean status = studentDao.insertStudent(student);
			if (status) {
				out.println("Student inserted successfully.");
			} else {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Failed to insert student.");
			}
		} catch (StudentHibernateJPAException ex) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "An exception occured");
		}
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
			throws IOException {
		Integer studentId = Integer.valueOf(request.getParameter("studentId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");

		try {
			boolean status = studentDao.updateStudentFirstName(studentId, firstName)
					&& studentDao.updateStudentLastName(studentId, lastName);
			if (status) {
				out.println("Student updated successfully.");
			} else {
				out.println("Failed to update student.");
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Failed to update student.");
			}
		} catch (StudentHibernateJPAException ex) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "An exception occured");
		}
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
			throws IOException {
		try {
			Integer studentId = Integer.valueOf(request.getParameter("studentId"));
			boolean status = studentDao.deleteStudent(studentId);
			if (status) {
				out.println("Student deleted successfully.");
			} else {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Failed to delete student.");
			}
		} catch (StudentHibernateJPAException ex) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "An exception occured");
		}
	}

	private void fetchStudent(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
			throws IOException {
		Integer studentId = Integer.valueOf(request.getParameter("studentId"));
		try {
			Student student = studentDao.fetchStudent(studentId);
			if (student != null) {
				out.println("Student ID: " + student.getStudentId());
				out.println("First Name: " + student.getFirstName());
				out.println("Last Name: " + student.getLastName());
			} else {
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "Student not found.");
			}
		} catch (StudentHibernateJPAException ex) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "An exception occured");
		}
	}

	@Override
	public void destroy() {
		studentDao = null;
	}
}
