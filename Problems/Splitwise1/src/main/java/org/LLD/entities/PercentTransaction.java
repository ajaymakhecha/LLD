package org.LLD.entities;

import java.util.List;

public class PercentTransaction extends Transaction{
    private List<Integer> percentages;

    public PercentTransaction(User payer, List<User> users, double amount, List<Integer> percentages) {
        super(payer, users, amount);
        this.percentages = percentages;
    }

    public List<Integer> getPercentages() {
        return percentages;
    }
}
