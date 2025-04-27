package org.LLD.entities;

import java.util.Arrays;

public class TicTacToeBoard {
    public int numberOfFilledCells;
    private int size;
    public String[][] board;

    public TicTacToeBoard() {
        this.size = 3;
        this.board = new String[3][3];
    }

    public TicTacToeBoard(int size) {
        this.size = size;
        this.board = new String[size][size];
    }

    public int getSize() {
        return size;
    }

    public void clearBoard()
    {
        numberOfFilledCells = 0;
        for(String[] t : board)
            Arrays.fill(t, " ");
    }
}
