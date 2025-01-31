package com.app.dao;

import com.app.model.Users;

//USERS DAO interface
// - A container of methods
// - Contains SQL queries and database interaction logic.

public interface UsersDAO {

    boolean verifyMobileNumber(long currentMobileNumber);
    boolean verifyMPIN(int MPIN);
    boolean insertUser(Users newUser);  // Insert a new user into the database
