        package com.app.controller;

import com.app.model.Users;
import com.app.view.UserAuthenticationView;

import java.util.Scanner;

//USER AUTHENTICATION CONTROLLER:
// - Handles user input:
// - Handles data retrieval INDIRECTLY. uaController -> user model (local storage) -> userDaoImpl -> DataBase (cloud storage).

public class UserAuthenticationControllerV2 {

    private Users model; //connect the controller to the model.
    private UserAuthenticationView uaView; //connect the controller to the view.
    public static boolean authenticationSuccess = false; //responsible for continuing the program.

    //UserAuthenticationController constructor:
    public UserAuthenticationControllerV2(Users model, UserAuthenticationView uaView){
        this.model = model; //accepts the User class
        this.uaView = uaView; //accepts the uaView class
        startController(); //starts the program whenever this constructor is used.
    }

    public UserAuthenticationControllerV2() {

    }

    //METHOD:
    //THE START of the program:
    public void startController() {
        uaView.displayUserAuthenticationMenu(); //display menu
        checkUserInput();                       //listen for user input
    }

    private static Scanner scanner;

    //Get input from user, after displaying uaMenu.
    public void checkUserInput(){

        scanner = new Scanner(System.in);

        int choice = scanner.nextInt();

        switch(choice){
            case 1:
                //uaView.displayLoginMenu();
                verifyMobileNumber();
                verifyMPIN();
                authenticationSuccess = true; //set authenticationSuccess to true once verification complete.
                break;
            case 2:
                // Call the UserRegistrationController to handle user registration
                UserRegistrationController registrationController = new UserRegistrationController(new Users(), new UserAuthenticationView());
                registrationController.startRegistration();  // Start the registration process
                break;
            case 3:
                //System.out.println("Program exited");
                uaView.programExited();
                break;
        }
    }

    //Logic for verifying user-inputted mobile number
    public static long currentMobileNumber;
    private void verifyMobileNumber() {

        uaView.displayLoginMenu();

        scanner = new Scanner(System.in);
        currentMobileNumber = scanner.nextLong();
        //Long.parseLong(currentMobileNumber);

        //Check if current mobile number exists in database:
        if(model.verifyUserMobileNumber(currentMobileNumber)) { //returns a boolean, true or false.
            uaView.displayMessageCorrectMobileNum(); //display if true (mobile number registered)
        } else {
            uaView.displayErrorIncorrectMobileNum(); //display if false (mobile number not registered)
            verifyMobileNumber(); //recursion
        }
    }

    //Logic for verifying user-inputted MPIN

    private void verifyMPIN() {

        uaView.displayEnterMPIN();

        scanner = new Scanner(System.in);
        int currentMPIN = scanner.nextInt();

        if(model.verifyMPIN(currentMPIN)) {
            uaView.displayMessageCorrectMPIN();
        } else {
            uaView.displayMessageIncorrectMPIN();
            verifyMPIN(); //recursion
        }


    }

}
