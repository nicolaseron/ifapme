package org.example.actionMenu;

import org.example.MainMenu.BaseMenu;
import org.example.auth.AuthMenu;
import org.example.exception.BusinessException;
import org.example.model.User;
import org.example.service.UserService;
import org.example.service.UserServiceUtils;
import org.example.utils.bcrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModifyPasswordMenu extends BaseMenu {
    private static final Logger log = LoggerFactory.getLogger(AuthMenu.class);
    UserService userService = UserServiceUtils.getInstance();

    @Override
    public void execute(User user) throws BusinessException {

        bcrypt bcrypt = new bcrypt();
        String password = printQuestion("Entrer votre mot de passe");

        if (!bcrypt.comparePassword(password, user.getPassword())) {
            System.out.println("Mot de passe incorrect.");
        } else {
            System.out.println("Modification du mot de passe...");

            String pw1;
            String pw2;
            do {
                pw1 = printQuestion("Veuillez introduire un mot de passe : ");
                pw2 = printQuestion("Veuillez introduire une deuxième fois votre mot de passe : ");

                if (!pw1.equals(pw2)) {
                    System.out.println("Les mots de passe doivent être identiques. Veuillez essayer à nouveau.");
                }

            } while (!pw1.equals(pw2));

            String hashedPassword = bcrypt.hashPassword(pw1);
            user.setPassword(hashedPassword);
            userService.insertPasswordForCurrentUser(user.getUsername(), hashedPassword);
            System.out.println("Mot de passe modifié avec succès !");
            System.out.println("Connexion...");
            System.out.println("Vous êtes connecté !");
        }

    }

    @Override
    public void execute() throws BusinessException {
    }
}

