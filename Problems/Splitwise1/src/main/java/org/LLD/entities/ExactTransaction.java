package org.LLD.entities;

import java.util.List;

public class ExactTransaction extends Transaction{

    private List<Double> exactAmounts;

    public ExactTransaction(User payer, List<User> users, double amount, List<Double> exactAmounts) {
        super(payer, users, amount);
        this.exactAmounts = exactAmounts;
    }

    public List<Double> getExactAmounts() {
        return exactAmounts;
    }
}
