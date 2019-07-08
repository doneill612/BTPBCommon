package com.btpb.common.exceptions;

public class BTPBInvalidIdException extends BTPBException {

    public BTPBInvalidIdException() {
        super(BTPBExceptionType.INVALID_ID);
    }

    public BTPBInvalidIdException(Exception innerException) {
        super(BTPBExceptionType.INVALID_ID, innerException);
    }

    public BTPBInvalidIdException(String details) {
        super(BTPBExceptionType.INVALID_ID, details);
    }

    public BTPBInvalidIdException(Exception innerException, String details) {
        super(BTPBExceptionType.INVALID_ID, innerException, details);
    }
}
