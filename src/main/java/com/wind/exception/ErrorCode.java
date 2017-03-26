package com.wind.exception;

public class ErrorCode {

    public static final int SERVER_INTERNAL_ERROR = 1000;
    public static final int PARAMETER_ILLEGAL_ERROR = 1001;
    public static final int RESOURCE_NOT_FOUND_ERROR = 1002;

    /**
     * Prevent instantiation
     */
    private ErrorCode() {
    }

}
