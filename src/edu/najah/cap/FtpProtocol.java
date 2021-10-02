package edu.najah.cap;

public class FtpProtocol implements Connections  {
	
	// definition  FtpProtocol as static instance 
			private static FtpProtocol ftpConnection = null ; 
			
			// definition ftp protocols as static variable 
			public static final String FTP = "Ftp" ;
			
			// constructor
			private FtpProtocol() {} 
			
			// function to get connection as the protocol which in the parameter 
			public static FtpProtocol getInstance () {
				
				if(ftpConnection == null) {
			    	  if(ConnectionFactory.allConnections.size() < 3) {
						ftpConnection = new FtpProtocol() ;
			    		ConnectionFactory.allConnections.add(FtpProtocol.FTP);
			    	  }else {
							System.out.println("Sorry, You Can't Create More Than 3 Conncetions!");
					   } 		
				}else {
					System.out.println("This Connection Already Exists");
				}
			
				return ftpConnection ;
			}

			@Override
			// function to send message to the user as the object which call the function 
			public void send(String message) {
				System.out.println("Sending" + message + " Via FTP Protocaol");
						
			}
			
			@Override
			// function to remove connection according to the object call the function
				public boolean releaseByObject() {
					
				    if( this == ftpConnection) {
				    	if(ftpConnection != null ) {
				    		ftpConnection = null;
						    ConnectionFactory.allConnections.remove(FtpProtocol.FTP);
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
