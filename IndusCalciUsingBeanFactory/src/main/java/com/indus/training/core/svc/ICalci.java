package com.indus.training.core.svc;

/**
 * Description: Interface representing basic Calculator Service
 */
public interface ICalci {

	/**
	 * Description: Adds two numbers
	 * 
	 * @param param1
	 * @param param2
	 * @return
	 */
	public abstract double addition(double param1, double param2);

	/**
	 * Description: Subtracts one number from the Other
	 * 
	 * @param param1
	 * @param param2
	 * @return
	 */

	public double subtract(double param1, double param2);

	/**
	 * Description: Multiplies two numbers
	 * 
	 * @param param1
	 * @param param2
	 * @return
	 */
	public double multiply(double param1, double param2);

	/**
	 * Description: Divides one number by another
	 * 
	 * @param param1
	 * @param param2
	 * @return
	 */
	public double division(double param1, double param2);

}
