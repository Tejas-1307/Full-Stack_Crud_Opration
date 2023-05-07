package com.crud.fullstack.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> exceptionHandler(UserNotFoundException exception){

        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("errorMassage",exception.getMessage());

        return errorMap;
    }
}
