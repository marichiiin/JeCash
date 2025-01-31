package com.app.controller;

//MOTHER OF ALL CONTROLLERS
// - Responsible for program flow.
// - Program flow: User Authentication (Login, register, verify) -> Main Menu (storage of all app features) -> app features (get load, transfer money, pay bills, shop, etc.)
// - Ensures extra code decoupling. Instead of referencing a controller inside another controller to invoke/activate it. The Main Controller handles which controller should activate next.



import com.app.model.Users;
import com.app.view.MainMenuView;
import com.app.view.UserAuthenticationView;

public class MainController {

    private UserAuthenticationControllerV2 uaController;
    private MainMenuController mMController;

    public MainController(UserAuthenticationControllerV2 uaController, MainMenuController mMController) {
        this.uaController = uaController;
        this.mMController = mMController;
        startMainController(); //Automatically start everything once MainController object is created in main class.
    }

    public void startMainController() {

        //Run the program:
        //Intialize view, model, controller:
        Users model = new Users();  //Model
        UserAuthenticationView uaView = new UserAuthenticationView(); //View
        new UserAuthenticationControllerV2(model, uaView); //Controller

        if(UserAuthenticationControllerV2.authenticationSuccess){ //if true, execute code below (proceed to MainMenu)

            MainMenuView mMView = new MainMenuView();
            MainMenuController mMController = new MainMenuController(model, mMView);

            mMController.startMainMenuController();
        } else {
            System.out.println("AUTHENTICATION UNSUCCESSFUL");
        }


    }



}
