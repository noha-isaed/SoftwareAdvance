package edu.najah.cap;


public class HttpProtocol implements Connections {
		
		// definition  httpconnection as static instance 
		private static HttpProtocol httpConnection = null ; 
		
		// definition http protocols as static variable 
		public static final String HTTP = "Http" ;
		
		// constructor
		private HttpProtocol() {} 
		
		// function to get connection as the protocol which in the parameter 
		public static HttpProtocol getInstance () {
			
				if(httpConnection == null) {
					if(ConnectionFactory.allConnections.size() < 3) {
						httpConnection = new HttpProtocol() ;
			    		ConnectionFactory.allConnections.add(HttpProtocol.HTTP);
					}else {
						System.out.println("Sorry, You Can't Create More Than 3 Conncetions!");
				       }	
				}else {
					System.out.println("This Connection Already Exists");
				}
			
				return httpConnection ;	
				}


		@Override
		// function to send message to the user as the object which call the function 
		public void send(String message) {
			     System.out.println("Sending " + message + " Via HTTP Protocaol");		
		}
		
		@Override
		// function to remove connection according to the object call the function
			public boolean releaseByObject() {
				
			    if(this == httpConnection) {
			    	if(httpConnection != null ) {
			    		httpConnection = null;
			    		ConnectionFactory.allConnections.remove(HttpProtocol.HTTP);
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


