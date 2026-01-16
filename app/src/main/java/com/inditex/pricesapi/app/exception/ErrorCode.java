package com.inditex.pricesapi.app.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

public enum ErrorCode {
    UNKNOWN_ERROR,
    SERVER_ERROR,
    INVALID_PARAMETER_VALUE,
    INVALID_PARAMETER_FORMAT,
    MISSING_PARAMETER
}
