package com.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerWorker extends Thread{

	private Socket clientSocket;
	private InputStream in;
	private OutputStream out;
	private Server server;
	
	public ServerWorker(Socket clientSocket, Server server) throws IOException 
	{
		this.server = server;
		this.clientSocket = clientSocket;
		out = clientSocket.getOutputStream();
		System.out.println("New client comes");
	}
	@Override
	public void run() 
	{
		  InputStreamReader r =new InputStreamReader(System.in);    
		  BufferedReader br = new BufferedReader(r); 
		  String line = "";
		  try
		  {
			   while(true)
			   {
				     br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				     line = br.readLine();
				     if(line.equalsIgnoreCase("quit"))
				     {
					       System.out.println("Client terminated the chat..");
					       break;
				     }
				     for(ServerWorker serverWorker : server.workers)
			         {
			    	       line = line + "\n";
			    	       serverWorker.out.write(line.getBytes());
			         }
			   }
		   }
		   catch(IOException e)
		   {
			     e.printStackTrace();
		   }
		   finally 
		   {
			     try
			     {
				       if(br!=null)
				       {
					         br.close();
				       }
				       if(in != null)
				       {
					         in.close();
				       }
				       if(out != null)
				       {
					         out.close();
				       }
				       if(clientSocket != null)
				       {
					         clientSocket.close();
				  }
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}	
