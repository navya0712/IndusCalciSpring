package com.indus.training.core.svc;

import java.util.List;
import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import com.indus.training.entity.Student;
import com.indus.training.service.StudentService;

import junit.framework.TestCase;

public class TestStudentService extends TestCase {

	private StudentService studentService;

	protected void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		studentService = context.getBean(StudentService.class);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testSaveStudent() {
		Student student = new Student();
		student.setStudentId(1);
		student.setFirstName("John");
		student.setLastName("Doe");

		Student savedStudent = studentService.insertStudent(student);

		assertNotNull(savedStudent);
		assertEquals("John", savedStudent.getFirstName());
		assertEquals("Doe", savedStudent.getLastName());
	}

//	public void testGetStudentById() {
//		Student student = new Student();
//		student.setStudentId(1);
//		student.setFirstName("John");
//		student.setLastName("Doe");
//		studentService.saveStudent(student);
//
//		Optional<Student> retrievedStudent = studentService.getStudentById(1);
//
//		assertTrue(retrievedStudent.isPresent());
//		assertEquals("John", retrievedStudent.get().getFirstName());
//	}
//
//	public void testGetAllStudents() {
//		Student student1 = new Student();
//		student1.setStudentId(1);
//		student1.setFirstName("John");
//		student1.setLastName("Doe");
//
//		Student student2 = new Student();
//		student2.setStudentId(2);
//		student2.setFirstName("Jane");
//		student2.setLastName("Smith");
//
//		studentService.saveStudent(student1);
//		studentService.saveStudent(student2);
//
//		List<Student> allStudents = studentService.getAllStudents();
//
//		assertEquals(2, allStudents.size());
//	}
//
//	public void testDeleteStudentById() {
//		Student student = new Student();
//		student.setStudentId(1);
//		student.setFirstName("John");
//		student.setLastName("Doe");
//		studentService.saveStudent(student);
//
//		studentService.deleteStudentById(1);
//
//		Optional<Student> retrievedStudent = studentService.getStudentById(1);
//		assertFalse(retrievedStudent.isPresent());
//	}
//
//	public void testGetStudentByFirstName() {
//		fail("Not yet implemented");
//	}

}
