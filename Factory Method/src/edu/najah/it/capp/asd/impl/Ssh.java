package edu.najah.it.capp.asd.impl;

import edu.najah.it.capp.asd.constants.MyConstraints;
import edu.najah.it.capp.asd.intf.Protocol;
import edu.najah.it.capp.exception.ConnectionIsAlreadyReleasedEcxeption;
import edu.najah.it.capp.exception.ConnectionIsUseException;
import edu.najah.it.capp.exception.NoConnectionException;
import edu.najah.it.capp.exception.ProtocolException;
import edu.najah.it.capp.exception.SystemBusyException;
import edu.najah.it.capp.exception.TimeoutConnectionException;
import edu.najah.it.capp.exception.UnableToReleaseConnectionException;
import edu.najah.it.capp.logger.Logger;

public class Ssh implements Protocol {

private static Protocol instance;
	
private static boolean isSendMessage;

	private Ssh() {
		Logger.getInstance().logInfo("Creating a new SSH insatnce");
	}
	
	protected static Protocol getInsatnce() {
		if(instance == null) {
			instance = new Ssh();
		}
		return instance;
	}
	public boolean release() throws ProtocolException {
 		
 		int status = MyConstraints.FIRST_STATUS ;
 
 		if(instance != null) {
 			instance = null;
			Logger.getInstance().logInfo("The SSH connection is release now");
 			return true;
 		
 		}else if(instance == null ) {
			throw new ConnectionIsAlreadyReleasedEcxeption("The SSH connection already release");
			
 		}else if(status == MyConstraints.CONNECTION_IS_IN_USE_STATUS) {
			throw new ConnectionIsUseException("You can't releas the SSH connection while it is inuse ");
		
 		}	
 		throw new UnableToReleaseConnectionException("There is an unknown error");
		
	}

 	public void send(String message) throws ProtocolException {
 		
		int status = MyConstraints.FIRST_STATUS ;

 		if (instance == null ){
 			throw new NoConnectionException("You can't send via SSH connection which released");
 	 		
 		}else if(status == MyConstraints.CONNECTION_IS_AVAILABLE_STATUS ) {
 	 		System.out.println("Sending message from SSH :: " + message);
 			
 		}else if(status == MyConstraints.SYSTEM_BUSY_STATUS ) {
 			throw new SystemBusyException("There is no SSH connection availale now because the system too busy");
 			
 		}else if(status == MyConstraints.TIMEOUT_ERRORR_STATUS ) {
 			throw new TimeoutConnectionException("Can't send the message");
 		}
 		
 		

	}

}
