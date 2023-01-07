package com.Syntax;

import java.sql.*;

public class DataBaseTest {

    public static void main(String[] args) {


        /*
        To build connection to the database, we need 3 things
        URL, username, password
     */

        String url = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";

        try {
            // 1. Connection to the database
            Connection conn = DriverManager.getConnection(url, username, password);

            // 2. Create a statement object to send SQL queries
            Statement st = conn.createStatement();

            // 3. Using a statement object, we are sending query and database returns
            //    an object of resultset (table with rows and columns)
            ResultSet rset = st.executeQuery("select FirstName, LastName from person;");

            rset.next();
            String fName = rset.getString("FirstName");
            String lName = rset.getString("LastName");
            System.out.println(fName + " " + lName);

            rset.next();
            fName = rset.getString("FirstName");
            lName = rset.getString("LastName");
            System.out.println(fName + " " + lName);

            System.out.println("---EXTRACTING DATA FROM RESULTSET USING LOOP---");

            while(rset.next())
            {
                fName = rset.getString("FirstName");
                lName = rset.getString("LastName");
                System.out.println(fName + " " + lName);
            }


            System.out.println("Connection is created");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
