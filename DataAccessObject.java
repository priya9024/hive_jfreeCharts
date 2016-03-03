package com.simplecodestuffs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataAccessObject {
        private static Connection connection = null;

        public static Connection getConnection() {
                if (connection != null)
                        return connection;
                else {
                       
                try {
                Class.forName("org.apache.hive.jdbc.HiveDriver");
                // set the url, username and password for the database
                connection = DriverManager.getConnection("jdbc:hive2://localhost:10000/default", "hue", "1111");
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return connection;
        }
        }
}
