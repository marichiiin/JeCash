package com.app.model;

import com.app.dao.UsersDAO;
import com.app.dao.impl.UsersDAOImplV2;

//USERS MODEL
// - Connects with UsersDAO to access data.
// - Once connected, model interacts with controller to do something (e.g. update view, verification, etc).


public class Users {

    private String name;
    private int MPIN;
    private long mobileNumber;
    private int balance;

    private UsersDAO usersDAO; //connect user model to userDAO interface to access data from database & do CRUD operations (in DAOImpl).
    //private UsersDAOImpl usersDAOImpl; //reduces code flexibility, bad.

    //CONSTRUCTOR:
    public Users(String name, int MPIN, long mobileNumber, int balance){
        this.name = name;
        this.MPIN = MPIN;
        this.mobileNumber = mobileNumber;
        this.balance = balance;
    }

    //OVERLOADED CONSTRUCTOR:
    public Users(){
        //usersDAOImpl = new UsersDAOImpl(); //reduces code flexibility, bad.

        //INTERFACE INSTANTIATION TECHNIQUE: creating objects of classes that implement the interface, rather than the interface itself.
        usersDAO = new UsersDAOImplV2(); //connects Users model to UsersDAOImpl for CRUD operations
        //once UsersDAOImplV2 is instantiated, it automatically connects to the database via the DbConnection constructor.
    }

    //verifyUserMobileNumber METHOD:
    public boolean verifyUserMobileNumber(long currentMobileNumber){
        return usersDAO.verifyMobileNumber(currentMobileNumber);
        //return false;
    }

    public boolean verifyMPIN(int MPIN){
        return usersDAO.verifyMPIN(MPIN);
    }

    //SETTERS & GETTERS:
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMPIN() {
        return MPIN;
    }

    public void setMPIN(int MPIN) {
        this.MPIN = MPIN;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean addUser(Users newUser) {
        UsersDAO usersDAO = new UsersDAOImplV2();  // Use DAO to handle database interaction
        return usersDAO.insertUser(newUser);  // Call the insertUser method of the DAO to add the user
    }


}
