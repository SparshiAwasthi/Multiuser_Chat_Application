package com.DAO;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.DTO.UserDTO;
import com.utils.Encryption;
import com.utils.UserInfo;
import com.views.DashBoard;
import com.views.LoginView;

public class DoLogin extends JFrame{
	
	public DoLogin(String userName, String pswd)
	{
		UserDTO userDTO = new UserDTO(userName, pswd);
		System.out.println("pswd is "+pswd);
    	try
    	{
    		String message = "";
    		boolean f = isLogin(userDTO);
    		System.out.println("f "+f);
    		if(isLogin(userDTO))
    		{
    			message = "Welcome "+userName + "!";
    			UserInfo.user_name = userName;	
    			JOptionPane.showMessageDialog(null, message);
    			System.out.println(message +userName);
    			setVisible(false);
    			dispose();
    			DashBoard dashBoard = new DashBoard(message);
    			dashBoard.setVisible(true);
    		}
    		else
    		{
    			message = "Invalid username or password";
    			System.out.println(message);
    			JOptionPane.showMessageDialog(null, message);
    		}
    	}
    	catch(ClassNotFoundException e)
    	{
    		e.printStackTrace();
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
	}

	public boolean isLogin(UserDTO userDTO) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException
    {
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	final String sql = "select username from users where username=? and password=?";
    	String u = userDTO.getUserName();
    	String p = userDTO.getPassword();
    	try
    	{
    		con = CommonDAO.createConnection();
    		pstmt = con.prepareStatement(sql);
    		pstmt.setString(1, userDTO.getUserName());
    		//String encryptedpswd = Encryption.passwordEncrypt(userDTO.getPassword());
    		String encryptedpswd = Encryption.passwordEncrypt(userDTO.getPassword());
    		pstmt.setString(2, encryptedpswd);
    		System.out.println("at islog "+userDTO.getPassword());
    		rs = pstmt.executeQuery();
    		if(rs.next())
    		{
    			return true;
    		}
    		else
    		{
    			return false;
    		}
    	}
    	finally
    	{
    		if(rs != null)
    		{
    			rs.close();
    		}
    		if(pstmt != null)
    		{
    			pstmt.close();
    		}
    		if(con != null)
    		{
    			con.close();
    		}
    	}
     }
}
