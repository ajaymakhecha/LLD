package org.LLD.services;

import org.LLD.entities.*;

import java.util.HashMap;

public class TransactionHandler {

    public synchronized void handleTransaction(Transaction transaction)
    {
        if(transaction instanceof EqualTransaction)
            handleEqualTransaction((EqualTransaction) transaction);
        else if(transaction instanceof ExactTransaction)
            handleExactTransaction((ExactTransaction) transaction);
        else
            handlePercentTransaction((PercentTransaction) transaction);
    }

    private void handleEqualTransaction(EqualTransaction transaction)
    {
        User payer = transaction.getPayer();
        Double amount = transaction.getAmount()/transaction.getUsers().size();
        HashMap<User, Double> payerBalance = transaction.getPayer().getBalances();

        for(User user : transaction.getUsers())
        {
            if(user.equals(transaction.getPayer()))
                continue;

            HashMap<User, Double> userBalance = user.getBalances();

            payerBalance.put(user, payerBalance.getOrDefault(user,0d) + amount );
            userBalance.put(payer, userBalance.getOrDefault(payer,0d) - amount );
        }
    }

    private void handleExactTransaction(ExactTransaction transaction)
    {
        User payer = transaction.getPayer();
        HashMap<User, Double> payerBalance = transaction.getPayer().getBalances();

        for(int i=0;i<transaction.getUsers().size();i++)
        {
            User user = transaction.getUsers().get(i);
            Double amount = transaction.getExactAmounts().get(i);
            if(user.equals(transaction.getPayer()))
                continue;

            HashMap<User, Double> userBalance = user.getBalances();

            payerBalance.put(user, payerBalance.getOrDefault(user,0d) + amount );
            userBalance.put(payer, userBalance.getOrDefault(payer,0d) - amount );
        }
    }

    private void handlePercentTransaction(PercentTransaction transaction)
    {
        User payer = transaction.getPayer();
        HashMap<User, Double> payerBalance = transaction.getPayer().getBalances();

        for(int i=0;i<transaction.getUsers().size();i++)
        {
            User user = transaction.getUsers().get(i);
            int percentage = transaction.getPercentages().get(i);
            Double amount = (transaction.getAmount() * percentage)/100d;
            if(user.equals(transaction.getPayer()))
                continue;

            HashMap<User, Double> userBalance = user.getBalances();

            payerBalance.put(user, payerBalance.getOrDefault(user,0d) + amount );
            userBalance.put(payer, userBalance.getOrDefault(payer,0d) - amount );
        }
    }

}
