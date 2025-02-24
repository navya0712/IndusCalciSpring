package com.indus.training.core.domain;

/**
 * Description: Represents input parameters for Calci Class
 */
public class CalciInput {

	public double param1;
	public double param2;
	public String operation;

	public CalciInput(double param1, double param2, String operation) {
		this.param1=param1;
		this.param2=param2;
		this.operation=operation;

	}

	public double getParam1() {
		return param1;
	}

	public void setParam1(double param1) {
		this.param1 = param1;
	}

	public double getParam2() {
		return param2;
	}

	public void setParam2(double param2) {
		this.param2 = param2;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
