package org.example;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static HashSet<String> emails = new HashSet<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int choice = startMenu();
        if(choice == 1){//Register

            System.out.println("Registration");
            User newUser = registration();
            while(emails.contains(newUser.getEmail())){
                System.out.println("Email already in use");
                newUser = registration();
            }
            emails.add(newUser.getEmail());
            UserMenu userMenu = new UserMenu(newUser);
            userMenu.showMenu();

        }
        else if(choice == 2){ //Login1
        }
    }

    private static int startMenu(){
        System.out.println("1. Register");
        System.out.println("2. Login");
        String num = sc.nextLine();
        int request;
        try{
            request = Integer.parseInt(num);
        }
        catch (NumberFormatException e){
            System.out.println("Pleas enter 1 or 2");
            return startMenu();
        }
        if(request == 1 || request ==2)
            return request;
        else {
            System.out.println("Pleas enter 1 or 2");
            return startMenu();
        }
    }

    private static User registration(){
        System.out.println("Enter your email");
        String email = sc.nextLine();
        System.out.println("Enter your password");
        String password = sc.nextLine();
        System.out.println("Enter your name");
        String firstName = sc.nextLine();

        return new User(email, password, firstName);
    }
}