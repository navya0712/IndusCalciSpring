package com.indus.training.core.server;

import java.io.IOException;

import com.indus.training.core.delegator.RequestDelegator;
import com.indus.training.core.domain.CalciInput;
import com.indus.training.core.domain.CalciOutput;
import com.indus.training.core.input.InputReader;
import com.indus.training.core.output.OutputGenerator;

public class Server {
	private final InputReader inputReader;
	private final RequestDelegator requestDelegator;
	private final OutputGenerator responseGenerator;

	public Server(InputReader inputReader, RequestDelegator requestDelegator, OutputGenerator responseGenerator) {
		this.inputReader = inputReader;
		this.requestDelegator = requestDelegator;
		this.responseGenerator = responseGenerator;
	}

	public String processRequest(String filePath) throws IOException {
		CalciInput calciInput = inputReader.readCalciInput(filePath);

		CalciOutput result = requestDelegator.performCalculation(calciInput);

		String htmlResponse = responseGenerator.generateHtmlResponse(result);
		return htmlResponse;

	}

}
