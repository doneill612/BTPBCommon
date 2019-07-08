package com.btpb.common.exceptions;

public class BTPBInvalidUserException extends BTPBException {

    public BTPBInvalidUserException() {
        super(BTPBExceptionType.INVALID_USER);
    }

    public BTPBInvalidUserException(Exception innerException) {
        super(BTPBExceptionType.INVALID_USER, innerException);
    }

    public BTPBInvalidUserException(String details) {
        super(BTPBExceptionType.INVALID_USER, details);
    }

    public BTPBInvalidUserException(Exception innerException, String details) {
        super(BTPBExceptionType.INVALID_USER, innerException, details);
    }
}
