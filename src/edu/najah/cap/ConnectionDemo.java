package edu.najah.cap;
import java.util.List;

import edu.najah.edu.lagacy.protocol.ConnectionAdapter;
import edu.najah.edu.lagacy.protocol.NewConnection;
import edu.najah.edu.lagacy.protocol.TftpProtocol;

public class ConnectionDemo {

	public static void main(String[] args) {
		
		System.out.println("Test Cases getConnection() Function"); 
		System.out.println("*******");
		
		Connections httpConnection1 = ConnectionFactory.getConnection(HttpProtocol.HTTP); 
		Connections httpConnection2 = ConnectionFactory.getConnection(HttpProtocol.HTTP);
		Connections sshConnection = ConnectionFactory.getConnection(SshProtocol.SSH);
		Connections ftpConnection1= ConnectionFactory.getConnection(FtpProtocol.FTP);
		Connections telnetConnection = ConnectionFactory.getConnection(TelnetProtocol.TELNET);
		Connections sshConnection2 = ConnectionFactory.getConnection(SshProtocol.SSH);

		List<String> allConnections = ConnectionFactory.getCurrentConnections();
		System.out.println(allConnections);
		
		System.out.println("*******");
		System.out.println("Test Cases releas() Function"); 
		System.out.println("*******");
		
		boolean isRealse1 = httpConnection1.releaseByObject();
		System.out.println(isRealse1);

		List<String> allConnections2 = ConnectionFactory.getCurrentConnections();
		System.out.println(allConnections2);
		
//		Connections httpConnection3 = ConnectionFactory.getConnection(HttpProtocol.HTTP);		
	
		System.out.println("*******");
		System.out.println("Test Cases send() Function"); 
		System.out.println("*******");
		
		sshConnection.send("Your Data");
		ftpConnection1.send("Your Data");
		sshConnection2.send("Your Data");

		
		NewConnection tftpConnection = TftpProtocol.getInstance ();
		tftpConnection.sendNewConnection("Your Data");
		List<String> allConnections3 = ConnectionFactory.getCurrentConnections();
		System.out.println(allConnections3);
		tftpConnection.releaseByObjectNewConnection();
		List<String> allConnections4 = ConnectionFactory.getCurrentConnections();
		System.out.println(allConnections4);
		
		NewConnection connectionAdapter = new ConnectionAdapter(httpConnection1);
		connectionAdapter.sendNewConnection("Your Data");

		
	}
	

}
