package com.app.controller;

import com.app.model.Users;
import com.app.view.MainMenuView;

import java.util.Scanner;
//MAIN MENU CONTROLLER
// - Handles the main menu view, logic, and interaction with user database.


public class MainMenuController {

    private Users model;
    private MainMenuView mainMenuView;
    private Scanner scanner;

    public MainMenuController(Users model, MainMenuView mainMenuView) {
        this.model = model;
        this.mainMenuView = mainMenuView;
        this.scanner = new Scanner(System.in);
    }

    //START OF THE MAIN MENU:
    public void startMainMenuController() {
        mainMenuView.greetUser();
        mainMenuView.displayMainMenu();
        handleMenuSelection(); // Call method to handle user's selection
    }

    //Handles user's selection in the main menu
    private void handleMenuSelection() {
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                // Mobile Load logic goes here
                mobileLoad();
                break;
            case 2:
                // Transfer Money logic goes here
                transferMoney();
                break;
            case 3:
                // Send Money logic goes here
                sendMoney();
                break;
            case 4:
                // Pay Bills logic goes here
                payBills();
                break;
            case 5:
                // Shop Online logic goes here
                shopOnline();
                break;
            case 6:
                // Exit program
                exitProgram();
                break;
            default:
                System.out.println("Invalid selection. Please try again.");
                handleMenuSelection();  // Recursion to ask again
        }
    }
    // Placeholder for mobile load feature
    private void mobileLoad() {
        System.out.println("Mobile Load feature is selected.");
        // Logic for mobile load would be here
    }

    // Placeholder for transferring money feature
    private void transferMoney() {
        System.out.println("Transfer Money feature is selected.");
        // Logic for transferring money would be here
    }

    // Placeholder for sending money feature
    private void sendMoney() {
        System.out.println("Send Money feature is selected.");
        // Logic for sending money would be here
    }

    // Placeholder for paying bills feature
    private void payBills() {
        System.out.println("Pay Bills feature is selected.");
        // Logic for paying bills would be here
    }

    // Placeholder for shopping online feature
    private void shopOnline() {
        System.out.println("Shop Online feature is selected.");
        // Logic for online shopping would be here
    }

    // Exit the program
    private void exitProgram() {
        System.out.println("Exiting the program.");
        System.exit(0);  // Exit the application
    }
}
