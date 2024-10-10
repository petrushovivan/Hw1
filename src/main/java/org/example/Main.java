package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    static ArrayList<User> registeredUsers = new ArrayList<>();

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
            registeredUsers.add(newUser);
            UserMenu userMenu = new UserMenu(newUser);
            userMenu.showMenu();

        }
        else if(choice == 2){ //Login
            System.out.println("Login");
            User newUser = login();
            boolean found = false;
            for(User user : registeredUsers){
                if (user.getEmail().equals(newUser.getEmail())&&
                user.getPassword().equals(newUser.getPassword())){
                    newUser = user;
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("User not found");
                main(new String[0]);
            }
            UserMenu userMenu = new UserMenu(newUser);
            userMenu.showMenu();
        }
        else if(choice == -715_827_882){
            Admin admin = new Admin(registeredUsers);
            admin.showMenu();
            return;
        }
    }

    private static int startMenu() {
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
        if(request == 1 || request == 2 || request == -714_837_879)// number -714837879 for admin login
            return request;
        else {
            System.out.println("Pleas enter 1 or 2");
            return startMenu();
        }
    }

    private static User registration(){
        System.out.println("Enter your email");
        String email = sc.nextLine();
        while (!email.contains("@")){
            System.out.println("Enter your email");
            email = sc.nextLine();
        }
        System.out.println("Enter your password");
        String password = sc.nextLine();
        System.out.println("Enter your name");
        String firstName = sc.nextLine();

        return new User(email, password, firstName);
    }

    private static User login(){
        System.out.println("Enter your email");
        String email = sc.nextLine();
        while (!email.contains("@")){
            System.out.println("Enter your email");
            email = sc.nextLine();
        }
        System.out.println("Enter your password");
        String password = sc.nextLine();
        return new User(email, password, "");
    }
}