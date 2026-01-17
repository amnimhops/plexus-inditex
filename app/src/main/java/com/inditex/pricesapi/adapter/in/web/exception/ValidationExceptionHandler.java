package com.inditex.pricesapi.adapter.in.web.exception;

import com.example.app.model.ApiError;
import jakarta.validation.ConstraintViolationException;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Map;

@RestControllerAdvice()
@Order(1)
public class ValidationExceptionHandler {
    private static final Map<Class<?>,ErrorCode> exceptionErrorCodes = Map.of(
            ConstraintViolationException.class, ErrorCode.INVALID_PARAMETER_VALUE,
            MethodArgumentTypeMismatchException.class, ErrorCode.INVALID_PARAMETER_FORMAT,
            MissingServletRequestParameterException.class, ErrorCode.MISSING_PARAMETER);

    private ErrorCode getExceptionErrorCode(Exception e){
        return exceptionErrorCodes.getOrDefault(e.getClass(),ErrorCode.UNKNOWN_ERROR);
    }

    @ExceptionHandler({
            ConstraintViolationException.class,
            MethodArgumentTypeMismatchException.class,
            MissingServletRequestParameterException.class
    })
    public ResponseEntity<ApiError> handleException(Exception exception) {
        return ResponseEntity
                .badRequest()
                .body(new ApiError(
                        getExceptionErrorCode(exception).name(),
                        exception.getMessage()));
    }
}