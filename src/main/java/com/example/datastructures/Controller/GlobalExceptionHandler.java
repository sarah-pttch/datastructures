package com.example.datastructures.Controller;

import com.example.datastructures.Service.ListEmptyException;
import com.example.datastructures.Service.ListFullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ListFullException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String>
    handleListFullException(ListFullException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ListEmptyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String>
    handleListEmptyException(ListEmptyException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String>
    handleTypeMismatchException(){
        return new ResponseEntity<>("Only numbers of type Integer allowed.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String>
    handleMissingServletRequestParameterException(){
        return new ResponseEntity<>("A number to add must be specified.", HttpStatus.BAD_REQUEST);
    }

}
