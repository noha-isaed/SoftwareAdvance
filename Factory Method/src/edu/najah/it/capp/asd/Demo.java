package edu.najah.it.capp.asd;


import edu.najah.it.capp.asd.constants.ConnectionType;
import edu.najah.it.capp.asd.impl.Ftp;
import edu.najah.it.capp.asd.intf.Protocol;
import edu.najah.it.capp.asd.service.Connection;
import edu.najah.it.capp.exception.ConnectionIsAlreadyReleasedEcxeption;
import edu.najah.it.capp.exception.ConnectionIsUseException;
import edu.najah.it.capp.exception.NoConnectionException;
import edu.najah.it.capp.exception.ProtocolException;
import edu.najah.it.capp.exception.SystemBusyException;
import edu.najah.it.capp.exception.TimeoutConnectionException;
import edu.najah.it.capp.exception.UnableToReleaseConnectionException;
import edu.najah.it.capp.logger.Logger;




public class Demo {

	public static void main(String[] args) throws ProtocolException {
		
        int numberOfTries = 5;

		Logger.getInstance().logInfo("This is a info message");
		Logger.getInstance().logDebug("This is a debug message");
		Logger.getInstance().logWarning("This is a warning message");
		Logger.getInstance().logError("This is a error message");
		
		
		Protocol ssh = Connection.getInstance(ConnectionType.SSH);
		Protocol ssh2 = Connection.getInstance(ConnectionType.SSH);
		Protocol telnet = Connection.getInstance(ConnectionType.TELNET);
		Protocol scp = Connection.getInstance(ConnectionType.SCP);
		Protocol ftp = Connection.getInstance(ConnectionType.FTP);
		
		
		if(ssh == ssh2) {
			System.out.println(" ssh is equal to ssh2");
		}
        numberOfTries = 5;
		
		while(numberOfTries > 0) {
			try {
				ssh.send(" testing ssh ");
				Logger.getInstance().logInfo("Sending message from SSH");
				break;
			} catch (NoConnectionException e) {
				Logger.getInstance().logWarning(e.getMessage());
				e.printStackTrace();
				break;
			} catch (TimeoutConnectionException e) {
				System.out.println("numberOfTries:: " + numberOfTries);
				Logger.getInstance().logError(e.getMessage());
				numberOfTries--;
				sleep(500L);
			} catch (SystemBusyException e) {
				Logger.getInstance().logWarning(e.getMessage());
				e.printStackTrace();
				break;
			}catch(ProtocolException e) {
				System.out.println("ProtocolException:: " + e.getMessage());
				e.printStackTrace();
				break;
			}finally {
				Connection.release(ConnectionType.SSH);			
			}
		}
		
        numberOfTries = 5;
		
		while(numberOfTries > 0) {
			try {
				telnet.send("Testing telnet ");
				Logger.getInstance().logInfo("Sending message from TELNET");
				break;
			} catch (NoConnectionException e) {
				Logger.getInstance().logWarning(e.getMessage());
				e.printStackTrace();
				break;
			} catch (TimeoutConnectionException e) {
				System.out.println("numberOfTries:: " + numberOfTries);
				Logger.getInstance().logError(e.getMessage());
				numberOfTries--;
				sleep(500L);
			} catch (SystemBusyException e) {
				Logger.getInstance().logWarning(e.getMessage());
				e.printStackTrace();
				break;
			}catch(ProtocolException e) {
				System.out.println("ProtocolException:: " + e.getMessage());
				e.printStackTrace();
				break;
			}finally {
				Connection.release(ConnectionType.TELNET);			
			}
		}
		
        numberOfTries = 5;
		
		while(numberOfTries > 0) {
			try {
				scp.send("Testing scp");
				Logger.getInstance().logInfo("Sending message from SCP");
				break;
			} catch (NoConnectionException e) {
				Logger.getInstance().logWarning(e.getMessage());
				e.printStackTrace();
				break;
			} catch (TimeoutConnectionException e) {
				System.out.println("numberOfTries:: " + numberOfTries);
				Logger.getInstance().logError(e.getMessage());
				numberOfTries--;
				sleep(500L);
			} catch (SystemBusyException e) {
				Logger.getInstance().logWarning(e.getMessage());
				e.printStackTrace();
				break;
			}catch(ProtocolException e) {
				System.out.println("ProtocolException:: " + e.getMessage());
				e.printStackTrace();
				break;
			}finally {
				Connection.release(ConnectionType.SCP);			
			}
		}
		
		
		System.out.println(Connection.getCurrentConnections());

		try {
			Connection.release(ConnectionType.SSH);
			
		}catch(ConnectionIsAlreadyReleasedEcxeption e){
			Logger.getInstance().logWarning(e.getMessage());
			e.printStackTrace();
			
		}catch(ConnectionIsUseException e) {
			Logger.getInstance().logWarning(e.getMessage());
			e.printStackTrace();
			
		}catch(UnableToReleaseConnectionException e) {
			Logger.getInstance().logError(e.getMessage());
			e.printStackTrace();
			
		}catch(ProtocolException e) {
			System.out.println("ProtocolException:: " + e.getMessage());
			e.printStackTrace();
		}
		
		
		System.out.println(Connection.getCurrentConnections());
		
		ftp = Connection.getInstance(ConnectionType.FTP);
		System.out.println(Connection.getCurrentConnections());
		
		
		ssh = Connection.getInstance(ConnectionType.SSH);
		ftp = Connection.getInstance(ConnectionType.FTP);
		ftp = Connection.getInstance(ConnectionType.FTP);
		
		ftp = Connection.getInstance(ConnectionType.FTP);
        numberOfTries = 5;
		
		while(numberOfTries > 0) {
			try {
				ftp.send("Testing FTP");
				Logger.getInstance().logInfo("Sending message from FTP");
				break;
			} catch (NoConnectionException e) {
				Logger.getInstance().logWarning(e.getMessage());
				e.printStackTrace();
				break;
			} catch (TimeoutConnectionException e) {
				System.out.println("numberOfTries:: " + numberOfTries);
				Logger.getInstance().logError(e.getMessage());
				numberOfTries--;
				sleep(500L);
			} catch (SystemBusyException e) {
				Logger.getInstance().logWarning(e.getMessage());
				e.printStackTrace();
				break;
			}catch(ProtocolException e) {
				System.out.println("ProtocolException:: " + e.getMessage());
				e.printStackTrace();
				break;
			}finally {
				Connection.release(ConnectionType.FTP);			
			}
		}
		
		try {
			Connection.release(ConnectionType.FTP);
			
		}catch(ConnectionIsAlreadyReleasedEcxeption e){
			Logger.getInstance().logWarning(e.getMessage());
			e.printStackTrace();
			
		}catch(ConnectionIsUseException e) {
			Logger.getInstance().logWarning(e.getMessage());
			e.printStackTrace();
			
		}catch(UnableToReleaseConnectionException e) {
			Logger.getInstance().logError(e.getMessage());
			e.printStackTrace();
			
		}catch(ProtocolException e) {
			System.out.println("ProtocolException:: " + e.getMessage());
			e.printStackTrace();
		}
		
		Protocol tftp = Connection.getInstance(ConnectionType.TFTP);
		Protocol tftp2 = Connection.getInstance(ConnectionType.TFTP);
		System.out.println(Connection.getCurrentConnections());
		if(tftp == tftp2 ) {
			System.out.println("Same object");
		}
       numberOfTries = 5;
		
		while(numberOfTries > 0) {
			try {
				tftp.send("test the TFTP ");
				Logger.getInstance().logInfo("Sending message from tftp");
				break;
			} catch (NoConnectionException e) {
				Logger.getInstance().logWarning(e.getMessage());
				e.printStackTrace();
				break;
			} catch (TimeoutConnectionException e) {
				System.out.println("numberOfTries:: " + numberOfTries);
				Logger.getInstance().logError(e.getMessage());
				numberOfTries--;
				sleep(500L);
			} catch (SystemBusyException e) {
				Logger.getInstance().logWarning(e.getMessage());
				e.printStackTrace();
				break;
			}catch(ProtocolException e) {
				System.out.println("ProtocolException:: " + e.getMessage());
				e.printStackTrace();
				break;
			}finally {
				tftp.release();			
			}
		}
       numberOfTries = 5;
		
		while(numberOfTries > 0) {
			try {
				tftp2.send("test the TFTP ");
				Logger.getInstance().logInfo("Sending message from tftp");
				break;
			} catch (NoConnectionException e) {
				Logger.getInstance().logWarning(e.getMessage());
				e.printStackTrace();
				break;
			} catch (TimeoutConnectionException e) {
				System.out.println("numberOfTries:: " + numberOfTries);
				Logger.getInstance().logError(e.getMessage());
				numberOfTries--;
				sleep(500L);
			} catch (SystemBusyException e) {
				Logger.getInstance().logWarning(e.getMessage());
				e.printStackTrace();
				break;
			}catch(ProtocolException e) {
				System.out.println("ProtocolException:: " + e.getMessage());
				e.printStackTrace();
				break;
			}finally {
				tftp2.release();			
			}
		}
		//ftp = Ftp.getInsatnce();
		///Connection.release(ConnectionType.TFTP);
		System.out.println(Connection.getCurrentConnections());//3
		if(ftp == null) {
			System.out.println("FTP is a null");
		} else {
			System.out.println("FTP is not a null");
		}
        numberOfTries = 5;
		
		while(numberOfTries > 0) {
			try {
				ftp.send(" breaking the logic ");
				Logger.getInstance().logInfo("Sending message from FTP");
				break;
			} catch (NoConnectionException e) {
				Logger.getInstance().logWarning(e.getMessage());
				e.printStackTrace();
				break;
			} catch (TimeoutConnectionException e) {
				System.out.println("numberOfTries:: " + numberOfTries);
				Logger.getInstance().logError(e.getMessage());
				numberOfTries--;
				sleep(500L);
			} catch (SystemBusyException e) {
				Logger.getInstance().logWarning(e.getMessage());
				e.printStackTrace();
				break;
			}catch(ProtocolException e) {
				System.out.println("ProtocolException:: " + e.getMessage());
				e.printStackTrace();
				break;
			}finally {
				Connection.release(ConnectionType.FTP);				
			}
		}
			
		
	}
	
	private static void sleep(Long timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
