package org.LLD.entities;

import org.LLD.services.SplitWiseManager;

import java.util.List;

public class TransactionCommand implements Command{

    Transaction transaction;

    public TransactionCommand(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public List<String> execute(SplitWiseManager splitWiseManager) {
        return splitWiseManager.transact(transaction);
    }
}
