package org.LLD.entities;

public class Show {
    private User userId;

    public Show() {
    }

    public Show(User userId) {
        this.userId = userId;
    }

    public User getUserId() {
        return userId;
    }
}
