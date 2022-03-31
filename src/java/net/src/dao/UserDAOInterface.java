package net.src.dao;

import net.src.User;

public interface UserDAOInterface {
    
    public String verifyIfExistsUser(User user);
    public boolean registerUser(User user);
    public boolean updateUser(User user);
    public boolean removeUser(User user);
}
