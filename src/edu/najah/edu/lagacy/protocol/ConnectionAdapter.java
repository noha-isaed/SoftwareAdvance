package edu.najah.edu.lagacy.protocol;

import edu.najah.cap.Connections;

public class ConnectionAdapter implements NewConnection{
	
	Connections connection;
	
	 public ConnectionAdapter(Connections connection)
	    {
	        this.connection = connection;
	    }


	@Override
	public boolean releaseByObjectNewConnection() {
		connection.releaseByObject();
 		return false;
	}

	@Override
	public void sendNewConnection(String message) {
		connection.send(message);		
	}
	
	
	

}
