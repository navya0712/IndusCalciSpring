package com.indus.training.core.impl;

import com.indus.training.core.entity.Student;
import com.indus.training.core.svc.IConverter;

public class JsonConverter implements IConverter {

	@Override
	public String convertToFormat(Student student) {
		StringBuilder json = new StringBuilder();
		json.append("{");
		json.append("\"id\":").append(student.getId()).append(",");
		json.append("\"firstName\":\"").append(student.getFirstName()).append("\",");
		json.append("\"lastName\":\"").append(student.getLastName()).append("\"");
		json.append("}");
		return json.toString();
	}

	@Override
	public Student convertToJava(String jsonString) {
		Student student = new Student();
		jsonString = jsonString.replace("{", "").replace("}", "");
		String[] keyValuePairs = jsonString.split(",");

		for (String pair : keyValuePairs) {
			String[] entry = pair.split(":");
			String key = entry[0].trim().replace("\"", "");
			String value = entry[1].trim().replace("\"", "");
			switch (key) {
			case "id":
				student.setId(Integer.parseInt(value));
				break;
			case "firstName":
				student.setFirstName(value);
				break;
			case "lastName":
				student.setLastName(value);
				break;
			}
		}
		return student;
	}

}
