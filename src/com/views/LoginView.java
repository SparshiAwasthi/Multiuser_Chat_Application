package com.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.DAO.DoLogin;

public class LoginView extends JFrame{

	private JPanel contentPane;
	private JTextField nameField;
	private JPasswordField passwordField;
	
	public static void main(String[] args)
	{
		LoginView frame = new LoginView();
	}

	public LoginView()
	{
		setTitle("CHATTING APPLICATION");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/Images/ii8.png")));
		setFont(new Font("Arial Black", Font.BOLD, 25));
		setForeground(Color.BLACK);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1471, 820);
		
		contentPane = new JPanel();
		contentPane.setFont(new Font("Arial Black", Font.BOLD, 25));
		contentPane.setBackground(new Color(190,250,251));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBounds(0, 0, 1543, 793);
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(189,248,254));
		contentPane.add(contentPane_1);
		
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		
		JLabel loginLabel = new JLabel("LOGIN");
		loginLabel.setHorizontalAlignment(SwingConstants.LEFT);
		loginLabel.setForeground(Color.BLACK);
		loginLabel.setFont(new Font("Arial Black", Font.BOLD, 25));
		loginLabel.setBounds(1069, 182, 102, 41);
		contentPane_1.add(loginLabel);
		
		JLabel uNameLabel_1 = new JLabel("Username :");
		uNameLabel_1.setForeground(Color.BLACK);
		uNameLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		uNameLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		uNameLabel_1.setBounds(954, 258, 144, 40);
		contentPane_1.add(uNameLabel_1);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Arial", Font.PLAIN, 13));
		nameField.setBounds(976, 291, 303, 40);
		contentPane_1.add(nameField);
		nameField.setForeground(Color.BLACK);
		nameField.setColumns(10);
		
		JLabel pswdLabel = new JLabel("Password :");
		pswdLabel.setForeground(Color.BLACK);
		pswdLabel.setBounds(954, 349, 144, 40);
		contentPane_1.add(pswdLabel);
		pswdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pswdLabel.setFont(new Font("Arial", Font.BOLD, 18));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 13));
		passwordField.setBounds(976, 382, 303, 40);
		contentPane_1.add(passwordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(976, 451, 303, 41);
		loginButton.setFont(new Font("Arial", Font.BOLD, 18));
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(Color.BLACK);
		loginButton.setCursor(cursor);
		contentPane_1.add(loginButton);
		loginButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				String userName = nameField.getText();
				char[] password = passwordField.getPassword();
				String pswd = "";
				for(char i : password)
			    {
				     pswd = pswd + i;
			    }
				new DoLogin(userName, pswd);
			}
		});
		
		JLabel newUserLabel = new JLabel("New here?");
		newUserLabel.setForeground(Color.DARK_GRAY);
		newUserLabel.setBounds(1017, 493, 81, 30);
		newUserLabel.setHorizontalAlignment(SwingConstants.CENTER);
		newUserLabel.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane_1.add(newUserLabel);
		
		JLabel registerLabel = new JLabel("Register yourself");
		registerLabel.setBounds(1089, 492, 172, 30);
		registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		registerLabel.setFont(new Font("Arial", Font.BOLD, 18));
		registerLabel.setForeground(Color.BLUE);
		registerLabel.setCursor(cursor);
		contentPane_1.add(registerLabel);
		registerLabel.addMouseListener(new MouseAdapter() 
		{
			public void mousePressed(MouseEvent e)
			{ 
				new RegisterView();
			}
		});
		
		JLabel picLabel= new JLabel("");
		picLabel.setIcon(new ImageIcon(LoginView.class.getResource("/Images/2f14.png")));
		picLabel.setOpaque(true);
		picLabel.setBackground(Color.WHITE);
		picLabel.setBounds(29, 0, 750, 750);
		contentPane_1.add(picLabel);
		
		JLabel frameLabel = new JLabel("");
		frameLabel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(100, 218, 219)));
		frameLabel.setBounds(893, 149, 476, 431);
		contentPane_1.add(frameLabel);
		
		JLabel lblNewLabel = new JLabel("Created by Sparshi Awasthi");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(650, 770, 192, 13);
		contentPane_1.add(lblNewLabel);
		
		setVisible(true);
	}
}

