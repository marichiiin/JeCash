package com.app.dao;

//USERS DAO interface
// - A container of methods
// - Contains SQL queries and database interaction logic.

public interface UsersDAO {

    boolean verifyMobileNumber(long currentMobileNumber);
    boolean verifyMPIN(int MPIN);
}
