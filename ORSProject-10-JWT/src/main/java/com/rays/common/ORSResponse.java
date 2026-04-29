package com.rays.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Standard response wrapper for ORS (Online Result System) APIs.
 * <p>
 * Provides a unified structure for sending success status, messages,
 * input validation errors, and data back to the client.
 * </p>
 *
 * <p>Response is stored in a {@link Map} with predefined keys:</p>
 * <ul>
 *   <li>{@link #INPUT_ERROR} - validation errors</li>
 *   <li>{@link #MESSAGE} - success/error messages</li>
 *   <li>{@link #DATA} - response data</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 */
public class ORSResponse {

    /** Key for input validation errors */
    public static final String INPUT_ERROR = "inputerror";

    /** Key for response messages */
    public static final String MESSAGE = "message";

    /** Key for response data */
    public static final String DATA = "data";

    /** Map holding response results */
    private Map<String, Object> result = new HashMap<>();

    /** Success flag */
    public boolean success = false;

    // ---------------- Constructors ---------------- //

    /**
     * Default constructor.
     */
    public ORSResponse() {
    }

    /**
     * Constructor with success flag.
     *
     * @param success true if operation succeeded, false otherwise
     */
    public ORSResponse(boolean success) {
        this.success = success;
    }

    /**
     * Constructor with success flag and message.
     *
     * @param success true if operation succeeded
     * @param message response message
     */
    public ORSResponse(boolean success, String message) {
        this.success = success;
        addMessage(message);
    }

    /**
     * Constructor with success flag, message, and data.
     *
     * @param success true if operation succeeded
     * @param message response message
     * @param value   response data
     */
    public ORSResponse(boolean success, String message, Object value) {
        this.success = success;
        addMessage(message);
        addData(value);
    }

    // ---------------- Getters and Setters ---------------- //

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }

    // ---------------- Utility Methods ---------------- //

    /**
     * Adds input validation errors to the response.
     *
     * @param value validation error details
     */
    public void addInputError(Object value) {
        result.put(INPUT_ERROR, value);
    }

    /**
     * Adds a message to the response.
     *
     * @param value message text
     */
    public void addMessage(Object value) {
        result.put(MESSAGE, value);
    }

    /**
     * Adds data to the response.
     *
     * @param value response data
     */
    public void addData(Object value) {
        result.put(DATA, value);
    }

    /**
     * Adds a custom key-value pair to the response.
     *
     * @param key   custom key
     * @param value custom value
     */
    public void addResult(String key, Object value) {
        result.put(key, value);
    }
}
