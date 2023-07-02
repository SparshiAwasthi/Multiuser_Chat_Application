package com.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class DashBoard extends JFrame {

	private JPanel contentPane;

	public DashBoard(String message) 
	{
		setTitle("CHATTING APPLICATION");
		setFont(new Font("Arial Black", Font.BOLD, 25));
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DashBoard.class.getResource("/Images/ii8.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1471, 820);
		setForeground(Color.BLACK);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBounds(0, 0, 1543, 793);
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.BLACK);
		contentPane.add(contentPane_1);
		
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		
		JLabel label1 = new JLabel("New label");
		label1.setIcon(new ImageIcon(DashBoard.class.getResource("/Images/dashimg1.png")));
		label1.setOpaque(true);
		label1.setBounds(161, 65, 1200, 600);
		contentPane_1.add(label1);
		
		JButton startChatBtn = new JButton("Start Chat");
		startChatBtn.setBorder(new CompoundBorder());
		startChatBtn.setBackground(Color.WHITE);
		startChatBtn.setFont(new Font("Arial Black", Font.BOLD, 18));
		startChatBtn.setForeground(Color.BLACK);
		startChatBtn.setBounds(671, 690, 165, 42);
		startChatBtn.setCursor(cursor);
		contentPane_1.add(startChatBtn);
		
		JLabel lblNewLabel = new JLabel("                  W     E     L     C     O    M    E");
		lblNewLabel.setForeground(Color.ORANGE);
		//lblNewLabel.setForeground(new Color(255,166,27));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 44));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(161, 15, 1200, 40);
		contentPane_1.add(lblNewLabel);
		
		startChatBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					new ClientScreen();
				} 
				catch (UnknownHostException e1) 
				{
					e1.printStackTrace();
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
			}
		});
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Options");
		mnNewMenu.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem startChat = new JMenuItem("Start Chat");
		startChat.setOpaque(true);
		startChat.setHorizontalAlignment(SwingConstants.LEADING);
		startChat.setFont(new Font("Arial", Font.PLAIN, 13));
		mnNewMenu.add(startChat);
		startChat.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					new ClientScreen();
				} 
				catch (UnknownHostException e1)
				{
					e1.printStackTrace();
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
			}
		});
		
       
		JMenuItem logoutItem = new JMenuItem("Sign Out");
		logoutItem.setOpaque(true);
		logoutItem.setHorizontalAlignment(SwingConstants.LEADING);
		logoutItem.setFont(new Font("Arial", Font.PLAIN, 13));
        mnNewMenu.add(logoutItem);
		logoutItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		
		contentPane.setLayout(new BorderLayout(0, 0));
	}
}

