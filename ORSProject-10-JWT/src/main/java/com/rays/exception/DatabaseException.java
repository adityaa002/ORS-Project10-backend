package com.rays.exception;

/**
 * Database Exception
 *
 * <p>
 * This exception is used to handle database-related errors such as
 * record not found, constraint violations, or failure in DB operations.
 * </p>
 *
 * <p>
 * This is a checked exception and must be handled explicitly.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
public class DatabaseException extends Exception {

	/**
	 * Constructs a new DatabaseException with specified message.
	 *
	 * @param msg error message
	 */
	public DatabaseException(String msg) {
		super(msg);
	}

}