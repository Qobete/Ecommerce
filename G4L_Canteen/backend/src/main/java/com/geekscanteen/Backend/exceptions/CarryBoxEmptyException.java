package com.geekscanteen.Backend.exceptions;

public class CarryBoxEmptyException  extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CarryBoxEmptyException() {
		super();
	}

	public CarryBoxEmptyException(final String message) {
		super(message);

	}
}
