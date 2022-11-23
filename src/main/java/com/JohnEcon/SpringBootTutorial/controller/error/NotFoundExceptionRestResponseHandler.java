package com.JohnEcon.SpringBootTutorial.controller.error;

import com.JohnEcon.SpringBootTutorial.entity.ErrorMessage;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
@ResponseStatus
public class NotFoundExceptionRestResponseHandler extends ResponseEntityExceptionHandler {

    /**
     * When an exception occurs in a @RestController class it is directed to this
     * class, and the appropriate method gets called to return the correct response.
     */
    @ExceptionHandler(ResourceDoesNotExistException.class ) //--> We define that this method handles this exception when happens in controller
    public ResponseEntity<ErrorMessage> notFoundException(ResourceDoesNotExistException e)
    {
        ErrorMessage response = new ErrorMessage();
        response.setStatus(HttpStatus.NOT_FOUND);
        response.setErrorMessage(e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class ) //--> We define that this method handles this exception when happens in controller
    public ResponseEntity<ErrorMessage> notFoundException(EmptyResultDataAccessException e)
    {
        ErrorMessage response = new ErrorMessage();
        response.setStatus(HttpStatus.NOT_FOUND);
        response.setErrorMessage("Resource not found.");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(NoSuchElementException.class ) //--> We define that this method handles this exception when happens in controller
    public ResponseEntity<ErrorMessage> notFoundException(NoSuchElementException e)
    {
        ErrorMessage response = new ErrorMessage();
        response.setStatus(HttpStatus.NOT_FOUND);
        response.setErrorMessage("Resource not found.");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ErrorMessage response = new ErrorMessage();
        response.setStatus(HttpStatus.BAD_REQUEST);
        response.setErrorMessage("Invalid data.");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
