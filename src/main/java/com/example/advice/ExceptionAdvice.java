package com.example.advice;

import com.example.exceptions.TicketInvalidException;
import com.example.exceptions.UnathorizedOperationException;
import com.example.services.ResponseMessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    private final ResponseMessageService responseMessageService;

    public ExceptionAdvice(ResponseMessageService responseMessageService) {
        this.responseMessageService = responseMessageService;
    }

    @ExceptionHandler(TicketInvalidException.class)
    public ResponseEntity<?> exceptionTicketInvalidExceptionHandler()
    {
        return responseMessageService.createMessage("Trip not found.", HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(UnathorizedOperationException.class)
    public ResponseEntity<?> exceptionUnathorizedOperationExceptionHandler()
    {
        return responseMessageService.createMessage("Unauthorized operation.", HttpStatus.BAD_REQUEST);

    }
}
