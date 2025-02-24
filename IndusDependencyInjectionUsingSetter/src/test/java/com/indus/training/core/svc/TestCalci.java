package com.indus.training.core.svc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.indus.training.core.domain.CalciInput;
import com.indus.training.core.domain.CalciOutput;
import com.indus.training.core.impl.Calci;

import junit.framework.TestCase;

/**
 * Description: Provides Test Cases for Calci Class
 */
public class TestCalci extends TestCase {

	private ICalciService calServiceObj = null;

	/**
	 * Description:Sets Up test environment for each test This method is called
	 * before each test method is executed
	 */
	protected void setUp() throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		calServiceObj = (ICalciService) context.getBean("calciService");
	}

	/**
	 * Description: Tears down the test environment for each test . This method is
	 * called after each test method is executed
	 */
	protected void tearDown() throws Exception {

		calServiceObj = null;

	}

	/**
	 * Description: Test case for addition method in Calci Class
	 */
	public void testAddition() {

		// 1. Inputs
		CalciInput calInputObj = new CalciInput();
		calInputObj.param1 = 2.0;
		calInputObj.param2 = 3.0;

		// 2. Expected Result
		CalciOutput calExpResult = new CalciOutput();
		calExpResult.param1 = 2.0;
		calExpResult.param2 = 3.0;
		calExpResult.result = 5.0;
		calExpResult.operation = "Addition";
		;

		// 3. Actual Result
		CalciOutput calActualResult = calServiceObj.performAddition(calInputObj);

		// 4. Assertion
		assertEquals(calExpResult.param1, calActualResult.param1, 0);
		assertEquals(calExpResult.param2, calActualResult.param2, 0);
		assertEquals(calExpResult.result, calActualResult.result, 0);
		assertEquals(calExpResult.operation, calActualResult.operation);
	}

	/**
	 * Description: Test Case for subtract method in Calci Class
	 */
	public void testSubtract() {

		// 1. Inputs
		CalciInput calInputObj = new CalciInput();
		calInputObj.param1 = 6.0;
		calInputObj.param2 = 3.0;

		// 2. Expected Result
		CalciOutput calExpResult = new CalciOutput();
		calExpResult.param1 = 6.0;
		calExpResult.param2 = 3.0;
		calExpResult.result = 3.0;
		calExpResult.operation = "Subtraction";

		// 3. Actual Result
		CalciOutput calActualResult = calServiceObj.performSubtraction(calInputObj);

		// 4. Assertion
		assertEquals(calExpResult.param1, calActualResult.param1, 0);
		assertEquals(calExpResult.param2, calActualResult.param2, 0);
		assertEquals(calExpResult.result, calActualResult.result, 0);
		assertEquals(calExpResult.operation, calActualResult.operation);
	}

	/**
	 * Description: Test Case for multiply method in Calci Class
	 */
	public void testMultiply() {

		// 1. Inputs
		CalciInput calInputObj = new CalciInput();
		calInputObj.param1 = 2.0;
		calInputObj.param2 = 3.0;

		// 2. Expected Result
		CalciOutput calExpResult = new CalciOutput();
		calExpResult.param1 = 2.0;
		calExpResult.param2 = 3.0;
		calExpResult.result = 6.0;
		calExpResult.operation = "Multiplication";
		;

		// 3. Actual Result
		CalciOutput calActualResult = calServiceObj.performMultiplication(calInputObj);

		// 4. Assertion
		assertEquals(calExpResult.param1, calActualResult.param1, 0);
		assertEquals(calExpResult.param2, calActualResult.param2, 0);
		assertEquals(calExpResult.result, calActualResult.result, 0);
		assertEquals(calExpResult.operation, calActualResult.operation);
	}

	/**
	 * Description: Test Case for division method in Calci Class
	 */
	public void testDivision() {

		// 1. Inputs
		CalciInput calInputObj = new CalciInput();
		calInputObj.param1 = 6.0;
		calInputObj.param2 = 3.0;

		// 2. Expected Result
		CalciOutput calExpResult = new CalciOutput();
		calExpResult.param1 = 6.0;
		calExpResult.param2 = 3.0;
		calExpResult.result = 2.0;
		calExpResult.operation = "Division";

		// 3. Actual Result
		CalciOutput calActualResult = calServiceObj.performDivision(calInputObj);

		// 4. Assertion
		assertEquals(calExpResult.param1, calActualResult.param1, 0);
		assertEquals(calExpResult.param2, calActualResult.param2, 0);
		assertEquals(calExpResult.result, calActualResult.result, 0);
		assertEquals(calExpResult.operation, calActualResult.operation);
	}

}
