package com.indus.training.core.svc;

import com.indus.training.core.config.CalciConfig;
import com.indus.training.core.impl.Calci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import junit.framework.TestCase;

/**
 * Description: Provides Unit Tests for Calci Class
 */
public class TestCalci extends TestCase {

	private ICalci calObj = null;

	/**
	 * Description: Sets Up test environment for each test This method is called
	 * before each test method is executed
	 */

	protected void setUp() throws Exception {

		ApplicationContext context = new AnnotationConfigApplicationContext(CalciConfig.class);
		calObj = (ICalci) context.getBean(Calci.class);
	}

	/**
	 * Description: Tears down the test environment for each test . This method is
	 * called after each test method is executed
	 */

	protected void tearDown() throws Exception {
		calObj = null;

	}

	/**
	 * Description: Test case for addition method in Calci Class
	 */

	public void testAddition() {

		try {
			// 1. Inputs
			double param1 = 2.0;
			double param2 = 3.0;

			// 2. Expected Result
			double expResult = 5.0;

			// 3. Actual Result
			double actualResult = calObj.addition(param1, param2);

			// 4. Assertion
			assertEquals(expResult, actualResult, 0);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Description: Test Case for subtract method in Calci Class
	 */

	public void testSubtract() {
		// 1. Inputs
		double param1 = 3.0;
		double param2 = 2.0;

		// 2. Expected Result
		double expResult = 1.0;

		// 3. Actual Result
		double actualResult = calObj.subtract(param1, param2);

		// 4. Assertion
		assertEquals(expResult, actualResult, 0);
	}

	/**
	 * Description: Test Case for multiply method in Calci Class
	 */

	public void testMultiply() {

		// 1. Inputs
		double param1 = 3.0;
		double param2 = 2.0;

		// 2. Expected Result
		double expResult = 6.0;

		// 3. Actual Result
		double actualResult = calObj.multiply(param1, param2);

		// 4. Assertion
		assertEquals(expResult, actualResult, 0);

	}

	/**
	 * Description: Test Case for Division method in Calci Class
	 */

	public void testDivision() {
		// 1. Inputs
		double param1 = 6.0;
		double param2 = 2.0;

		// 2. Expected Result
		double expResult = 3.0;

		// 3. Actual Result
		double actualResult = calObj.division(param1, param2);

		// 4. Assertion
		assertEquals(expResult, actualResult, 0);

	}

}
