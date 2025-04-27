package org.LLD.services;

import org.LLD.entities.GameStatus;
import org.LLD.entities.TicTacToeBoard;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame {

    private TicTacToeBoard ticTacToeBoard;

    public TicTacToeGame(TicTacToeBoard ticTacToeBoard) {
        this.ticTacToeBoard = ticTacToeBoard;
    }

    public boolean canPlay(int rowNum, int colNum)
    {
        return rowNum < ticTacToeBoard.getSize() && colNum < ticTacToeBoard.getSize() && ticTacToeBoard.board[rowNum][colNum].equals(" ");
    }

    public void play(int rowNum, int colNum, String symbol)
    {
        ticTacToeBoard.board[rowNum][colNum] = symbol;
        ticTacToeBoard.numberOfFilledCells++;
    }

    public GameStatus getGameStatus(int rowNum, int colNum, String symbol)
    {
        if(checkRow(rowNum,colNum,symbol) || checkColumn(rowNum, colNum, symbol) || checkDiagonal(rowNum, colNum, symbol))
            return GameStatus.Won;

        if(ticTacToeBoard.numberOfFilledCells== ticTacToeBoard.getSize()* ticTacToeBoard.getSize())
            return GameStatus.Draw;

        return GameStatus.Continue;
    }

    private boolean checkDiagonal(int rowNum, int colNum, String symbol) {

        int i = 0;

        for(i=0;i<ticTacToeBoard.getSize();i++)
        {
            if(!ticTacToeBoard.board[i][i].equals(symbol))
                break;
        }

        if(i== ticTacToeBoard.getSize())
            return true;

        for(i=0;i<ticTacToeBoard.getSize();i++)
        {
            if(!ticTacToeBoard.board[i][ticTacToeBoard.getSize()-1-i].equals(symbol))
                break;
        }

        if(i== ticTacToeBoard.getSize())
            return true;

        return false;
    }

    public List<String> printBoard()
    {
        List<String> board = new ArrayList<>();
        StringBuilder newLine = new StringBuilder();

        newLine.append("_".repeat(Math.max(0, ticTacToeBoard.getSize()*2)));

        for(int i=0;i< ticTacToeBoard.getSize();i++)
        {
            StringBuilder current = new StringBuilder();
            for(int j=0;j< ticTacToeBoard.getSize();j++)
            {
                current.append(ticTacToeBoard.board[i][j]);

                if(j!= ticTacToeBoard.getSize()-1)
                    current.append("|");
            }
            board.add(current.toString());

            if(i!= ticTacToeBoard.getSize()-1)
                board.add(newLine.toString());
        }

        return board;
    }

    private boolean checkRow(int rowNum, int colNum, String symbol)
    {
        for(int i=0;i<ticTacToeBoard.getSize();i++)
        {
            if(!ticTacToeBoard.board[rowNum][i].equals(symbol))
               return false;
        }

        return true;
    }

    private boolean checkColumn(int rowNum, int colNum, String symbol)
    {
        for(int i=0;i<ticTacToeBoard.getSize();i++)
        {
            if(!ticTacToeBoard.board[i][colNum].equals(symbol))
                return false;
        }

        return true;
    }

    public void clearBoard() {
        ticTacToeBoard.clearBoard();
    }
}
