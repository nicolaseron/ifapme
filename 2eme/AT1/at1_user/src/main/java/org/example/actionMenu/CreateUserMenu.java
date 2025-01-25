package org.example.actionMenu;

import org.example.MainMenu.BaseMenu;
import org.example.exception.BusinessException;
import org.example.model.User;
import org.example.service.UserServiceUtils;
import org.example.service.UserService;

public class CreateUserMenu extends BaseMenu {

    UserService userService = UserServiceUtils.getInstance();

    @Override
    public void execute() {
        String firstname = printQuestion("Veuillez entrer le prénom de l'utilisateur:");
        String lastname = printQuestion("Veuillez entrer le nom de l'utilisateur:");

        String confirm = printQuestion("Créer l'utilisateur ? (o/n):");
        if ("o".equalsIgnoreCase(confirm)) {
            userService.createUser(firstname, lastname);
            System.out.println("Utilisateur créé avec succès!");
        } else {
            System.out.println("Création annulée.");
        }

        continueMessage();
    }

    @Override
    public void execute(User user) throws BusinessException {

    }
}

