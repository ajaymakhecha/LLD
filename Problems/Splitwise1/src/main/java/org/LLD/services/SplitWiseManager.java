package org.LLD.services;

import org.LLD.entities.ShowCommand;
import org.LLD.entities.Transaction;
import org.LLD.entities.User;

import java.util.ArrayList;
import java.util.List;

public class SplitWiseManager {

    private TransactionHandler transactionHandler;
    private BalanceHandler balanceHandler;

    public SplitWiseManager(TransactionHandler transactionHandler, BalanceHandler balanceHandler) {
        this.transactionHandler = transactionHandler;
        this.balanceHandler = balanceHandler;
    }

    public List<String> transact(Transaction transaction)
    {
        transactionHandler.handleTransaction(transaction);
        return new ArrayList<>();
    }

    public List<String> show(User user) {
        if(user==null)
            return balanceHandler.show();
        else
            return balanceHandler.show(user);
    }
}
