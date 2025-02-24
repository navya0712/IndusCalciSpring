package com.indus.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.indus.training.persist.dao.StudentRepository;
import com.indus.training.persist.entity.Student;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> getStudentById(Integer studentId) {
        return studentRepository.findById(studentId);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudentById(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

    public Optional<Student> getStudentByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }
}
