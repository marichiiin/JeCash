package com.app.dao.impl;

import com.app.dao.UsersDAO;
import com.app.model.Users;
import com.app.util.DbConnection;
import com.app.util.QueryConstants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.app.controller.UserAuthenticationControllerV2.currentMobileNumber;
import static com.app.util.QueryConstants.RETRIEVE_MPIN;
import static com.app.util.QueryConstants.RETRIVE_MOBILE_NUMBER;
//import static com.app.util.QueryConstants.column1;

//USERS DAO IMPLEMENTATION V2
public class UsersDAOImplV2 extends DbConnection implements UsersDAO {

    QueryConstants queryConstants = new QueryConstants();


    //public static boolean mobileNumExists = false; //indicates if mobileNumber is found or not.
    @Override
    //public void verifyMobileNumber(int currentMobileNumber) {
    public boolean verifyMobileNumber(long currentMobileNumber) { //verify if current mobile number exists in database:

        ResultSet rs;

        try {

            PreparedStatement ps = connection.prepareStatement(RETRIVE_MOBILE_NUMBER);
            ps.setLong(1, currentMobileNumber); //change to long data type
            rs = ps.executeQuery();

            //scan table for currentMobileNumber:
            while (rs.next()) {
                if (rs.getLong(queryConstants.getColumn1()) == currentMobileNumber) { //compare current mobile number to mobile numbers in "phoneNumber" column.
                    return true;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean verifyMPIN(int MPIN){

        ResultSet rs;

        try {

            PreparedStatement ps = connection.prepareStatement(RETRIEVE_MPIN);
            ps.setLong(1, currentMobileNumber); //checks the MPIN of current user-inputted mobile number
            rs = ps.executeQuery();

            //scan table for MPIN:
            while (rs.next()) {
                if (rs.getInt(queryConstants.getColumn2()) == MPIN) { //compare current mobile number to mobile numbers in "phoneNumber" column.
                    return true;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
    @Override
    public boolean insertUser(Users newUser) {
        String insertQuery = "INSERT INTO tblusers (Name, Mobile_Number, MPIN, Balance) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(insertQuery);
            ps.setString(1, newUser.getName());  // Set the user's name
            ps.setLong(2, newUser.getMobileNumber());  // Set the user's mobile number
            ps.setInt(3, newUser.getMPIN());  // Set the user's MPIN
            ps.setInt(4, newUser.getBalance());  // Set the initial balance (e.g., 0)

            int rowsAffected = ps.executeUpdate();  // Execute the insert query
            return rowsAffected > 0;  // Return true if the user was successfully inserted
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Return false if there was an error
        }
    }

}
