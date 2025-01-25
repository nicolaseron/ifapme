package org.example.auth;

import org.example.MainMenu.BaseMenu;
import org.example.model.User;
import org.example.exception.BusinessException;
import org.example.service.UserService;
import org.example.service.UserServiceUtils;
import org.example.utils.bcrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthMenu extends BaseMenu {

    private static final Logger log = LoggerFactory.getLogger(AuthMenu.class);
    UserService userService = UserServiceUtils.getInstance();

    public User login() throws BusinessException {
        String username, password;
        bcrypt bcrypt = new bcrypt();
        User user;
        int chance = 0;

        while (true) {
            username = printQuestion("Entrer votre identifiant");
            password = printQuestion("Entrer votre mot de passe");

            user = userService.getUserByUsername(username);
            if (user == null) {
                System.out.println("Nom d'utilisateur ou mot de passe incorrect.");
                chance++;
            } else {
                if (user.getPassword() == null) {
                    System.out.println("C'est votre première connexion, création du mot de passe...");
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
                    userService.insertPasswordForCurrentUser(username, hashedPassword);

                    System.out.println("Mot de passe créé avec succès !");
                    System.out.println("Connexion...");
                    System.out.println("Vous êtes connecté !");
                    return user;
                } else {
                    if (!bcrypt.comparePassword(password, user.getPassword())) {
                        System.out.println("Nom d'utilisateur ou mot de passe incorrect.");
                        chance++;
                    } else {
                        System.out.println("Connexion...");
                        System.out.println("Vous êtes connecté !");
                        return user;
                    }
                }
            }

            if (chance >= 3) {
                System.out.println("Vous avez épuisé vos essais. Au revoir.");
                return null;
            }
        }
    }


    @Override
    public void execute() throws BusinessException {
    }

    @Override
    public void execute(User user) throws BusinessException {

    }
}
