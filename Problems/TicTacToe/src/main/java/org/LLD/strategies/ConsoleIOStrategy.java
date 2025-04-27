package org.LLD.strategies;

import org.LLD.entities.GameStatus;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;

public class ConsoleIOStrategy implements IOStrategy{

    Scanner scanner;

    public ConsoleIOStrategy() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int[] getUserInput(String symbol) {
        System.out.println("Enter position for " + symbol);
        int rowNum = scanner.nextInt();
        int colNum = scanner.nextInt();
        return new int[]{rowNum, colNum};
    }

    @Override
    public void printBoard(List<String> board) {
        for(String boardLine : board)
            System.out.println(boardLine);
    }

    @Override
    public void printResult(GameStatus gameStatus, String symbol) {
        if(gameStatus == GameStatus.Won)
            System.out.println("Game over!!" + symbol + " " + gameStatus.toString());
        else
            System.out.println("Game drawn");
    }

    @Override
    public void print(String s) {
        System.out.println(s);
    }

    @Override
    public boolean playAgain() {
        System.out.println("Play Again? [Y/N]");
        String answer = scanner.next();

        return answer.equalsIgnoreCase("Y");
    }
}
