package com.tictactoe.tic_tac_toe.service;

import com.tictactoe.tic_tac_toe.constants.StatusEnum;
import com.tictactoe.tic_tac_toe.model.Game;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private Game game=new Game();

    public Game getNewGame()
    {
        game=new Game();
        return game;
    }

    public Game makeMove(int row, int col)
    {
        if(!game.getStatus().equals(StatusEnum.IN_PROGRESS))
        {
            throw new RuntimeException("Game is already completed");
        }

        if(col<0||col>2||row<0||row>2|| game.getBoard()[row][col]!=' ')
        {
            throw new RuntimeException("Illegal Move");
        }

        game.getBoard()[row][col]=game.getCurrentPlayer();
        if(checkWin(game.getCurrentPlayer()))
        {
            if(game.getCurrentPlayer()=='X') {
                game.setStatus(StatusEnum.WON_X);
            }
            else
            {
                game.setStatus(StatusEnum.WON_O);
            }
        } else if (checkDraw()) {
            game.setStatus(StatusEnum.DRAW);
        }
        else
        {
            game.switchPlayer();
        }
        return game;
    }

    private boolean checkWin(char player)
    {
        char[][] board=game.getBoard();
        for(int i=0;i<3;i++)
        {
            if((board[i][0]==player && board[i][1]==player && board[i][2]==player)||
                    (board[0][i]==player && board[1][i]==player && board[2][i]==player))
            {
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                ((board[0][2] == player && board[1][1] == player && board[2][0] == player));
    }

    private boolean checkDraw()
    {
        char[][] board = game.getBoard();
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]==' ')
                {
                    return false;
                }
            }
        }
        return true;
    }

    public Game getGame()
    {
        return game;
    }
}

