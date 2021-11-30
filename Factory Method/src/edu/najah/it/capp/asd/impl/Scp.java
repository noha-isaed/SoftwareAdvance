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

public class Scp implements Protocol {

private static Protocol instance;
	
    private static boolean isSendMessage;

	
	private Scp() {
		Logger.getInstance().logInfo("Creating a new SCP insatnce");
	}
	
	protected static Protocol getInsatnce() {
		if(instance == null) {
			instance = new Scp();
		}
		return instance;
	}
	public boolean release() throws ProtocolException {
 		
 		int status = MyConstraints.FIRST_STATUS ;
 
 		if(instance != null) {
 			instance = null;
			Logger.getInstance().logInfo("The Connection Releas Now");
 			return true;
 		
 		}else if(instance == null ) {
			throw new ConnectionIsAlreadyReleasedEcxeption("The connection already release");
			
 		}else if(status == MyConstraints.CONNECTION_IS_IN_USE_STATUS) {
			throw new ConnectionIsUseException("You can't releas connection inuse ");
		
 		}	
 		throw new UnableToReleaseConnectionException("There is an unknown error");
		
	}

 	public void send(String message) throws ProtocolException {
 		
		int status = MyConstraints.FIRST_STATUS ;

 		if (instance == null ){
 			throw new NoConnectionException("You can't send via connection released");
 	 		
 		}else if(status == MyConstraints.CONNECTION_IS_AVAILABLE_STATUS ) {
 	 		System.out.println("Sending message from SCP :: " + message);
 			
 		}else if(status == MyConstraints.SYSTEM_BUSY_STATUS ) {
 			throw new SystemBusyException("There is no connection availale now because the system too busy");
 			
 		}else if(status == MyConstraints.TIMEOUT_ERRORR_STATUS ) {
 			throw new TimeoutConnectionException("You can't send via connection released");
 		}
 		
 		

	}


}
