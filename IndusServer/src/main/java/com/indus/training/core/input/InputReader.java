package com.indus.training.core.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.indus.training.core.domain.CalciInput;

public class InputReader {

	public CalciInput readCalciInput(String filePath) throws IOException {
		StringBuilder htmlContentBuilder = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				htmlContentBuilder.append(line).append("\n");
			}
		}

		String htmlContent = htmlContentBuilder.toString();

		String operation = extractValue(htmlContent, "operation");
		String operand1Str = extractValue(htmlContent, "operand1");
		String operand2Str = extractValue(htmlContent, "operand2");

		double operand1 = Double.parseDouble(operand1Str);
		double operand2 = Double.parseDouble(operand2Str);

		return new CalciInput(operand1, operand2, operation);
	}


	private String extractValue(String content, String tagName) {
		String openTag = "<" + tagName + ">";   
		String closeTag = "</" + tagName + ">";
		int start = content.indexOf(openTag);
		if (start == -1)
			return ""; 
		start += openTag.length();
		int end = content.indexOf(closeTag, start);
		if (end == -1)
			return ""; 
		return content.substring(start, end).trim();
	}
}
