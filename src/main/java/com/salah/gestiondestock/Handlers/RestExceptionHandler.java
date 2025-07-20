package com.salah.gestiondestock.Handlers;

import com.salah.gestiondestock.Exceptions.EntityNotFoundException;
import com.salah.gestiondestock.Exceptions.InvalideEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleException(EntityNotFoundException entityNotFoundException, WebRequest webRequest){
        final HttpStatus notFound = HttpStatus.NOT_FOUND;

        // Création d'un objet ErrorDto en utilisant le builder pattern et l'assignant à une variable
        final ErrorDto errorDto = ErrorDto.builder()
                .errorCodes(entityNotFoundException.getErrorCodes())
                .httpCode(notFound.value())
                .message(entityNotFoundException.getMessage())
                .build();
        // Retourner une ResponseEntity contenant l'objet ErrorDto créé
        return  new ResponseEntity<>(errorDto, notFound);
    }

    @ExceptionHandler(InvalideEntityException.class)
    public ResponseEntity<ErrorDto> handleException(InvalideEntityException invalideEntityException,WebRequest webRequest){
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        // Création d'un objet ErrorDto en utilisant le builder pattern et l'assignant à une variable
        final ErrorDto errorDto = ErrorDto.builder()
                .errorCodes(invalideEntityException.getErrorCodes())
                .httpCode(badRequest.value())
                .message(invalideEntityException.getMessage())
                .errors(invalideEntityException.getErrors())
                .build();
        // Retourner une ResponseEntity contenant l'objet ErrorDto créé
        return new ResponseEntity<>(errorDto,badRequest);
    }
}
