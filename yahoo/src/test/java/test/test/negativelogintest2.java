package test.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.LoginPage;


public class negativelogintest2 extends TestBase {




	LoginPage loginPageobj ;



	@DataProvider(name="ExcelData")
	public Object[][] userRegisterData() throws IOException
	{
		try {
			Thread.sleep(3000);} catch (InterruptedException e) {}
		// get data from Excel Reader class 
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();

	}
	public void testData(String val1, String val2) {
		System.out.println(val1 + " - " + val2 + " - ");
	}

	


	@Test(priority=1,alwaysRun=true,dataProvider="ExcelData")

	public void UserCannotloginWithInVlidUsernam(String val1 , String val2,String val3 ,String val4 ,String val5,String val6,String val7 ) 
	{
     
		loginPageobj = new LoginPage(driver);

		loginPageobj.UserCannotLogToLoginPagewihInvalidusername( val3, val4 ,val5);
		try {Thread.sleep(3000);} catch (InterruptedException e) {}

		Assert.assertTrue(loginPageobj.errorMsgforinvalidusername.isDisplayed());
		
		
	}
	
	
}
