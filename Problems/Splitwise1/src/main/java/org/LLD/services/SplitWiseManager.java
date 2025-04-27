package org.LLD.services;

import org.LLD.entities.Show;
import org.LLD.entities.Transaction;
import org.LLD.entities.User;
import org.LLD.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SplitWiseManager {

    private TransactionHandler transactionHandler;
    private BalanceHandler balanceHandler;

    public SplitWiseManager(TransactionHandler transactionHandler, BalanceHandler balanceHandler) {
        this.transactionHandler = transactionHandler;
        this.balanceHandler = balanceHandler;
    }

    public void transact(Transaction transaction)
    {
        transactionHandler.handleTransaction(transaction);
    }

    public List<String> show(Show next) {
        if(next.getUserId()==null)
            return balanceHandler.show();
        else
            return balanceHandler.show(next.getUserId());
    }
}
