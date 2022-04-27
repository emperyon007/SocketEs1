package com.mycompany.socketes1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	ServerSocket serverSocket; 
	Socket socket; 
	Countdown cd = new Countdown(25);
	
	int port; 
	
	public Server(int port) {
		this.port = port; 
	}
	
    public void connection() {
            try {
                    serverSocket = new ServerSocket(port);
                    System.out.println("Server good to go");
                    serverSocket.setSoTimeout(25000);
                    cd.start();
                    socket = serverSocket.accept();
                    cd.stopThread(); 
                    System.out.println("Client connected");

            } catch (IOException e) {
                    System.out.println("Client not connected, shutting down...");
            }

    }

    public void close() {

            try {
                    serverSocket.close();
            } catch (IOException e) {
                    e.printStackTrace();
            }

    }

    public void read() {
            Scanner sc;
            try {
                    sc = new Scanner(socket.getInputStream());
                    String msg = sc.nextLine(); 
                    msg += "\n"; 
                    System.out.println("Client: " + msg); 
            } catch (IOException e) {
                    e.printStackTrace();
            } 
    } 

    public void write() {
            try {

                    Scanner in=new Scanner(System.in); 

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