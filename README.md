# SingletonDesignPattern

![Screenshot from 2021-09-24 15-20-04](https://user-images.githubusercontent.com/47281464/134673551-1017ab6c-dd8a-4e8f-9d0b-d37058d89bae.png)

Connection class used to create a connection via ssh, telnet, http, scp and ftp protocols.THis class will use some of singleton design pattern properties m like i can;t crearte object from this class in another class by the constructor. THis class contaion 5 private static instance for eache protocol , also contain 6 methods which is :<br/>
1- **Connection() : void**-> constructor  <br/>
2- **getInstance(String) : Connection** -> to get connection as the protocol which in the parameter <br/>
3- **createConnection(Connection , String) : Connection** -> to create new connection if does not exist and #connections still less than 3 <br/>
4- **releaseByParameter(String) : boolean** -> to remove connection according to protocol which in the parameter <br/>
5- **releaseByObject() : boolean** -> to remove connection according to the object call the function <br/>
6- **getCurrentConnections() : List**<String> -> to return all protocols have a connection has been created as a list <br/>
7-  **send(String) : void** -> to send message to the user as the object which call the function <br/>
