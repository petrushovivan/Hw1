package org.example;

import java.util.Scanner;

public class UserMenu {
    Scanner scanner = new Scanner(System.in);
    private User user;
    public UserMenu(User user) {
        this.user = user;
    }
    public void remove(){
        Main.main(new String[]{""});
    }

    public void showMenu(){
        System.out.println("Hello "+user.getName() +
                " \n1. Change email\n2. Change password" +
                "\n3. Change name\n4. Show habits" +
                "\n5. Change habits\n6. Show my info");
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
        if(number == 1){
            changeEmail();
            showMenu();
            return;
        }
        if(number == 6){
            System.out.println(user.getName()+" "+user.getPassword()+" "+user.getEmail());
            showMenu();
            return;
        }
    }

    private void changeEmail(){
        System.out.println("Please enter your new email address");
        String newEmail = scanner.nextLine();
        user.setEmail(newEmail);
        System.out.println("Your new email address has been changed");
    }

    private void changePassword(String password){
        user.setPassword(password);
    }

    private void changeName(String name){
        user.setName(name);
    }


}
