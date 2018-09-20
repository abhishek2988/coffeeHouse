package com.ig.coffeehouse.exception;

/**
 * Thrown when a specified entity is not found.
 *
 * @author abhisagrawal
 */
@SuppressWarnings("serial")
public class EntityNotFoundException extends ServiceException {
	
	public EntityNotFoundException(String message) {
		super(message);
	}
	
}
