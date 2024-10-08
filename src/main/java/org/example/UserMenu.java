package org.example;

import java.util.Date;
import java.util.Scanner;


public class UserMenu {
    Scanner scanner = new Scanner(System.in);
    private User user;
    public UserMenu(User user) {
        this.user = user;
    }

    public void showMenu(){
        System.out.println("Hello "+user.getName() +
                "\n1. Change email\n2. Change password" +
                "\n3. Change name\n4. Show habits" +
                "\n5. Add habits\n6. Show my info" +
                "\n7. Remove profile\n8. Remove habit" +
                "\n9. Menu");
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
        else if (number == 4) {//4. Show habits
            System.out.println(user.getHabits());
            showMenu();
            return;
        }
        else if (number == 5) {//5. Add habits
            addHabit();
            showMenu();
            return;
        }
        else if(number == 6){//6. Show my info
            System.out.println("Your name is "
                    +user.getName()+" your email is "+user.getEmail()+" your password is "+user.getPassword());
            showMenu();
            return;
        }
        else if(number == 7){ // Remove profile
            Main.emails.remove(user.getEmail());
            Main.main(new String[]{""});
            return;
        }
        else if(number == 8){//remove habit
            removeHabit();
            showMenu();
            return;
        }
        else if (number == 9) {
            Main.main(new String[]{""});
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

    private void addHabit(){
        System.out.println("Please enter your habit name");
        String habitName = scanner.nextLine();
        boolean ok = true;
        int year = 0, month = 0, day = 0;
        while (ok) {
            String[] date = new String[0];
            while (date.length!=3) {
                System.out.println("Please enter start time in format YYYY.MM.DD");
                date = scanner.nextLine().split("\\.");
            }

            try {
                year = Integer.parseInt(date[0]) - 1900;
                month = Integer.parseInt(date[1]) - 1;
                day = Integer.parseInt(date[2]);
                ok = false;
            } catch (NumberFormatException e) {
                ok = true;
            }
        }

        ok = true;
        int frequency = 0;
        while (ok){
            System.out.println("How many times a week?");
            try{
                frequency = Integer.parseInt(scanner.nextLine());
                if(frequency<=7&&frequency>=1) {
                    ok = false;
                }
            }
            catch (NumberFormatException e){
                ok = true;
            }
        }
        user.addHabit(new Habit(habitName, new Date(year, month, day), frequency));
        System.out.println("Your habit added");
    }

    private void removeHabit(){
        System.out.println("Please enter your habit name to remove");
        String habitName = scanner.nextLine();
        for(Habit hab : user.getHabits()){
            if(hab.getName().equals(habitName)){
                user.getHabits().remove(hab);
            }
        }
        System.out.println("Your habit removed");
    }
}
