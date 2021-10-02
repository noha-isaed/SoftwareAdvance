package edu.najah.edu.lagacy.protocol;

import edu.najah.cap.ConnectionFactory;

public class TftpProtocol implements NewConnection{

	
	// definition  tftpConnection as static instance 
	private static TftpProtocol tftpConnection = null ; 
	
	// definition tftp protocols as static variable 
	public static final String TFTP = "Tftp" ;
	
	// constructor
	private TftpProtocol() {} 
	
	// function to get connection as the protocol which in the parameter 
	public static TftpProtocol getInstance () {
		
			if(tftpConnection == null) {
				if(ConnectionFactory.allConnections.size() < 3) {
					tftpConnection = new TftpProtocol() ;
		    		ConnectionFactory.allConnections.add(TftpProtocol.TFTP);
				}else {
					System.out.println("Sorry, You Can't Create More Than 3 Conncetions!");
			       }	
			}else {
				System.out.println("This Connection Already Exists");
			}
		
			return tftpConnection ;	
			}


	
	@Override
	// function to send message to the user as the object which call the function 
	public void sendNewConnection(String message) {
		     System.out.println("Sending" + message + " Via TFTP Protocaol");
				
	}
	
	@Override
	// function to remove connection according to the object call the function
		public boolean releaseByObjectNewConnection() {
			
		    if(this == tftpConnection) {
		    	if(tftpConnection != null ) {
		    		tftpConnection = null;
		    		ConnectionFactory.allConnections.remove(TftpProtocol.TFTP);
				    System.out.println("This Connection Has Been Deleted");
				    return true;
		    	}else {
		    		 System.out.println("This Connection Does not Exist");
					 return false;
		    	}	
	     	}
			
			return false;
		}

}
