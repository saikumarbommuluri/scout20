package com.scout20.dto;

public class LoginDTO 
{
	private String userName;
	private String password;
	
	public String getuserName()
	{
		return userName;
	}
	public void setuserName(String username)
	{
		this.userName=username;
	}
	public String getpassword()
	{
		return password;
	}
	public void setpassword(String Password)
	{
		this.password =Password;
	}

}
