package com.assignment;

public interface UserDAO {
    public abstract void createUser(User user);
    public abstract User getUserByUserName(String userName);
}
