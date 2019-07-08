package com.btpb.common.exceptions;

public class BTPBInvalidKeyException extends BTPBException {

    public BTPBInvalidKeyException() {
        super(BTPBExceptionType.INVALID_KEY);
    }

    public BTPBInvalidKeyException(Exception innerException) {
        super(BTPBExceptionType.INVALID_KEY, innerException);
    }

    public BTPBInvalidKeyException(String details) {
        super(BTPBExceptionType.INVALID_KEY, details);
    }

    public BTPBInvalidKeyException(Exception innerException, String details) {
        super(BTPBExceptionType.INVALID_KEY, innerException, details);
    }
}
