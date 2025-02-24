package com.indus.training.core.svc;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.indus.training.core.impl.Calci;

public class TestCalci2 {

	@Autowired
	private Calci calObj;

	@Test
	public void testAddition() {
		// 1. Inputs
		double param1 = 2.0;
		double param2 = 3.0;

		// 2. Expected Result
		double expResult = 5.0;

		// 3. Actual Result
		double actualResult = calObj.addition(param1, param2);

		// 4. Assertion
		assertEquals(expResult, actualResult, 0);

	}

	@Test
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

	@Test
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

	@Test
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
