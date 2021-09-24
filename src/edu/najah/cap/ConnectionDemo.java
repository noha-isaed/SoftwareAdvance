package edu.najah.cap;
import java.util.List;

public class ConnectionDemo {

	public static void main(String[] args) {
		
		System.out.println("Test Cases getConnection() Function"); 
		System.out.println("*******");
		
		Connection httpConnection1 = Connection.getInstance(Connection.HTTP); 
		Connection httpConnection2 = Connection.getInstance(Connection.HTTP);
		Connection sshConnection = Connection.getInstance(Connection.SSH);
		Connection ftpConnection1= Connection.getInstance(Connection.FTP);
		Connection telnetConnection = Connection.getInstance(Connection.TELNET);
		Connection ftpConnection2 = Connection.getInstance(Connection.FTP);
		
		System.out.println("*******");
		System.out.println("Test Cases releas() Function"); 
		System.out.println("*******");
		
		boolean isRealse1 = httpConnection1.releaseByObject();
		System.out.println(isRealse1);
		Connection httpConnection3 = Connection.getInstance(Connection.HTTP);
		boolean isRealse2 = Connection.releaseByParameter(Connection.SCP);
		System.out.println(isRealse2);
		
		System.out.println("*******");
		System.out.println("Test Cases getCurrentConnections() Function"); 
		System.out.println("*******");
		
		List<String> allConnections = Connection.getCurrentConnections();
		System.out.println(allConnections);
		
		System.out.println("*******");
		System.out.println("Test Cases send() Function"); 
		System.out.println("*******");
		
		sshConnection.send("Your Data");
		ftpConnection1.send("Your Data");
		ftpConnection2.send("Your Data");

		
		
	}
	

}
