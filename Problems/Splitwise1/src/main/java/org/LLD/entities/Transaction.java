package org.LLD.entities;

import java.util.List;

public class Transaction{

    private User payer;

    private List<User> users;

    private double amount;

    public Transaction(User payer, List<User> users, double amount) {
        this.payer = payer;
        this.users = users;
        this.amount = amount;
    }

    public User getPayer() {
        return payer;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
