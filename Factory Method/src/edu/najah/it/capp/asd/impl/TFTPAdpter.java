package edu.najah.it.capp.asd.impl;

import edu.najah.cap.legcy.protocol.TFTPProtocol;
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

public class TFTPAdpter implements Protocol {

	private TFTPProtocol tftpLegcy;
	private static Protocol instance;
	
	
	private TFTPAdpter() {
		Logger.getInstance().logInfo("Creating a new TFTPAdpter insatnce");
		tftpLegcy = TFTPProtocol.getTFTPInstance();
	}
	
	protected static Protocol getInsatnce() {
		if(instance == null) {
			instance = new TFTPAdpter();
		}
		return instance;
	}
	

	public boolean release() throws ProtocolException {
 		
 		int status = MyConstraints.FIRST_STATUS ;
 
 		if(instance != null) {
 			tftpLegcy.releaseTFTP();
 			instance = null;
			Logger.getInstance().logInfo("The TFTPAdpter connection is release now");
 			return true;
 		
 		}else if(instance == null ) {
			throw new ConnectionIsAlreadyReleasedEcxeption("The TFTPAdpter connection already release");
			
 		}else if(status == MyConstraints.CONNECTION_IS_IN_USE_STATUS) {
			throw new ConnectionIsUseException("You can't releas the TFTPAdpter connection while it is inuse");
		
 		}	
 		throw new UnableToReleaseConnectionException("There is an unknown error");
		
	}

 	public void send(String message) throws ProtocolException {
 		
		int status = MyConstraints.FIRST_STATUS ;
		
 		if (instance == null ){
 			throw new NoConnectionException("You can't send via TFTPAdpter connection which released");
 	 		
 		}else if(tftpLegcy != null) {
			tftpLegcy.sendMessage(message);
 			
 		}else if(status == MyConstraints.SYSTEM_BUSY_STATUS ) {
 			throw new SystemBusyException("There is no TFTPAdpter connection availale now because the system too busy");
 			
 		}else if(status == MyConstraints.TIMEOUT_ERRORR_STATUS ) {
 			throw new TimeoutConnectionException("Can't send the message");
 		}
 		
 		

	}

}
