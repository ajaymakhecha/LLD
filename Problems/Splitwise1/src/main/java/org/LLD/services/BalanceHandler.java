package org.LLD.services;

import org.LLD.entities.User;
import org.LLD.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BalanceHandler {

    public List<String> show()
    {
        List<User> users = UserRepository.getAllUsers();
        ArrayList<String> balances = new ArrayList<>();

        for(User user : users)
        {
            for(Map.Entry<User, Double> entry : user.getBalances().entrySet())
            {
                if(entry.getValue()<0D)
                {
                    StringBuilder balanceEntry = new StringBuilder();
                    balanceEntry.append(user.getUserId());
                    balanceEntry.append(" owes ");
                    balanceEntry.append(entry.getKey().getUserId());
                    balanceEntry.append(": ");
                    balanceEntry.append(Math.abs(entry.getValue()));


                    balances.add(balanceEntry.toString());
                }
            }
        }

        if(balances.size()==0)
            balances.add("No Balances!");

        return balances;
    }

    public List<String> show(User user)
    {
        List<User> users = UserRepository.getAllUsers();
        ArrayList<String> balances = new ArrayList<>();

        for(Map.Entry<User, Double> entry : user.getBalances().entrySet())
        {
            if(entry.getValue()<0D)
            {
                StringBuilder balanceEntry = new StringBuilder();
                balanceEntry.append(user.getUserId());
                balanceEntry.append(" owes ");
                balanceEntry.append(entry.getKey().getUserId());
                balanceEntry.append(": ");
                balanceEntry.append(Math.abs(entry.getValue()));


                balances.add(balanceEntry.toString());
            }
            else
            {
                StringBuilder balanceEntry = new StringBuilder();
                balanceEntry.append(entry.getKey().getUserId());
                balanceEntry.append(" owes ");
                balanceEntry.append(user.getUserId());
                balanceEntry.append(": ");
                balanceEntry.append(Math.abs(entry.getValue()));


                balances.add(balanceEntry.toString());
            }
        }

        if(balances.size()==0)
            balances.add("No Balances!");

        return balances;
    }

}
