# Exception and Logging 

1- handel the exceptions "Connection is already released" & "Unable to release the connection because of an unknown error" & 
"Connection is inuse, you can’t release now" in the relleas function in each class for any type of connection 

2- handel the exceptions "No connection is available" & "Failed to send the data because of a timeout error" & 
"System is too busy now" in the send function in each class for any type of connection 

3- create log info , log error and log wairning replace each sentence with a print

4- If I didn't use a singleton class I would have to deal with the synchronisation 
(writing to a file, or whatever stream) between these different logger instances. 
So its much easier, when I just have one global Logger instance.
