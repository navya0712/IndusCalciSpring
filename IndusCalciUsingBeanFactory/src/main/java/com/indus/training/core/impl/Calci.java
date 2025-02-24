package com.indus.training.core.impl;


import com.indus.training.core.svc.ICalci;

/**
 * Description: Performs Addition, Subtraction, Multiplication and Division
 */

public class Calci implements ICalci {

	/**
	 * Description: Performs Addition of two double values
	 */

	public double addition(double param1, double param2) {
		double result = 0.0;
		{
			result = param1 + param2;

		}
		return result;

	}

	/**
	 * Description: Performs Subtraction of two double values
	 */

	public double subtract(double param1, double param2) {
		double result = 0.0;
		{
			result = param1 - param2;

		}
		return result;

	}

	/**
	 * Description: Performs multiplication of two numbers
	 */

	public double multiply(double param1, double param2) {
		double result = 0.0;
		{
			result = param1 * param2;
		}
		return result;

	}

	/**
	 * Description: Performs Division of two double values
	 */

	public double division(double param1, double param2) {
		double result = 0.0;
		{
			result = param1 / param2;
		}
		return result;

	}

}
