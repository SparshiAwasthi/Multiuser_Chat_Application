package com.DTO;


public class UserDTO {
	
    private String userId;
    private String userName;
    private String city;
    private String gender;
    private String password;
    
    public UserDTO(String userId, String userName, String city, String gender, String password)
    {
   	 this.userId = userId;
   	 this.userName = userName;
   	 this.city = city;
   	 this.gender = gender;
   	 this.password = password;
    }
    public UserDTO(String userName, String password)
    {
    	this.userName = userName;
    	this.password = password;
    }
	public String getUserId() {
		
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCity() {
		return city;
	}

	public void setUserCity(String userCity) {
		this.city = userCity;
	}

	public String getUserGender() {
		return gender;
	}

	public void setUserGender(String userGender) {
		this.gender = userGender;
	}
    
}
