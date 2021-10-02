package edu.najah.cap;

import java.util.ArrayList;
import java.util.List;

public class ConnectionFactory {
	
		// definition list of string to store all connection that created 
		public static List<String> allConnections=new ArrayList<String>();
	   //use getShape method to get object of type shape 
	   public static Connections getConnection(String protocol){
		   
	      if(protocol == HttpProtocol.HTTP ) {
	    		  return HttpProtocol.getInstance();
	         
	      } else if(protocol == SshProtocol.SSH ){
		         return SshProtocol.getInstance();
		         
	      } else if(protocol == TelnetProtocol.TELNET){
		         return TelnetProtocol.getInstance();
	    	  
	      }else if(protocol == ScpProtocol.SCP){
		         return ScpProtocol.getInstance();
	    	   
	      }else if(protocol == FtpProtocol.FTP){
		         return FtpProtocol.getInstance();
	    	  
	      }      
	      return null;
	   }
	   
	   
	// public to return all connection has been created as a list 
	   public static List<String> getCurrentConnections() {
	   	return ConnectionFactory.allConnections ;
	   	
	   }

}




