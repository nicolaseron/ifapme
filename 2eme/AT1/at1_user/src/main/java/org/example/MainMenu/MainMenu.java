package org.example.MainMenu;

import org.example.actionMenu.*;
import org.example.auth.AuthMenu;
import org.example.exception.BusinessException;
import org.example.model.User;

public class MainMenu extends BaseMenu {

    AuthMenu authMenu = new AuthMenu();
    User user = authMenu.login();
    ListUserMenu listUserMenu = new ListUserMenu();
    CreateUserMenu createUserMenu = new CreateUserMenu();
    UpdateUserMenu updateUserMenu = new UpdateUserMenu();
    DeleteUserMenu deleteUserMenu = new DeleteUserMenu();
    ModifyPasswordMenu modifyPasswordMenu = new ModifyPasswordMenu();

    public MainMenu() throws BusinessException {
    }


    public void execute() throws BusinessException {

        while (true) {
            System.out.println("1 -> Lister les utilisateurs");
            System.out.println("2 -> Créer un utilisateur");
            System.out.println("3 -> Modifier un utilisateur");
            System.out.println("4 -> Effacer un utilisateur");
            System.out.println("5 -> Voir mes informations");
            System.out.println("6 -> Modifier mon mot de passe");
            System.out.println("7 -> Quitter");

            String choice = printQuestion("Veuillez choisir une option (1-7):");

            switch (choice) {
                case "1":
                    listUserMenu.execute();
                    break;
                case "2":
                    createUserMenu.execute();
                    break;
                case "3":
                    updateUserMenu.execute();
                    break;
                case "4":
                    deleteUserMenu.execute();
                    break;
                case "5":
                    System.out.println(user.toString());
                    break;
                case "6":
                    modifyPasswordMenu.execute(user);
                    break;
                case "7":
                    System.out.println("Au revoir!");
                    return;
                default:
                    System.out.println("Option invalide!");
            }
        }
    }

    @Override
    public void execute(User user) throws BusinessException {

    }
}