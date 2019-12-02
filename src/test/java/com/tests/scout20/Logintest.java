package com.tests.scout20;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Basetest.scout20.Basetest;
import com.scout20.dto.LoginDTO;
import com.steps.scout20.Loginstep;

public class Logintest extends Basetest
{
	Loginstep loginstep;
	@BeforeMethod
	public void init()
	{
		loginstep = new Loginstep(driver);
	}
	
	@Test
	public void Loginwithvalidcreditinals(LoginDTO logindto)
	{
		try {
			boolean islogin = loginstep.performlogin(logindto.getuserName(), logindto.getpassword(), url);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
