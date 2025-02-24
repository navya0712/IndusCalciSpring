package com.indus.training.core.svc;

import com.indus.training.core.domain.CalciInput;
import com.indus.training.core.domain.CalciOutput;

/**
 * Description: Interface representing basic Calculator Service
 */
public interface ICalci {

	/**
	 * Description: Adds two numbers
	 * 
	 * @param calInputObj
	 * @return
	 */
	public CalciOutput addition(CalciInput calInputObj);

	/**
	 * Description: Subtracts one number from another
	 * 
	 * @param calInputObj
	 * @return
	 */

	public CalciOutput subtract(CalciInput calInputObj);

	/**
	 * Description: Multiplies two numbers
	 * 
	 * @param calInputObj
	 * @return
	 */

	public CalciOutput multiply(CalciInput calInputObj);

	/**
	 * Description: Divides one number by another
	 * 
	 * @param calInputObj
	 * @return
	 */

	public CalciOutput division(CalciInput calInputObj);

}
