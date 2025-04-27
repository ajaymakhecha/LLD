package org.LLD.entities;

import java.util.List;

public class EqualTransaction extends Transaction{

    public EqualTransaction(User payer, List<User> users, double amount) {
        super(payer, users, amount);
    }

}
