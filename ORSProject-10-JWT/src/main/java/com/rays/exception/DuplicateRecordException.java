package com.rays.exception;

/**
 * Exception thrown when attempting to create or update a record
 * that already exists in the system.
 * <p>
 * This is a custom runtime exception used to enforce unique
 * constraints at the service or DAO layer. For example, it may
 * be thrown when trying to insert a duplicate login ID, email,
 * or other unique attribute.
 * </p>
 *
 * <p>
 * Since it extends {@link RuntimeException}, it is unchecked
 * and does not require explicit handling in method signatures.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
public class DuplicateRecordException extends RuntimeException {

    /**
     * Constructs a new DuplicateRecordException with the specified detail message.
     *
     * @param msg the detail message explaining the cause of the exception
     */
    public DuplicateRecordException(String msg) {
        super(msg);
    }
}
