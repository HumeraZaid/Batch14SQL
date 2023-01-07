package com.Syntax;

import java.sql.*;

public class DataBaseTest2 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select firstname, lastname, age, city " +
                    "from person where city is not null;");

            // ResultSetMetaData - object that contains information about the result table
            // information such as column names, number of columns
            ResultSetMetaData metaData = resultSet.getMetaData();

            for(int i = 1; i <= metaData.getColumnCount(); i++)
            {
                // Looping through each column and getting column name
                String columnName = metaData.getColumnName(i);
                System.out.println(columnName);
            }

            // We want to loop through every row and every column

            // Loops through row data in the resultset object
            while (resultSet.next())
            {
                // for loop iterates over each column
                for(int i = 1; i <= metaData.getColumnCount(); i++)
                {
                    // Using metadata to dynamically grab the column names
                    String value = resultSet.getString(metaData.getColumnName(i));

                    // Printing value of each column
                    System.out.print(value + " ");
                }
                // Creating a new line before moving to the next row
                System.out.println();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
