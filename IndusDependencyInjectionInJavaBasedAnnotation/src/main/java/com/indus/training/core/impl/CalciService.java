package com.indus.training.core.impl;

import com.indus.training.core.domain.CalciInput;
import com.indus.training.core.domain.CalciOutput;
import com.indus.training.core.svc.ICalciService;

public class CalciService implements ICalciService {
	private Calci calciObj;

	public CalciService(Calci calciObj) {
		this.calciObj = calciObj;
	}

	@Override
	public CalciOutput performAddition(CalciInput calInputObj) {
		return calciObj.addition(calInputObj);
	}

	@Override
	public CalciOutput performSubtraction(CalciInput calInputObj) {
		return calciObj.subtract(calInputObj);
	}

	@Override
	public CalciOutput performMultiplication(CalciInput calInputObj) {
		return calciObj.multiply(calInputObj);
	}

	@Override
	public CalciOutput performDivision(CalciInput calInputObj) {
		return calciObj.division(calInputObj);
	}

}
