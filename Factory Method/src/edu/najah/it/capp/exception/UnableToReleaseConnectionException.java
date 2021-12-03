package edu.najah.it.capp.exception;

public class UnableToReleaseConnectionException extends ProtocolException {

	public UnableToReleaseConnectionException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getMessage() {
		
		return "[Unable To Release Connection Exception :: ] " + super.getMessage();
	}
}
