package com.indus.training.core.impl;

import com.indus.training.core.entity.Student;
import com.indus.training.core.svc.IConverter;

public class XmlConverter implements IConverter {

	@Override
	public String convertToFormat(Student student) {
		StringBuilder xml = new StringBuilder();
		xml.append("<student>");
		xml.append("<id>").append(student.getId()).append("</id>");
		xml.append("<firstName>").append(student.getFirstName()).append("</firstName>");
		xml.append("<lastName>").append(student.getLastName()).append("</lastName>");
		xml.append("</student>");
		return xml.toString();
	}

	@Override
	public Student convertToJava(String xmlString) {
		Student student = new Student();
		xmlString = xmlString.replace("<student>", "").replace("</student>", "");
		String[] keyValuePairs = xmlString.split("</");
		for (String pair : keyValuePairs) {
			String[] entry = pair.split(">");
			String key = entry[0].trim().replace("<", "");
			String value = entry[1].trim();
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
