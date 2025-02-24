package com.indus.training.core.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.indus.training.core.entity.Student;
import com.indus.training.core.svc.IConverter;

public class XmlConverterUsingJackson implements IConverter {

	private final XmlMapper xmlMapper;

	public XmlConverterUsingJackson(XmlMapper xmlMapper) {
		this.xmlMapper = xmlMapper;
	}

	@Override
	public String convertToFormat(Student student) {
		try {
			return xmlMapper.writeValueAsString(student);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Student convertToJava(String xmlString) {
		try {
			return xmlMapper.readValue(xmlString, Student.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
}