package org.LLD.strategies;

import org.LLD.entities.GameStatus;

import java.util.List;

public interface IOStrategy {
    
    int[] getUserInput(String symbol);
    
    void printBoard(List<String> board);
    
    void printResult(GameStatus gameStatus, String symbol);
    
    void print(String s);

    boolean playAgain();
}
