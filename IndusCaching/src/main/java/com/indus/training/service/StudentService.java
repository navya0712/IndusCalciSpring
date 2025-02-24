package com.indus.training.service;

import com.indus.training.entity.Student;
import com.indus.training.exception.StudentNotFoundException;
import com.indus.training.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

public class StudentService {

	private StudentRepository studentRepository;

	public StudentRepository getStudentRepository() {
		return studentRepository;
	}

	@Autowired
	public void setStudentRepository(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public Student insertStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student fetchStudent(Integer studentId) throws StudentNotFoundException {
		return studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException());
	}

	public void deleteStudent(Integer studentId) {
		studentRepository.deleteById(studentId);
	}

	public Student updateStudentFirstName(Integer studentId, String firstName) throws StudentNotFoundException {
		Student student = fetchStudent(studentId);
		student.setFirstName(firstName);
		return studentRepository.save(student);
	}

	public Optional<Student> getStudentById(Integer id) {
		return studentRepository.findById(id);
	}

}
