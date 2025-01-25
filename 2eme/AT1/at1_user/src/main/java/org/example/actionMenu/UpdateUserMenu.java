package org.example.actionMenu;

import org.example.MainMenu.BaseMenu;
import org.example.model.User;
import org.example.service.UserServiceUtils;
import org.example.exception.BusinessException;
import org.example.exception.UserNotFoundException;
import org.example.service.UserService;

public class UpdateUserMenu extends BaseMenu {
    UserService userService = UserServiceUtils.getInstance();

    @Override
    public void execute() throws BusinessException {
        int userId = 0;
        boolean validInput = false;

        while (!validInput) {
            String input = printQuestion("Veuillez entrer l'ID de l'utilisateur à modifier:");
            try {
                userId = Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("L'ID de l'utilisateur doit être un nombre valide. Veuillez réessayer.");
            }
        }

        if (!userService.isUserExist(userId)) {
            throw new UserNotFoundException(userId);
        }

        String firstname = printQuestion("Veuillez entrer le prénom de l'utilisateur:");
        String lastname = printQuestion("Veuillez entrer le nom de l'utilisateur:");

        String confirm = printQuestion("Modifier l'utilisateur ? (o/n):");
        if ("o".equalsIgnoreCase(confirm)) {
            userService.updateUser(userId, firstname, lastname);
        } else {
            System.out.println("Modification annulée.");
        }

        continueMessage();
    }

    @Override
    public void execute(User user) throws BusinessException {

    }
}
