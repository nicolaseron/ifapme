package org.example;

import org.example.MainMenu.MainMenu;
import org.example.auth.AuthMenu;
import org.example.exception.BusinessException;

public class Main {
    public static void main(String[] args) throws BusinessException {
        MainMenu mainMenu = new MainMenu();
        mainMenu.execute();
    }
}