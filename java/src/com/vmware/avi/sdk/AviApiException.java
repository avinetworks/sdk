package com.vmware.avi.sdk;

/**
 * This is a Exception class for throwing exception in controller communication.
 * 
 * @author: Chaitanya Deshpande
 *
 */
public class AviApiException extends Exception
{

    private static final long serialVersionUID = 1L;

    /** This is a default constructor */
    public AviApiException()
    {
        super();
    }

    /**
     * Constructor which construct string message.
     * 
     * @param message
     *            Contains message of exception.
     */
    public AviApiException(String message)
    {
        super(message);
    }

    /**
     * Constructor which construct throwable cause.
     * 
     * @param cause
     *            Contains throwable cause of any exception.
     */
    public AviApiException(Throwable cause)
    {
        super(cause);
    }

}
