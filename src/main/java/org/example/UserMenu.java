package org.example;

import java.util.Scanner;

public class UserMenu {
    Scanner scanner = new Scanner(System.in);
    private User user;
    public UserMenu(User user) {
        this.user = user;
    }

    public void showMenu(){
        System.out.println("Hello "+user.getName() +
                " \n1. Change email\n2. Change password" +
                "\n3. Change name\n4. Show habits" +
                "\n5. Change habits\n6. Show my info" +
                "\n7. Remove profile");
        String choice = scanner.nextLine();
        int number;
        try {
            number = Integer.parseInt(choice);
        }
        catch (NumberFormatException e) {
            System.out.println("Please enter a number between 1 and 6");
            showMenu();
            return;
        }
        if(number == 1){ // 1. Change email
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
        else if (number == 4) {//4. Show habits
            System.out.println(user.getHabits());
            showMenu();
            return;
        }
        else if (number == 5) {//5. Change habits

        }
        else if(number == 6){//6. Show my info
            System.out.println("Your name is "
                    +user.getName()+" your email is "+user.getEmail()+" your password is "+user.getPassword());
            showMenu();
            return;
        }
        else if(number == 7){
            Main.emails.remove(user.getEmail());
            Main.main(new String[]{""});
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
