package main.interfaces;

import main.entity.User;

public interface UserService {
    User saveAndReturnCache(User user);
    User saveAndRefreshCache(User user);
    User getUserById(int id);
}
