package com.ig.coffeehouse.exception;

/**
 * Checked service exception.
 * 
 * @author abhisagrawal
 *
 */
@SuppressWarnings("serial")
public class ServiceException extends Exception {
	
	public ServiceException(String msg)
	{
		super(msg);
	}
	
	public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
