package com.mycompany.socketes1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ClientManager {
    
    public static void main(String[] args) {
        
        Client cl;

        try {
                cl = new Client(InetAddress.getLocalHost(), 2000);
                cl.connection();
        } catch (UnknownHostException e) {
                e.printStackTrace();
        } 		
    }
}