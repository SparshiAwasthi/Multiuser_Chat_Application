package com.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.io.IOException;
import java.net.UnknownHostException;
import com.DTO.UserDTO;
import com.network.Client;
import com.utils.UserInfo;


public class ClientScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private Client client;
	
	public static void main(String[] args)
	{
		try 
		{
			ClientScreen frame = new ClientScreen();
		} 
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void sendMessage() 
	{
		String message = textField.getText();
		try 
		{
			client.sendMessage(UserInfo.user_name + " : " + message + "\n\n\n");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	 
	public ClientScreen() throws UnknownHostException, IOException
	{
		setTitle("CHATTING APPLICATION");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClientScreen.class.getResource("/Images/ii8.png")));
		setFont(new Font("Arial Black", Font.BOLD, 25));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setForeground(Color.BLACK);
		setBounds(100, 100, 1471, 820);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBounds(0, 0, 1543, 793);
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(190,250,251));
		contentPane.add(contentPane_1);
		
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(412, 10, 702, 678);
		contentPane_1.add(scrollPane);

		textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 15));
		textArea.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(190,250,251)));
		textArea.setBounds(401,10, 695, 673);
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setBounds(412, 697, 597, 55);
		contentPane_1.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Send");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setCursor(cursor);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBounds(1015, 697, 99, 55);
		contentPane_1.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				sendMessage();
				textField.setText("");
			}
		});
		
        client = new Client(textArea);
		
		JLabel label1 = new JLabel("New label");
		label1.setIcon(new ImageIcon(ClientScreen.class.getResource("/Images/fc1.jpg")));
		label1.setBounds(0, 0, 800, 800);
		contentPane_1.add(label1);
		
		JLabel label2 = new JLabel("New label");
		label2.setIcon(new ImageIcon(ClientScreen.class.getResource("/Images/fc1.jpg")));
		label2.setBounds(800, 0, 800, 800);
		contentPane_1.add(label2);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Options");
		mnNewMenu.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem logout = new JMenuItem("Sign Out");
		logout.setBackground(Color.WHITE);
		logout.setOpaque(true);
		logout.setHorizontalAlignment(SwingConstants.LEADING);
		logout.setFont(new Font("Arial", Font.PLAIN, 13));
        mnNewMenu.add(logout);
		logout.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
        setVisible(true);
	}
}


