package com.indus.training.core.svc;

import com.indus.training.core.domain.CalciInput;
import com.indus.training.core.domain.CalciOutput;

public interface ICalciService {

	public CalciOutput performAddition(CalciInput calInputObj);

	public CalciOutput performSubtraction(CalciInput calInputObj);

	public CalciOutput performMultiplication(CalciInput calInputObj);

	public CalciOutput performDivision(CalciInput calInputObj);

}
