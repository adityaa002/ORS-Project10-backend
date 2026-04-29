package com.rays.common;

/**
 * Thread-local holder for {@link UserContext}.
 * <p>
 * Provides a mechanism to store and retrieve user-specific context
 * (such as login ID, role, and user details) for the duration of a request.
 * Ensures that each thread has its own isolated {@link UserContext}.
 * </p>
 *
 * <p>
 * This is particularly useful in web applications where multiple requests
 * are processed concurrently, and each request must maintain its own
 * authenticated user details.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
public class UserContextHolder {

    /** Thread-local storage for UserContext */
    private static final ThreadLocal<UserContext> threadLocal = new ThreadLocal<>();

    /**
     * Sets the user context for the current thread.
     *
     * @param context user context to be stored
     */
    public static void setContext(UserContext context) {
        threadLocal.set(context);
    }

    /**
     * Retrieves the user context for the current thread.
     *
     * @return current thread's UserContext, or null if not set
     */
    public static UserContext getContext() {
        return threadLocal.get();
    }

    /**
     * Clears the user context for the current thread.
     * <p>
     * This should be called at the end of request processing
     * to avoid memory leaks.
     * </p>
     */
    public static void clear() {
        threadLocal.remove();
    }
}
