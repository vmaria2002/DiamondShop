package com.maria.ass1.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.context.support.DefaultMessageSourceResolvable;

import java.util.HashMap;
import java.util.Map;

@Order(Ordered.HIGHEST_PRECEDENCE+1)
@ControllerAdvice
@RestController
@Slf4j
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value={ResourceNotFoundException.class})
    protected ResponseEntity<Object> handleApiExceptionResponse(ResourceNotFoundException ex) {
        HttpStatus status = ex.getStatus() != null ? ex.getStatus() : HttpStatus.INTERNAL_SERVER_ERROR;
        return responseEntityBuilder(ResourceNotFoundException.builder().fieldName(ex.getFieldName()).fieldValue(ex.getFieldValue()).status(status).resourceName(ex.getResourceName()).build());
    }
    private ResponseEntity<Object> responseEntityBuilder(ResourceNotFoundException ex){
        return new ResponseEntity<>(ex,ex.getStatus());
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .findFirst()
                .orElse(ex.getMessage());
        return response(ex, request, HttpStatus.BAD_REQUEST, errorMessage);
    }

    private ResponseEntity<Object> response(Exception ex, WebRequest request, HttpStatus status, String message) {
        return handleExceptionInternal(ex, message, new HttpHeaders(), status, request);
    }

}
