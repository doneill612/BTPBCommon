package com.btpb.common.exceptions;

public abstract class BTPBException extends Exception {

    private BTPBExceptionType exceptionType;

    public BTPBException(BTPBExceptionType exceptionType)
    {
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
    }

    public BTPBException(BTPBExceptionType exceptionType, Exception innerException)
    {
        super(exceptionType.getMessage() + " Inner exception message: "
                + innerException.getMessage());
        this.exceptionType = exceptionType;
    }

    public BTPBException(BTPBExceptionType exceptionType, String details)
    {
        super(exceptionType.getMessage() + " Details: " + details);
        this.exceptionType = exceptionType;
    }

    public BTPBException(BTPBExceptionType exceptionType, Exception innerException, String details)
    {
        super(exceptionType.getMessage() + " Details: " + details +
                ". Inner exception message: " + innerException.getMessage());
    }

}
