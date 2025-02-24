package com.indus.training.repository;

import com.indus.training.entity.Student;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Cacheable(value = "students")
	Optional<Student> findById(Integer id);

}
