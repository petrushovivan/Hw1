package org.example;

import java.util.Scanner;

public class SettingsMenu {

    private Scanner scanner = new Scanner(System.in);

    private User user;

    public SettingsMenu(User user) {
        this.user = user;
    }

    public void showMenu(){
        System.out.println("Hello "+user.getName() +
                "\n1. Change email\n2. Change password" +
                "\n3. Change name\n4. Go to user menu");
        String choice = scanner.nextLine();
        int number;
        try {
            number = Integer.parseInt(choice);
        }
        catch (NumberFormatException e) {
            System.out.println("Please enter a number between 1 and 4");
            showMenu();
            return;
        }
        if(number == 1){ // 1. Change email
            Main.emails.remove(user.getEmail());
            changeEmail();
            showMenu();
            return;
        } else if (number == 2) {//2. Change password
            changePassword();
            showMenu();
            return;
        }
        else if (number == 3) {//3. Change name
            changeName();
            showMenu();
            return;
        }
        else if(number == 4){
            UserMenu userMenu = new UserMenu(user);
            userMenu.showMenu();
            return;
        }
    }

    private void changeEmail(){
        System.out.println("Please enter your new email address");
        String newEmail = scanner.nextLine();
        user.setEmail(newEmail);
        System.out.println("Your new email address has been changed");
    }

    private void changePassword(){
        System.out.println("Please enter your new password");
        String newPassword = scanner.nextLine();
        user.setPassword(newPassword);
        System.out.println("Your new password has been changed");
    }

    private void changeName(){
        System.out.println("Please enter your new name");
        String newName = scanner.nextLine();
        user.setName(newName);
        System.out.println("Your new name has been changed");
    }

}
