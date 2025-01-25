package org.example.service;

public abstract class UserServiceUtils {

    private static UserService instance;

    public static UserService getInstance() {
        if ( instance == null ) {
            instance = new UserService();
        }
        return instance;
    }
}
