package com.example.libs.common.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleInternalException(Exception ex, WebRequest request) {
        logger.error(ex.getMessage(), ex);
        return this.createErrorResponse(ex, request, HttpStatus.FORBIDDEN);
    }

    protected ResponseEntity<Object>
    createErrorResponse(Exception ex, WebRequest request, HttpStatusCode status) {
        final ApiErrorResponse response = ApiErrorResponseFactory.build(ex, request, status);
        return new ResponseEntity<>(response, new HttpHeaders(), status);
    }
}
