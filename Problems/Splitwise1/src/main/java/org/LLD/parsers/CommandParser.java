package org.LLD.parsers;

import org.LLD.entities.*;
import org.LLD.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class CommandParser {

    public static Command parseCommand(String command) {
        String[] params = command.split("\\s+");

        if ("Show".equalsIgnoreCase(params[0])) {
            if (params.length == 1)
                return new ShowCommand();

            return new ShowCommand(UserRepository.getOrCreate(params[1]));
        } else {
            User payer = UserRepository.getOrCreate(params[1]);
            int amount = Integer.parseInt(params[2]);
            int noOfUsers = Integer.parseInt(params[3]);

            List<User> users = new ArrayList<>();

            int index = 4;
            for (index = 4; index < 4 + noOfUsers; index++)
                users.add(UserRepository.getOrCreate(params[index]));

            if ("Equal".equalsIgnoreCase(params[index])) {
                return new TransactionCommand(new EqualTransaction(payer, users, amount));
            } else if ("Exact".equalsIgnoreCase(params[index])) {
                List<Double> exactAmounts = new ArrayList<>();
                for (int i = index + 1; i < index + 1 + users.size(); i++)
                    exactAmounts.add(Double.parseDouble(params[i]));

                return new TransactionCommand(new ExactTransaction(payer, users, amount, exactAmounts));
            } else {
                List<Integer> percentages = new ArrayList<>();
                for (int i = index + 1; i < index + 1 + users.size(); i++)
                    percentages.add(Integer.parseInt(params[i]));

                return new TransactionCommand(new PercentTransaction(payer, users, amount, percentages));
            }
        }
    }

}
