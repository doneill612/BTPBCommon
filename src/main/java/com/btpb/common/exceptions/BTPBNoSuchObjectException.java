package com.btpb.common.exceptions;

public class BTPBNoSuchObjectException extends BTPBException {

    public BTPBNoSuchObjectException() {
        super(BTPBExceptionType.DB_NO_SUCH_OBJECT);
    }

    public BTPBNoSuchObjectException(Exception innerException) {
        super(BTPBExceptionType.DB_NO_SUCH_OBJECT, innerException);
    }

    public BTPBNoSuchObjectException(String details) {
        super(BTPBExceptionType.DB_NO_SUCH_OBJECT, details);
    }

    public BTPBNoSuchObjectException(Exception innerException, String details) {
        super(BTPBExceptionType.DB_NO_SUCH_OBJECT, innerException, details);
    }
}
