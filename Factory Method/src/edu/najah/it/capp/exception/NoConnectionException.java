package edu.najah.it.capp.exception;

public class NoConnectionException extends ProtocolException {

	public NoConnectionException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getMessage() {
		
		return "[NoConnectionException :: ] " + super.getMessage();
	}

}
