package com.app.view;

//import com.app.controller.UserAuthenticationControllerV2;

//USER AUTHENTICATION VIEW:
// - Handles graphical user interface, i.e. display stuff.

public class UserAuthenticationView {

    //public void displayUserAuthenticationMenu(UserAuthenticationController uaController) {
    public void displayUserAuthenticationMenu() {
        System.out.println("Please select a number: " +
                " \n 1: Log In" +
                " \n 2: Register"+
                " \n 3: Exit");

    }

    public void displayLoginMenu(){
        System.out.println("=====USER LOGIN=====");
        System.out.println("Enter your mobile number: \n");


    }

    public void displayMessageCorrectMobileNum(){
        System.out.println("Mobile number is registered!\n");
    }

    public void displayErrorIncorrectMobileNum(){
        System.out.println("Mobile number is not registered yet!\n");
    }

    public void displayEnterMPIN(){
        System.out.println("Enter your MPIN: ");
    }

    public void displayMessageCorrectMPIN() {
        System.out.println("MPIN is correct!\n");
    }

    public void displayMessageIncorrectMPIN() {
        System.out.println("MPIN is incorrect! Please try again!\n");
    }

    public void displayRegistrationMenu() {
        System.out.println("Welcome to the registration page!");
        System.out.println("Please enter the following details to create a new account:");
    }



    public void programExited() {
        System.out.println("Program Exited");
    }

}
