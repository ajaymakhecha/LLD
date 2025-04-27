package org.LLD.strategies;

import org.LLD.entities.*;
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
    public Object getUserInput() {
        String next = scanner.nextLine();

        if(next==null||next.isEmpty())
            return null;

        String[] params = next.split("\\s+");

        if("Show".equalsIgnoreCase(params[0]))
        {
            if(params.length==1)
                return new Show();

            return new Show(UserRepository.getOrCreate(params[1]));
        }
        else
        {
            User payer = UserRepository.getOrCreate(params[1]);
            int amount = Integer.parseInt(params[2]);
            int noOfUsers = Integer.parseInt(params[3]);

            List<User> users = new ArrayList<>();

            int index = 4;
            for(index=4;index<4+noOfUsers;index++)
                users.add(UserRepository.getOrCreate(params[index]));

            if("Equal".equalsIgnoreCase(params[index]))
            {
                return new EqualTransaction(payer,users,amount);
            }
            else if("Exact".equalsIgnoreCase(params[index]))
            {
                List<Double> exactAmounts = new ArrayList<>();
                for(int i=index+1;i<index+1+users.size();i++)
                    exactAmounts.add(Double.parseDouble(params[i]));

                return new ExactTransaction(payer,users,amount,exactAmounts);
            }
            else
            {
                List<Integer> percentages = new ArrayList<>();
                for(int i=index+1;i<index+1+users.size();i++)
                    percentages.add(Integer.parseInt(params[i]));

                return new PercentTransaction(payer,users,amount, percentages);
            }
        }
    }

    @Override
    public void print(List<String> output) {
        for(String s : output)
            System.out.println(s);
    }

}
