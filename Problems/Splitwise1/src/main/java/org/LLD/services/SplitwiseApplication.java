package org.LLD.services;

import org.LLD.entities.Command;
import org.LLD.entities.ShowCommand;
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
            Command next = ioStrategy.getUserInput();

            List<String> output = next.execute(splitWiseManager);
            ioStrategy.print(output);

        }
    }
}
