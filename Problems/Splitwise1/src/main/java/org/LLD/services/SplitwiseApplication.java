package org.LLD.services;

import org.LLD.entities.Show;
import org.LLD.entities.Transaction;
import org.LLD.strategies.IOStrategy;

import java.util.List;

public class SplitwiseApplication {
    IOStrategy ioStrategy;
    SplitWiseManager splitWiseManager;

    public SplitwiseApplication(IOStrategy ioStrategy, SplitWiseManager splitWiseManager) {
        this.ioStrategy = ioStrategy;
        this.splitWiseManager = splitWiseManager;
    }

    public void run()
    {
        while(true)
        {
            Object next = ioStrategy.getUserInput();

            if(next instanceof Show) {
                List<String> output = splitWiseManager.show((Show) next);
                ioStrategy.print(output);
            }

            if(next instanceof Transaction) {
                splitWiseManager.transact((Transaction) next);
            }
        }
    }
}
