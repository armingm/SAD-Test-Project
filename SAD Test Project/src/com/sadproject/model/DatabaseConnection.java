package com.sadproject.model;

import java.sql.*;
import com.sadproject.model.exceptions.DatabaseConnectionException;

public class DatabaseConnection {
    private Connection connection = null;
    public void openConnection(String serverName, String username, String password, String databaseName) throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + serverName + "/" + databaseName + "?user=" + username + "&password=" + password);
        } catch (ClassNotFoundException e){
            throw new DatabaseConnectionException(DatabaseConnectionException.ERR_NO_DRIVER);
        }
    }
    public ResultSet doQuery(String query) throws SQLException{
        if (connection == null){
            throw new DatabaseConnectionException(DatabaseConnectionException.ERR_CONNECTION_NOT_ESTABLISHED);
        }
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }
    public void doUpdate(String query) throws SQLException{
        if (connection == null){
            throw new DatabaseConnectionException(DatabaseConnectionException.ERR_CONNECTION_NOT_ESTABLISHED);
        }
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }
}
