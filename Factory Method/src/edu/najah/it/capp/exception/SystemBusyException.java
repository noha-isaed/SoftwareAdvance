package edu.najah.it.capp.exception;

public class SystemBusyException extends ProtocolException {

	public SystemBusyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getMessage() {
		
		return "[SystemBusyException :: ] " + super.getMessage();
	}

}
