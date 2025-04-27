package org.LLD.repository;

import org.LLD.entities.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserRepository
{
    private static HashMap<String, User> users = new HashMap<>();

    public static List<User> getAllUsers()
    {
        return new ArrayList<>(users.values());
    }

    public synchronized static User getOrCreate(String userId)
    {
        if(users.containsKey(userId))
            return users.get(userId);

        User user = new User(userId);
        users.put(userId, user);
        return user;
    }
}
