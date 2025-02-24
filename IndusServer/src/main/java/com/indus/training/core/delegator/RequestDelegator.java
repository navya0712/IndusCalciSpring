package com.indus.training.core.delegator;

import com.indus.training.core.domain.CalciInput;
import com.indus.training.core.domain.CalciOutput;
import com.indus.training.core.impl.Calci;

public class RequestDelegator {

	Calci calculator = new Calci();

	public CalciOutput performCalculation(CalciInput calInpObj) {
		String operation = calInpObj.operation;
		switch (operation) {
		case "add":
			return calculator.addition(calInpObj);
		case "subtract":
			return calculator.subtract(calInpObj);
		case "multiply":
			return calculator.multiply(calInpObj);
		case "divide":
			return calculator.division(calInpObj);
		default:
			throw new IllegalArgumentException("Invalid operation: " + operation);
		}
	}
}
