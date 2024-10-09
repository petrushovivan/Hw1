package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {

    private Scanner scanner = new Scanner(System.in);

    private ArrayList<User> users;

    public Admin(ArrayList<User> users){
        this.users = users;
    }

    public void showMenu(){
        System.out.println("Admin Menu" +
                "\n1. Watch users\n2. Remove user\n3. Exit");
        String choice = scanner.nextLine();
        int number;
        try {
            number = Integer.parseInt(choice);
        }
        catch (NumberFormatException e) {
            System.out.println("Please enter a number between 1 and 3");
            showMenu();
            return;
        }
        if(number == 1){
            for(User user : users){
                System.out.println(user);
                System.out.println("---------------");
            }
            showMenu();
            return;
        }
        else if(number == 2){
            System.out.println("Enter the user email");
            String email = scanner.nextLine();
            for(User user : users){
                if(user.getEmail().equals(email)){
                    users.remove(user);
                    Main.emails.remove(email);
                    break;
                }
            }
            showMenu();
            return;
        }
        else if(number == 3){
            Main.main(null);
            return;
        }
    }
}
