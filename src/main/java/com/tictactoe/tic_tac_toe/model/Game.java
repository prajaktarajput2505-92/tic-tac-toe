package com.tictactoe.tic_tac_toe.model;

import com.tictactoe.tic_tac_toe.constants.StatusEnum;

import java.util.Arrays;

public class Game {
    char[][] board;
    char currentPlayer;

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    StatusEnum status;

    public Game() {
        board=new char[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j]=' ';
            }
        }
        currentPlayer='X';
        status= StatusEnum.IN_PROGRESS;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(char currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    public void switchPlayer()
    {
        currentPlayer=currentPlayer=='X'?'O':'X';
    }
}
