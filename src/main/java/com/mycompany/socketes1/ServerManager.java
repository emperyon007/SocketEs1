package com.mycompany.socketes1;

public class ServerManager {
	
	public static void main (String [] args) {
		  
		  Server se = new Server(2000); 
			
		  se.connection();
                  while(true){
                    se.read();
                    se.write();
                  }
		  
	  }
}