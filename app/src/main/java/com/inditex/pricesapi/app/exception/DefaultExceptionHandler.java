package com.inditex.pricesapi.app.exception;

import com.example.app.model.ApiError;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(100)
public class DefaultExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ApiError> handleDefaultException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiError(ErrorCode.SERVER_ERROR.name(), exception.getMessage()));
    }
}
