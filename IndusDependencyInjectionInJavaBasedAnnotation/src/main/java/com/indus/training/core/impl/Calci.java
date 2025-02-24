package com.indus.training.core.impl;

import com.indus.training.core.domain.CalciInput;
import com.indus.training.core.domain.CalciOutput;
import com.indus.training.core.svc.ICalci;

/**
 * Description: Implementation of ICalci interface It provides methods for
 * addition, subtraction, multiplication and division of two numbers
 */
public class Calci implements ICalci {

	/**
	 * Description: Performs addition on the input parameters
	 */
	@Override
	public CalciOutput addition(CalciInput calInputObj) {

		CalciOutput calOutObj = null;
		{
			double param1 = calInputObj.param1;
			double param2 = calInputObj.param2;
			double result = param1 + param2;
			calOutObj = new CalciOutput();
			calOutObj.param1 = param1;
			calOutObj.param2 = param2;
			calOutObj.result = result;
			calOutObj.operation = "Addition";
		}
		return calOutObj;
	}

	/**
	 * Description: Performs Subtraction on the input parameters
	 */
	@Override
	public CalciOutput subtract(CalciInput calInputObj) {

		CalciOutput calOutObj = null;
		{
			double param1 = calInputObj.param1;
			double param2 = calInputObj.param2;
			double result = param1 - param2;
			calOutObj = new CalciOutput();
			calOutObj.param1 = param1;
			calOutObj.param2 = param2;
			calOutObj.result = result;
			calOutObj.operation = "Subtraction";
		}
		return calOutObj;
	}

	/**
	 * Description: Performs multiplication on the input parameters
	 */
	@Override
	public CalciOutput multiply(CalciInput calInputObj) {

		CalciOutput calOutObj = null;
		{
			double param1 = calInputObj.param1;
			double param2 = calInputObj.param2;
			double result = param1 * param2;
			calOutObj = new CalciOutput();
			calOutObj.param1 = param1;
			calOutObj.param2 = param2;
			calOutObj.result = result;
			calOutObj.operation = "Multiplication";
		}
		return calOutObj;

	}

	/**
	 * Description: Performs Division on the input parameters
	 */
	@Override
	public CalciOutput division(CalciInput calInputObj) {

		CalciOutput calOutObj = null;
		{
			double param1 = calInputObj.param1;
			double param2 = calInputObj.param2;
			double result = param1 / param2;
			calOutObj = new CalciOutput();
			calOutObj.param1 = param1;
			calOutObj.param2 = param2;
			calOutObj.result = result;
			calOutObj.operation = "Division";
		}
		return calOutObj;
	}

}
