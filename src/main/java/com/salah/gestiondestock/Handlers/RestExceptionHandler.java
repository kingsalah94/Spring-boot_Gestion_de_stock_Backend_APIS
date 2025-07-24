package com.salah.gestiondestock.Handlers;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    // will be Uncomment when security is configured//

//   @ExceptionHandler(EntityNotFoundException.class)
//   public ResponseEntity<ErrorDto> handleEntityNotFoundException(EntityNotFoundException exception, WebRequest webRequest) {

//     final HttpStatus notFound = HttpStatus.NOT_FOUND;
//     final ErrorDto errorDto = ErrorDto.builder()
//         .code(exception.getErrorCode())
//         .httpCode(notFound.value())
//         .message(exception.getMessage())
//         .build();

//     return new ResponseEntity<>(errorDto, notFound);
//   }

//   @ExceptionHandler(InvalidOperationException.class)
//   public ResponseEntity<ErrorDto> handleInvalidOperationException(InvalidOperationException exception, WebRequest webRequest) {

//     final HttpStatus notFound = HttpStatus.BAD_REQUEST;
//     final ErrorDto errorDto = ErrorDto.builder()
//         .code(exception.getErrorCode())
//         .httpCode(notFound.value())
//         .message(exception.getMessage())
//         .build();

//     return new ResponseEntity<>(errorDto, notFound);
//   }

//   @ExceptionHandler(InvalidEntityException.class)
//   public ResponseEntity<ErrorDto> handleInvalidEntityException(InvalidEntityException exception, WebRequest webRequest) {
//     final HttpStatus badRequest = HttpStatus.BAD_REQUEST;

//     final ErrorDto errorDto = ErrorDto.builder()
//         .code(exception.getErrorCode())
//         .httpCode(badRequest.value())
//         .message(exception.getMessage())
//         .errors(exception.getErrors())
//         .build();

//     return new ResponseEntity<>(errorDto, badRequest);
//   }

//   @ExceptionHandler(BadCredentialsException.class)
//   public ResponseEntity<ErrorDto> handleBadCredentialsException(BadCredentialsException exception, WebRequest webRequest) {
//     final HttpStatus badRequest = HttpStatus.BAD_REQUEST;

//     final ErrorDto errorDto = ErrorDto.builder()
//         .code(ErrorCodes.BAD_CREDENTIALS)
//         .httpCode(badRequest.value())
//         .message(exception.getMessage())
//         .errors(Collections.singletonList("Login et / ou mot de passe incorrecte"))
//         .build();

//     return new ResponseEntity<>(errorDto, badRequest);
 // }
}
