package edu.najah.cap;

public class SshProtocol implements Connections {
	
	// definition sshConnection as static instance 
	private static SshProtocol sshConnection = null ; 
	
	// definition ssh protocols as static variable 
	public static final String SSH = "Ssh" ;
	
	// constructor
	private SshProtocol() {} 
	
	// function to get connection as the protocol which in the parameter 
	public static SshProtocol getInstance () {
		
			if(sshConnection == null) {
		    	  if(ConnectionFactory.allConnections.size() < 3) {
					sshConnection = new SshProtocol() ;
		    		ConnectionFactory.allConnections.add(SshProtocol.SSH);
			    }else {
					System.out.println("Sorry, You Can't Create More Than 3 Conncetions!");
			   }
			}else {
		    	System.out.println("This Connection Already Exists");
		    }
	
		     return sshConnection ;		
	}


	@Override
	// function to send message to the user as the object which call the function 
	public void send(String message) {
		     System.out.println("Sending" + message + " Via SSH Protocaol");
				
	}
	
	@Override
	// function to remove connection according to the object call the function
		public boolean releaseByObject() {
			
		    if( this == sshConnection) {
		    	if(sshConnection != null ) {
		    		sshConnection = null;
		    		ConnectionFactory.allConnections.remove(SshProtocol.SSH);
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
