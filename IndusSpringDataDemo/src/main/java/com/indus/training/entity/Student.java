package com.indus.training.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

/**
 * Represents a Student entity with attributes such as studentId, firstName, and
 * lastName.
 */
@Entity
@Table(name="Student")
public class Student {

	@Id
	@Column(name = "ID")
	private Integer studentId;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;

	public Student() {

	}

	/**
	 * Gets the student ID.
	 * 
	 * @return studentId Unique identifier for the student
	 */
	public Integer getStudentId() {
		return studentId;
	}

	/**
	 * Sets the student ID
	 * 
	 * @param the ID of the student to set
	 */
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;

	}

	/**
	 * Gets the first name of the student.
	 * 
	 * @return firstName First name of the student
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the student.
	 * 
	 * @param firstName First name of the student
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name of the student.
	 * 
	 * @return lastName Last name of the student
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of the student.
	 * 
	 * @param lastName Last name of the student
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returns a string representation of the Student object. The string includes
	 * the student's ID, first name, and last name.
	 * 
	 * @return String representation of the Student object
	 */
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	/**
	 * Computes the hash code for the Student object. The hash code is based on the
	 * student's first name, last name, and student ID.
	 * 
	 * @return Hash code for the Student object
	 */
	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, studentId);
	}

	/**
	 * Checks if this Student object is equal to another object. Two Student objects
	 * are considered equal if they have the same student ID, first name, and last
	 * name.
	 * 
	 * @param obj Object to be compared with this Student object
	 * @return true if this Student object is equal to the other object; false
	 *         otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& studentId == other.studentId;
	}

}
