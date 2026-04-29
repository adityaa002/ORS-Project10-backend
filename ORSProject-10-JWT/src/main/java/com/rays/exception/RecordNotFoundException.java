package com.rays.exception;

/**
 * Exception thrown when a requested record cannot be found in the system.
 * <p>
 * This is a custom checked exception used to indicate that a search
 * or lookup operation did not return any results. For example, it may
 * be thrown when attempting to retrieve a record by ID or unique key
 * that does not exist in the database.
 * </p>
 *
 * <p>
 * Since it extends {@link Exception}, it is a checked exception and
 * must be declared in method signatures or explicitly handled by
 * calling code.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
public class RecordNotFoundException extends Exception {
    
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new RecordNotFoundException with the specified detail message.
     *
     * @param msg the detail message explaining the cause of the exception
     */
    public RecordNotFoundException(String msg) {
        super(msg);
    }
}
