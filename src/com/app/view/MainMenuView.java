package com.app.view;

//MAIN MENU VIEW
// - Handles display for main menu

public class MainMenuView {

    public void greetUser() {
        System.out.println("Welcome ");
    }

    public void displayMainMenu(){

        System.out.println("======MAIN MENU======");

        System.out.println("Please select a number: " +
                " \n 1: Mobile load" +
                " \n 2: Transfer money"+
                " \n 3: Send money"+
                " \n 4: Pay bills"+
                " \n 5: Shop online"+
                //" \n 4: Check balance"+
                " \n 6: Exit");

    }

    public void displayUserBalance() {
        System.out.println("Your balance: ");
    }

}
