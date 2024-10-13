package org.example;

import java.util.Scanner;


public class UserMenu {

    private Scanner scanner = new Scanner(System.in);

    private User user;

    public UserMenu(User user) {
        this.user = user;
    }


    public void showMenu(){
        System.out.println("Hello "+user.getName() + "\n1. Check habits" +
                "\n2. Show my info\n3. Remove profile\n4. Settings\n5. Menu");
        String choice = scanner.nextLine();
        int number;
        try {
            number = Integer.parseInt(choice);
        }
        catch (NumberFormatException e) {
            System.out.println("Please enter a number between 1 and 5");
            showMenu();
            return;
        }
        if (number == 1) {//4. Show habits
            HabitMenu habitMenu = new HabitMenu(user);
            habitMenu.showMenu();
            return;
        }
        else if(number == 2){//6. Show my info
            System.out.println("Your name is "
                    +user.getName()+" your email is "+user.getEmail()+" your password is "+user.getPassword());
            showMenu();
            return;
        }
        else if(number == 3){ // Remove profile
            Main.emails.remove(user.getEmail());
            Main.registeredUsers.remove(user);
            Main.main(new String[]{""});
            return;
        }
        else if(number == 4){ //settingsMenu
            SettingsMenu settingsMenu = new SettingsMenu(user);
            settingsMenu.showMenu();
            return;
        }
        else if (number == 5) {// menu
            Main.main(new String[]{""});
            return;
        }
    }
}
