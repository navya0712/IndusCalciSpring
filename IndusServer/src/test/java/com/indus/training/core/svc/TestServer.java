package com.indus.training.core.svc;

import com.indus.training.core.delegator.RequestDelegator;
import com.indus.training.core.input.InputReader;
import com.indus.training.core.output.OutputGenerator;
import com.indus.training.core.server.Server;

import junit.framework.TestCase;

public class TestServer extends TestCase {

	Server server = null;
	InputReader inputReader = null;
	OutputGenerator outputGenerator = null;
	RequestDelegator requestDelegator = null;

	protected void setUp() throws Exception {
		InputReader inputReader = new InputReader();
		OutputGenerator outputGenerator = new OutputGenerator();
		RequestDelegator requestDelegator = new RequestDelegator();
		server = new Server(inputReader, requestDelegator, outputGenerator);
	}

	protected void tearDown() throws Exception {
		server = null;
	}

	public void testProcessRequest() {
		try {
			String response = server.processRequest("src/main/resources/request.html");
			System.out.println(response);
		} catch (Exception e) {
			fail("Assertion failed");
		}
	}

}
