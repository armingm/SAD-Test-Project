package com.sadproject.model.exceptions;

import java.sql.SQLException;

public class DatabaseConnectionException extends SQLException {
    public final static int ERR_NO_DRIVER = 0;
    public final static int ERR_CONNECTION_NOT_ESTABLISHED = 1;
    private int type = -1;
    public DatabaseConnectionException(int type){
        super();
        this.type = type;
    }
    @Override
    public String getMessage(){
        switch (type){
            case ERR_NO_DRIVER:
                return "No driver detected.";
            case ERR_CONNECTION_NOT_ESTABLISHED:
                return "Trying to do query before establishing connection.";
            default:
                return "Unknown error.";
        }
    }
}
