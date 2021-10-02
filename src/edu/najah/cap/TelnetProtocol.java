package edu.najah.cap;

public class TelnetProtocol implements Connections {
	
	// definition  telnetConnection as static instance 
	private static TelnetProtocol telnetConnection = null ; 
	
	// definition telnet protocols as static variable 
	public static final String TELNET = "Telnet" ;
	
	// constructor
	private TelnetProtocol() {} 
	
	// function to get connection as the protocol which in the parameter 
	public static TelnetProtocol getInstance () {
		
			if(telnetConnection == null) {
		    	if(ConnectionFactory.allConnections.size() < 3) {
					telnetConnection = new TelnetProtocol() ;
		    		ConnectionFactory.allConnections.add(TelnetProtocol.TELNET);
		    	}else {
					System.out.println("Sorry, You Can't Create More Than 3 Conncetions!");
			   }
		    }else {
				System.out.println("This Connection Already Exists");
			}
		
			return telnetConnection ;		
	}


	@Override
	// function to send message to the user as the object which call the function 
	public void send(String message) {
		     System.out.println("Sending" + message + " Via HTTP Protocaol");
				
	}
	
	@Override
	// function to remove connection according to the object call the function
		public boolean releaseByObject() {
			
		    if( this == telnetConnection) {
		    	if(telnetConnection != null ) {
		    		telnetConnection = null;
		    		ConnectionFactory.allConnections.remove(TelnetProtocol.TELNET);
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
