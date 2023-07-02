package com.DAO;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.DTO.UserDTO;
import com.utils.Encryption;
import com.views.RegisterView;


public class DoRegister
{
	
	public DoRegister(String userId, String userName, String city, String gender, String pswd)
	{
		 UserDTO userDTO = new UserDTO(userId, userName, city, gender, pswd);
	     try 
	     {
		      int result = add(userDTO);
		      System.out.println("result is : "+result);
		      if (result > 0) 
		      {
			       JOptionPane.showMessageDialog(null, "Register successfully");
		      } 
		      else
		      {
			       JOptionPane.showMessageDialog(null, "Register fail");
		      }
      	}
	    catch (ClassNotFoundException | SQLException ex)
	    {
		      System.out.println("DB issue....");
		      ex.printStackTrace();
	    }   
	    catch (Exception ex)
	    {
		      System.out.println("Some generic exception raised....");
	    }
        System.out.println("userId " + userId + " Password " + pswd);
    }
    public int add(UserDTO userDTO) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException
    {
    	System.out.println("Receive + "+userDTO.getUserId() + " "+ userDTO.getPassword());
        Connection con = null;
        Statement stmt = null;
        try
        {
            con = CommonDAO.createConnection();
            stmt = con.createStatement();
            //String encryptedpswd = Encryption.passwordEncrypt(userDTO.getPassword());
            int record = stmt.executeUpdate("INSERT INTO users (userid, username, city, gender, password) VALUES ('" + userDTO.getUserId() + "', '" + userDTO.getUserName() + "', '" + userDTO.getUserCity() + "', '" + userDTO.getUserGender() + "', '" + Encryption.passwordEncrypt(userDTO.getPassword()) + "')");
            return record;
        }
        finally
        {
        	if(stmt != null)
        	{
        		stmt.close();
        	}
        	if(con != null)
        	{
        		con.close();
        	}
        }
   }
}
