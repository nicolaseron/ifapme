package org.example.MainMenu;

import org.example.exception.BusinessException;
import org.example.model.User;

import java.util.Scanner;

public abstract class BaseMenu implements Menu {
    private final Scanner scanner = new Scanner(System.in);

    public String printQuestion(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    public void continueMessage() {
        System.out.println("Appuyer sur une touche pour continuer ...");
        scanner.nextLine();
    }

    public abstract void execute(User user) throws BusinessException;
}
