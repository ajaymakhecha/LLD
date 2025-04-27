package org.LLD.services;

import org.LLD.entities.GameStatus;
import org.LLD.entities.Symbol;
import org.LLD.strategies.IOStrategy;

public class TicTacToeManager {
    TicTacToeGame ticTacToeGame;
    IOStrategy ioStrategy;

    public TicTacToeManager(TicTacToeGame ticTacToeGame, IOStrategy ioStrategy) {
        this.ticTacToeGame = ticTacToeGame;
        this.ioStrategy = ioStrategy;
    }

    public void play()
    {
        ticTacToeGame.clearBoard();
        Symbol currentPlayer = Symbol.X;
        GameStatus currentGameStatus = GameStatus.Continue;
        ioStrategy.printBoard(ticTacToeGame.printBoard());

        while(currentGameStatus==GameStatus.Continue)
        {
            int[] move = ioStrategy.getUserInput(currentPlayer.toString());
            if(!ticTacToeGame.canPlay(move[0],move[1])) {
                ioStrategy.print("Invalid move for " + currentPlayer.toString());
                ioStrategy.print("Plese try again");
                continue;
            }

            ticTacToeGame.play(move[0],move[1],currentPlayer.toString());
            ioStrategy.printBoard(ticTacToeGame.printBoard());
            currentGameStatus = ticTacToeGame.getGameStatus(move[0],move[1],currentPlayer.toString());

            if(currentGameStatus==GameStatus.Continue)
                currentPlayer = getNextPlayer(currentPlayer);
            else
                break;
        }

        ioStrategy.printResult(currentGameStatus, currentPlayer.toString());

        if(ioStrategy.playAgain())
            play();
    }

    private Symbol getNextPlayer(Symbol currentPlayer) {
        return currentPlayer==Symbol.X?Symbol.Y:Symbol.X;
    }
}
