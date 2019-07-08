package com.btpb.common.exceptions;

public class DBReadException extends BTPBException {

    public DBReadException() {
        super(BTPBExceptionType.DB_READ);
    }

    public DBReadException(Exception innerException) {
        super(BTPBExceptionType.DB_READ, innerException);
    }

    public DBReadException(String details) {
        super(BTPBExceptionType.DB_READ, details);
    }

    public DBReadException(Exception innerException, String details) {
        super(BTPBExceptionType.DB_READ, innerException, details);
    }
}
