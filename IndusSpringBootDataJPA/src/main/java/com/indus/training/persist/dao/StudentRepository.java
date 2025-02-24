package com.indus.training.persist.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indus.training.persist.entity.Student;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Student entity. 
 * Provides CRUD operations by extending JpaRepository.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
    Optional<Student> findByFirstName(String firstName);
    
    List<Student> findByLastName(String lastName);

    boolean existsByFirstNameAndLastName(String firstName, String lastName);
}
