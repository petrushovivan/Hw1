package org.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HabitMenu {

    private Scanner scanner = new Scanner(System.in);

    private User user;

    public HabitMenu(User user){
        this.user = user;
    }

    public void showMenu(){
        System.out.println(user.getName()+ " habits");
        System.out.println("1. Show habits\n2. Sort habits\n3. Add habit" +
                "\n4. Remove habit\n5. Point habit\n6. Make a note" +
                "\n7. Show my note\n8. Go to user menu");
        String choice = scanner.nextLine();
        int number;
        try {
            number = Integer.parseInt(choice);
        }
        catch (NumberFormatException e) {
            System.out.println("Please enter a number between 1 and 8");
            showMenu();
            return;
        }
        if (number == 1) {//1. Show habits
            System.out.println(user.getHabits());
            showMenu();
            return;
        }
        else if (number == 2) {//Sort habits
            sortHabits();
            showMenu();
            return;
        }
        else if (number == 3) {//3. Add habits
            addHabit();
            showMenu();
            return;
        }
        else if(number == 4){//remove habit
            removeHabit();
            showMenu();
            return;
        }
        else if(number == 5){

        }
        else if(number == 6){//5. Make a note
            makeNote();
            showMenu();
            return;
        }
        else if (number == 7) {//Show my note
            showNote();
            showMenu();
            return;
        }
        else if(number == 8){ //Go to user menu
            UserMenu userMenu = new UserMenu(user);
            userMenu.showMenu();
            return;
        }
    }

    private void makeNote(){
        System.out.println("Name a habit");
        String habit = scanner.nextLine();
        System.out.println("Please enter a note");
        String note = scanner.nextLine();
        for(Habit h : user.getHabits()){
            if(h.getName().equals(habit)){
                h.setDescribe(note);
            }
        }
    }

    private String showNote(){
        System.out.println("Name a habit");
        String habit = scanner.nextLine();
        for(Habit h : user.getHabits()){
            if(h.getName().equals(habit)){
                return h.getDescribe();
            }
        }
        return null;
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

    private void sortHabits(){
        boolean ok = true;
        int answer = 0;
        while (ok){
            System.out.println("How sort habits?");
            System.out.println("1. Down date");
            System.out.println("2. Up date");
            try {
                answer = Integer.parseInt(scanner.nextLine());
                if(answer==1||answer==2){
                    ok = false;
                }
                else {
                    System.out.println("Please enter a number between 1 and 2");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Please enter a number between 1 and 2");
            }
        }
        if(answer == 1){
            Collections.sort(user.getHabits(), (o1, o2) -> o1.getDate().compareTo(o2.getDate()));
        }
        else if(answer == 2){
            Collections.sort(user.getHabits(), (o1, o2) -> o2.getDate().compareTo(o1.getDate()));
        }
    }
}
