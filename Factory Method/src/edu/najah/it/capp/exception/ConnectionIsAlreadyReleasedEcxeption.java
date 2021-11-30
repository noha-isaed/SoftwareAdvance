package edu.najah.it.capp.exception;

public class ConnectionIsAlreadyReleasedEcxeption extends ProtocolException {

	public ConnectionIsAlreadyReleasedEcxeption(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getMessage() {
		
		return "[ConnectionIsAlreadyReleasedEcxeption :: ] " + super.getMessage();
	}

}
