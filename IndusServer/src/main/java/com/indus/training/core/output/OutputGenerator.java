package com.indus.training.core.output;

import com.indus.training.core.domain.CalciOutput;

public class OutputGenerator {

	public String generateHtmlResponse(CalciOutput calOutObj) {
		StringBuilder responseBuilder = new StringBuilder();
		responseBuilder.append("<html>\n<body>\n");
		responseBuilder.append("<h1>Calculation Result</h1>\n");
		responseBuilder.append("<p>Operation: ").append(calOutObj.getOperation()).append("</p>\n");
		responseBuilder.append("<p>Operand 1: ").append(calOutObj.getParam1()).append("</p>\n");
		responseBuilder.append("<p>Operand 2: ").append(calOutObj.getParam2()).append("</p>\n");
		responseBuilder.append("<p>Result: ")
				.append(Double.isNaN(calOutObj.getResult()) ? "Undefined (division by zero)" : calOutObj.getResult())
				.append("</p>\n");
		responseBuilder.append("</body>\n</html>\n");
		return responseBuilder.toString();
	}
}