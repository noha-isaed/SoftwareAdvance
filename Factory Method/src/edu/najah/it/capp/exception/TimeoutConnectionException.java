package edu.najah.it.capp.exception;

public class TimeoutConnectionException extends ProtocolException {

	public TimeoutConnectionException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getMessage() {
		
		return "[TimeoutConnectionException :: ] " + super.getMessage();
	}
}
