package com.rays.exception;

/**
 * Custom Application Exception
 *
 * <p>
 * This exception is used to handle application-level errors.
 * It represents general exceptions that occur during business
 * logic processing.
 * </p>
 *
 * <p>
 * This is a checked exception and must be handled explicitly.
 * </p>
 *
 * @author Aditya Sharma
 * @version 1.0
 * @since 2026
 */
public class ApplicationException extends Exception {
   
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new ApplicationException with specified message.
	 *
	 * @param msg error message
	 */
	public ApplicationException(String msg){
	   super(msg);
   }
}