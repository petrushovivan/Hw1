package org.example;

import java.util.Scanner;

public class UserMenu {
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
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        System.out.println(choice);
    }

    private void changeEmail(String email){
        user.setEmail(email);
    }

    private void changePassword(String password){
        user.setPassword(password);
    }

    private void changeName(String name){
        user.setName(name);
    }


}
