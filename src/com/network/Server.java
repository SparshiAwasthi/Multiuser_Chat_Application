package com.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.utils.ConfigReader;

public class Server {

	ServerSocket serverSocket;
	InetAddress Ip = InetAddress.getLocalHost();
	ArrayList<ServerWorker> workers = new ArrayList<>();
	public Server() throws IOException
	{
		int port = Integer.parseInt(ConfigReader.getValue("PortNo"));
		serverSocket = new ServerSocket(port);
		System.out.println("Server started and waiting for the clients to join");
		handleClientRequest();
	}
	public void handleClientRequest() throws IOException
	{
		 while(true)
		 {
			 Socket clientSocket = serverSocket.accept();
			 ServerWorker serverWorker = new ServerWorker(clientSocket, this);
			 workers.add(serverWorker);
			 serverWorker.start();
		 }
	}
	
	public static void main(String[] args) throws IOException
	{
         Server server = new Server();
	}
}    
