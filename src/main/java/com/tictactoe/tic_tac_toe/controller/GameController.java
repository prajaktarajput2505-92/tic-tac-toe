package com.tictactoe.tic_tac_toe.controller;

import com.tictactoe.tic_tac_toe.model.Game;
import com.tictactoe.tic_tac_toe.model.MoveRequest;
import com.tictactoe.tic_tac_toe.service.GameService;
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
    public  Game makeMove(@RequestBody MoveRequest moveRequest)
    {
        return gameService.makeMove(moveRequest.getRow(),moveRequest.getCol());
    }

}
