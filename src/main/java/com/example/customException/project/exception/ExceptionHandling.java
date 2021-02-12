package com.example.customException.project.exception;

import com.example.customException.project.constant.Exceptions;
import com.example.customException.project.model.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
@RestController
public class ExceptionHandling extends ResponseEntityExceptionHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<HttpResponse> handleAllExceptions(Exception ex) {
        LOGGER.error(ex.getMessage());
        return createHttpResponse(INTERNAL_SERVER_ERROR, Exceptions.INTERNAL_SERVER_ERROR_MSG);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<HttpResponse> userNotFoundException(Exception ex) {
        LOGGER.error(ex.getMessage());
        return createHttpResponse(NOT_FOUND, ex.getMessage());
    }



    private ResponseEntity<HttpResponse> createHttpResponse(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus,
                httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus);
    }
}
