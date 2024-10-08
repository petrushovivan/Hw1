package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class User {

    private ArrayList<Habit> habits = new ArrayList<>();

    private String email;

    private String password;

    private String name;

    public User(String email, String password, String name) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, name);
    }

    public void addHabit(Habit habit){
        habits.add(habit);
    }

    public void removeHabit(Habit habit){
        habits.remove(habit);
    }

    public ArrayList<Habit> getHabits(){
        return habits;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String toString(){
        return "Email: " + email + "\nPassword: " + password + "\nName: " + name;
    }

}