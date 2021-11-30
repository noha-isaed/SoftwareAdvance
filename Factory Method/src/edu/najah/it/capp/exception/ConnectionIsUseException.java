package edu.najah.it.capp.exception;

public class ConnectionIsUseException extends ProtocolException {

	public ConnectionIsUseException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getMessage() {
		
		return "[ConnectionIsUseException :: ] " + super.getMessage();
	}

}
