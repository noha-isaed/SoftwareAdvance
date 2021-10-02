package edu.najah.cap;

public class ScpProtocol implements Connections{
	
	// definition  scpConnection as static instance 
			private static ScpProtocol scpConnection = null ; 
			
			// definition scp protocols as static variable 
			public static final String SCP = "Scp" ;
			
			// constructor
			private ScpProtocol() {} 
			
			// function to get connection as the protocol which in the parameter 
			public static ScpProtocol getInstance () {
				
					if(scpConnection == null) {
				    	if(ConnectionFactory.allConnections.size() < 3) {
							scpConnection = new ScpProtocol() ;
				    		ConnectionFactory.allConnections.add(ScpProtocol.SCP);
				    	 }else {
								System.out.println("Sorry, You Can't Create More Than 3 Conncetions!");
						   }
				}else {
					System.out.println("This Connection Already Exists");
				}
			
		     return scpConnection ;		
			}


			
			@Override
			// function to send message to the user as the object which call the function 
			public void send(String message) {
					System.out.println("Sending" + message + " Via SCP Protocaol");
						
			}
			
			@Override
			// function to remove connection according to the object call the function
				public boolean releaseByObject() {
					
				    if( this == scpConnection) {
				    	if(scpConnection != null ) {
				    		scpConnection = null;
						    ConnectionFactory.allConnections.remove(ScpProtocol.SCP);
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
