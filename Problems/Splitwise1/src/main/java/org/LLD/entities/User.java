package org.LLD.entities;

import java.util.HashMap;
import java.util.Objects;

public class User {

    private String userId;

    private String userName;

    private String userEmail;

    private String userPhone;

    private HashMap<User, Double> balances;

    public User(String userId) {
        this.userId = userId;
        initBalances();
    }

    public User(String userId, String userName, String userEmail, String userPhone) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        initBalances();
    }

    private void initBalances()
    {
        balances = new HashMap<>();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public HashMap<User, Double> getBalances() {
        return balances;
    }

    public void setBalances(HashMap<User, Double> balances) {
        this.balances = balances;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userId);
    }

}
