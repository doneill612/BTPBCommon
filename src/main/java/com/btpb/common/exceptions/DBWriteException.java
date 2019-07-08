package com.btpb.common.exceptions;

public class DBWriteException extends BTPBException {

    public DBWriteException() {
        super(BTPBExceptionType.DB_WRITE);
    }

    public DBWriteException(Exception innerException) {
        super(BTPBExceptionType.DB_WRITE, innerException);
    }

    public DBWriteException(String details) {
        super(BTPBExceptionType.DB_WRITE, details);
    }

    public DBWriteException(Exception innerException, String details) {
        super(BTPBExceptionType.DB_WRITE, innerException, details);
    }
}
