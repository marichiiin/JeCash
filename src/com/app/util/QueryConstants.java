package com.app.util;

public class QueryConstants {

    private static final String column1 = "Mobile_Number";
    private static final String column2 = "MPIN";
    private static final String table1 = "tblusers";

    public static String RETRIVE_MOBILE_NUMBER = "SELECT "+column1+" FROM "+table1+" WHERE "+column1+" = ? ";
    public static String RETRIEVE_MPIN = "SELECT "+column2+" FROM "+table1+" WHERE "+column1+" = ? ";

    public String getColumn1() {
        return column1;
    }

    public String getColumn2() {
        return column2;
    }

}
