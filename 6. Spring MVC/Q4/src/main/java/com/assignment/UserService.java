package com.assignment;

public interface UserService {
    public abstract void createUser(User user);
    public abstract User getUserByUserName(String userName);
}
