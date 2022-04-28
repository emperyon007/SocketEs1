package com.mycompany.socketes1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;



public class Client {
    Socket socket;
    InetAddress ip; 
    int port; 

    public Client(InetAddress ip, int port) {

            this.ip = ip;
            this.port = port; 
    }

    public void connection() {
            try {
                    socket = new Socket(ip, port);
                    System.out.println("Client connected"); 
            }catch (IOException e) {
                    e.printStackTrace();
            }
    }	

    public void close() {
            try {
                    socket.close();
            } catch (Exception e) {
                    e.printStackTrace();
            }
    }

    public void read() {
            Scanner sc;
            try {
                    sc = new Scanner(socket.getInputStream());
                    String msg = sc.nextLine(); 
                    msg += "\n"; 
                    System.out.println("Server: " + msg); 
            } catch (IOException e) {
                    e.printStackTrace();
            } 
    } 

    public void write() {
        try {

                Scanner in = new Scanner(System.in); 

                System.out.println("Insert message: ");
                String msg = in.nextLine(); 
                msg += "\n";
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); 
                dos.writeBytes(msg);

        }  catch (IOException e) {
                e.printStackTrace();
        }
    } 
}
