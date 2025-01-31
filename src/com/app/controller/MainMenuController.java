package com.app.controller;

import com.app.model.Users;
import com.app.view.MainMenuView;

//MAIN MENU CONTROLLER
// - Handles the main menu view, logic, and interaction with user database.

public class MainMenuController {

    private Users model;
    private MainMenuView mainMenuView;

    public MainMenuController(Users model, MainMenuView mainMenuView) {
        this.model = model;
        this.mainMenuView = mainMenuView;
    }

    public MainMenuController() {

    }

    //START OF THE MAIN MENU:
    public void startMainMenuController() {
        mainMenuView.displayMainMenu();
    }

}
