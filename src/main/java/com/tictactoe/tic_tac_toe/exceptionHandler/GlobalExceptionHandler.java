package com.tictactoe.tic_tac_toe.exceptionHandler;

import com.tictactoe.tic_tac_toe.exception.TicTacToeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TicTacToeException.class)
    public ResponseEntity<String> handleCustomGameMoveException(TicTacToeException e)
    {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception e)
    {
        return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
    }
}
