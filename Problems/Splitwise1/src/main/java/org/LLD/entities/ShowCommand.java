package org.LLD.entities;

import org.LLD.services.SplitWiseManager;

import java.util.List;

public class ShowCommand implements Command{
    private User user;

    public ShowCommand() {
    }

    public ShowCommand(User userId) {
        this.user = userId;
    }

    public User getUser() {
        return user;
    }

    @Override
    public List<String> execute(SplitWiseManager splitWiseManager) {
        return splitWiseManager.show(user);
    }
}
