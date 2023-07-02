package com.network;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JTextArea;
import javax.swing.JTextPane;

import com.utils.ConfigReader;

public class Client {
	
	Socket socket;
	InputStream in;
	OutputStream out;
	JTextArea textArea;
	ClientWorker worker;
	InetAddress Ip = InetAddress.getLocalHost();
	public Client(JTextArea textArea) throws UnknownHostException, IOException
	{
		int port = Integer.parseInt(ConfigReader.getValue("PortNo"));
		socket = new Socket(Ip, port);
	    out = socket.getOutputStream();
	    in = socket.getInputStream();
	    this.textArea = textArea;
	    readMessages();
	}
    public void sendMessage(String message) throws IOException
    {
    	message = message + "\n\n";
    	out.write(message.getBytes());
    }
    public void readMessages()
    {
    	worker = new ClientWorker(in, textArea);
    	String s2 = textArea.getText();
		System.out.println("s2 is : "+s2);
    	worker.start();
    }
}
