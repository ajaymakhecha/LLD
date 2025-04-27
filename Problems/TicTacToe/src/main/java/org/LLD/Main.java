package org.LLD;

import org.LLD.entities.TicTacToeBoard;
import org.LLD.services.TicTacToeGame;
import org.LLD.services.TicTacToeManager;
import org.LLD.strategies.ConsoleIOStrategy;

public class Main {
    public static void main(String[] args) {
        new TicTacToeManager(new TicTacToeGame(new TicTacToeBoard()), new ConsoleIOStrategy()).play();
    }
}