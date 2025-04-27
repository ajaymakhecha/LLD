package org.LLD;

import org.LLD.services.BalanceHandler;
import org.LLD.services.SplitWiseManager;
import org.LLD.services.SplitwiseApplication;
import org.LLD.services.TransactionHandler;
import org.LLD.strategies.ConsoleIOStrategy;

public class Main {
    public static void main(String[] args) {
        new SplitwiseApplication(new ConsoleIOStrategy(), new SplitWiseManager(new TransactionHandler(), new BalanceHandler())).run();
    }
}