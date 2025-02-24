package com.example.demo;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class HelloServlet extends HttpServlet {
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/plain");
//        PrintWriter out = response.getWriter();
//        out.println("Hello from doGet!");
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/plain");
//        PrintWriter out = response.getWriter();
//        out.println("Hello from doPost!");
//    }
//	
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the attributes set in doPost
        String name = (String) request.getAttribute("name");
        String email = (String) request.getAttribute("email");
        String message = (String) request.getAttribute("message");

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Display the resume information
        out.println("<html>");
        out.println("<head><title>Resume</title></head>");
        out.println("<body>");
        out.println("<h1>Resume</h1>");
        out.println("<h2>Personal Information</h2>");
        out.println("<p><strong>Name:</strong> " + (name != null ? name : "N/A") + "</p>");
        out.println("<p><strong>Email:</strong> " + (email != null ? email : "N/A") + "</p>");
        out.println("<h2>Message</h2>");
        out.println("<p>" + (message != null ? message : "N/A") + "</p>");

        // Form to update details
        out.println("<h2>Update Information</h2>");
        out.println("<form method='post' action='helloServlet'>");
        out.println("Name: <input type='text' name='name' required><br>");
        out.println("Email: <input type='email' name='email' required><br>");
        out.println("Message: <textarea name='message' required></textarea><br>");
        out.println("<input type='submit' value='Update'>");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        // Store the data in the request for the doGet method
        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("message", message);

        // Forward the request to doGet
        doGet(request, response);
    }

}
