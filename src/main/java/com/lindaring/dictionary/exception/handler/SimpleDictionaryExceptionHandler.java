package com.lindaring.dictionary.exception.handler;

import com.lindaring.dictionary.exception.WordNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SimpleDictionaryExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { WordNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(WordNotFoundException e, WebRequest request) {
        ExceptionHandlerResponse bodyOfResponse = ExceptionHandlerResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(e.getMessage())
                .exception(e.getClass()).build();
        return handleExceptionInternal(e, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}