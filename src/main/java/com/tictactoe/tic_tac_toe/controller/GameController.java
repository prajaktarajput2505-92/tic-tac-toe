package com.tictactoe.tic_tac_toe.controller;

import com.tictactoe.tic_tac_toe.exception.TicTacToeException;
import com.tictactoe.tic_tac_toe.model.Game;
import com.tictactoe.tic_tac_toe.model.MoveRequest;
import com.tictactoe.tic_tac_toe.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    private GameService gameService;

    @GetMapping
    public Game getGame()
    {
        return gameService.getGame();
    }

    @GetMapping("/startNewGame")
    public Game startNewGame()
    {
       return gameService.getNewGame();
    }

    @PostMapping("/makeMove")
    public ResponseEntity<Object> makeMove(@RequestBody MoveRequest moveRequest) {
        try {
            Game game= gameService.makeMove(moveRequest.getRow(), moveRequest.getCol());
            return ResponseEntity.ok(game);
        } catch (Exception e) {
            getGame();
            throw new TicTacToeException(e.getMessage());
        }
    }

}
