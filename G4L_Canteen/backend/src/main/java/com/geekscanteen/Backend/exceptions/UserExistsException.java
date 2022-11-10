package com.geekscanteen.Backend.exceptions;

public class UserExistsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public UserExistsException() {
		super();
	}

	public UserExistsException(final String message) {
		super(message);

	}
}