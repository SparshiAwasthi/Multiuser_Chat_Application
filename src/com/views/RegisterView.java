package com.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.DAO.DoRegister;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterView extends JFrame {

	private JPanel contentPane;
	private JTextField userid;
	private JTextField userName;
	private JTextField userCity;
	private JTextField userGender;
	private JPasswordField passwordField;

	public RegisterView()
	{
		setTitle("CHATTING APPLICATION");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegisterView.class.getResource("/Images/ii8.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 1471, 820);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBounds(0, 0, 1543, 793);
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(189,248,254));
		contentPane.add(contentPane_1);
		
		JLabel lblNewLabel = new JLabel("REGISTER HERE!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblNewLabel.setBounds(1010, 80, 302, 60);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User id :");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(930, 150, 106, 39);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username :");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(930, 228, 106, 39);
		contentPane_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("City : ");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3.setBounds(930, 304, 62, 39);
		contentPane_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gender : ");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4.setBounds(930, 380, 106, 39);
		contentPane_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password : ");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_5.setBounds(930, 455, 106, 39);
		contentPane_1.add(lblNewLabel_5);
		
		userid = new JTextField();
		userid.setFont(new Font("Arial", Font.PLAIN, 13));
		userid.setBounds(930, 179, 450, 32);
		contentPane_1.add(userid);
		userid.setColumns(10);
		
		userName = new JTextField();
		userName.setFont(new Font("Arial", Font.PLAIN, 13));
		userName.setColumns(10);
		userName.setBounds(930, 259, 450, 32);
		contentPane_1.add(userName);
		
		userCity = new JTextField();
		userCity.setFont(new Font("Arial", Font.PLAIN, 13));
		userCity.setColumns(10);
		userCity.setBounds(930, 335, 450, 32);
		contentPane_1.add(userCity);
		
		userGender = new JTextField();
		userGender.setFont(new Font("Arial", Font.PLAIN, 13));
		userGender.setColumns(10);
		userGender.setBounds(930, 411, 450, 32);
		contentPane_1.add(userGender);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 13));
		passwordField.setBounds(930, 486, 450, 32);
		contentPane_1.add(passwordField);
		
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userId = userid.getText();
				String name = userName.getText();
				String city = userCity.getText();
				String gender = userGender.getText();
				char[] password = passwordField.getPassword();
				String pswd = "";
				for(char i : password)
			    {
				     pswd = pswd + i;
			    } 
				System.out.println(pswd);
				new DoRegister(userId, name, city, gender, pswd);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(1090, 555, 117, 39);
		btnNewButton.setCursor(cursor);
		contentPane_1.add(btnNewButton);
		
		JButton r_login = new JButton("Next");
		r_login.setForeground(Color.WHITE);
		r_login.setBackground(Color.BLACK);
		r_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginView();
			}
		});
		r_login.setFont(new Font("Arial", Font.BOLD, 18));
		r_login.setBounds(1370, 697, 79, 31);
		r_login.setCursor(cursor);
		contentPane_1.add(r_login);
		
		JLabel lblNewLabel_6 = new JLabel("Click next to login");
		lblNewLabel_6.setForeground(Color.DARK_GRAY);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_6.setBounds(1285, 725, 167, 31);
		contentPane_1.add(lblNewLabel_6);
		
		JLabel picLabel= new JLabel("");
		picLabel.setIcon(new ImageIcon(RegisterView.class.getResource("/Images/2f14.png")));
		picLabel.setOpaque(true);
		picLabel.setBackground(Color.WHITE);
		picLabel.setBounds(29, 0, 750, 750);
		contentPane_1.add(picLabel);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(867, 60, 578, 588);
		lblNewLabel_7.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(100, 218, 219)));
		contentPane_1.add(lblNewLabel_7);
		
		setVisible(true);
	}
}
