package com.btpb.common.exceptions;

public class BTPBInvalidPasswordException extends BTPBException {

    public BTPBInvalidPasswordException() {
        super(BTPBExceptionType.INVALID_PASSWORD);
    }

    public BTPBInvalidPasswordException(Exception innerException) {
        super(BTPBExceptionType.INVALID_PASSWORD, innerException);
    }

    public BTPBInvalidPasswordException(String details) {
        super(BTPBExceptionType.INVALID_PASSWORD, details);
    }

    public BTPBInvalidPasswordException(Exception innerException, String details) {
        super(BTPBExceptionType.INVALID_PASSWORD, innerException, details);
    }
}
