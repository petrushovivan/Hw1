package org.example;

import java.util.Date;
import java.util.Scanner;

public class HabitMenu {
    private Scanner scanner = new Scanner(System.in);
    private User user;
    public HabitMenu(User user){
        this.user = user;
    }
    public void showMenu(){
        System.out.println(user.getName()+ " habits");
        System.out.println("1. Show habits\n2. Add habit" +
                "\n3. Mark habits\n4. Go to user menu");
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
        if (number == 1) {//1. Show habits
            System.out.println(user.getHabits());
            showMenu();
            return;
        }
        else if (number == 2) {//2. Add habits
            addHabit();
            showMenu();
            return;
        }
        else if(number == 3){//remove habit
            removeHabit();
            showMenu();
            return;
        }
        else if(number == 4){
            UserMenu userMenu = new UserMenu(user);
            userMenu.showMenu();
            return;
        }
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
