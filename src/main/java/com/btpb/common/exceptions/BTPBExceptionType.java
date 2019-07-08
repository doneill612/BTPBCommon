package com.btpb.common.exceptions;

public enum BTPBExceptionType {

    DB_READ("DBRead", "The object could not be read from the database."),
    DB_WRITE("DBWrite", "The object could not be written to the database."),
    DB_NO_SUCH_OBJECT("DBNoSuchObject", "The object requested does not exist in the database."),
    INVALID_USER("InvalidUser", "Username supplied does not exist for specified client ID."),
    INVALID_PASSWORD("InvalidPassword", "The password is incorrect."),
    INVALID_KEY("InvalidKey", "The supplied key is not valid."),
    INVALID_ID("InvalidId", "The supplied ID is not valid.");

    private String type;
    private String message;

    BTPBExceptionType(String type, String message)
    {
        this.type = type;
        this.message = message;
    }

    public String getType()
    {
        return type;
    }

    public String getMessage()
    {
        return message;
    }

}
