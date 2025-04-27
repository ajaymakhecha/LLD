package org.LLD.strategies;

import org.LLD.entities.*;
import org.LLD.parsers.CommandParser;
import org.LLD.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleIOStrategy implements IOStrategy{

    Scanner scanner;

    public ConsoleIOStrategy() {
        scanner = new Scanner(System.in);
    }

    @Override
    public Command getUserInput() {
        String next = scanner.nextLine();

        if(next==null||next.isEmpty())
            return null;

        return CommandParser.parseCommand(next);
    }

    @Override
    public void print(List<String> output) {
        for(String s : output)
            System.out.println(s);
    }

}
