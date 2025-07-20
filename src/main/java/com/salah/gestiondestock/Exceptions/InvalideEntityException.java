package com.salah.gestiondestock.Exceptions;

import com.salah.gestiondestock.Enums.ErrorCodes;
import lombok.Getter;

import java.util.List;

@Getter
public class InvalideEntityException extends RuntimeException{

    private ErrorCodes errorCodes;
    private List<String> errors;

    public InvalideEntityException(String message){
        super(message);
    }

    public InvalideEntityException(String message,Throwable cause){
        super(message,cause);
    }
    public InvalideEntityException(String message,Throwable cause,ErrorCodes errorCodes){
        super(message,cause);
        this.errorCodes = errorCodes;
    }

    public InvalideEntityException(String message,ErrorCodes errorCodes){
        super(message);
        this.errorCodes = errorCodes;
    }

    public InvalideEntityException(String message,ErrorCodes errorCodes,List<String> errors){
        super(message);
        this.errorCodes = errorCodes;
        this.errors = errors;
    }
}
