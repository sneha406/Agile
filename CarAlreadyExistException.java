package com.Cartrader.Richinternet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class CarAlreadyExistException extends RuntimeException{
    public CarAlreadyExistException(String message) {
        super(message);
    }
}
