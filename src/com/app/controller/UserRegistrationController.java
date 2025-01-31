package com.app.controller;

import com.app.model.Users;
import com.app.view.UserAuthenticationView;

import java.util.Scanner;

// USER REGISTRATION CONTROLLER:
// - Handles the logic for registering a new user account.
public class UserRegistrationController {

    private Users model;  // The model class (Users) that will store the user data
    private UserAuthenticationView uaView;  // The view class that will display messages to the user
    private Scanner scanner;

    public UserRegistrationController(Users model, UserAuthenticationView uaView) {
        this.model = model;
        this.uaView = uaView;
        this.scanner = new Scanner(System.in);
    }

    // Method to start the registration process
    public void startRegistration() {
        uaView.displayRegistrationMenu();  // Display the registration prompt

        // Collect user details for registration
        collectUserDetails();
    }

    // Collect user details for registration
    private void collectUserDetails() {
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your mobile number: ");
        long mobileNumber = scanner.nextLong();

        // Ensure the mobile number is not already registered
        if (model.verifyUserMobileNumber(mobileNumber)) {
            System.out.println("This mobile number is already registered. Please try again with a different number.");
            collectUserDetails();  // Retry registration if the number is already taken
            return;
        }

        System.out.println("Enter your MPIN (4 digits): ");
        int mpin = scanner.nextInt();

        // Create a new user object and insert the data into the database
        Users newUser = new Users(name, mpin, mobileNumber, 0);  // Assuming balance starts at 0
        boolean registrationSuccess = model.addUser(newUser);  // Add the new user to the database

        // Notify the user based on the registration result
        if (registrationSuccess) {
            System.out.println("Registration successful! You can now log in.");
        } else {
            System.out.println("Registration failed. Please try again.");
        }
    }
}
