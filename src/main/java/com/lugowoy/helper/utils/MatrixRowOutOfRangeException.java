package com.lugowoy.helper.utils;

/**
 * Thrown when the value of the matrix row is out of range.
 * <p> Created by Konstantin Lugowoy on 10.06.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.7
 */
public class MatrixRowOutOfRangeException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public MatrixRowOutOfRangeException(String message) {
        super(message);
    }

}
