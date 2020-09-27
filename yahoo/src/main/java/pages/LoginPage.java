package pages;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase
{
	public LoginPage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver); 
	}

	@FindBy (css =  "input#login-username")
	public
	WebElement usernamebtn;
	@FindBy (css =  "input#login-signin")
	public
	WebElement nextbt;

	@FindBy (css =  "input#login-passwd")
	public
	WebElement  password;
	@FindBy (css =  "button#login-signin")
	public
	WebElement  nextbtntwo;


	
	@FindBy  (id = "header-logo")
	public
	WebElement logo;

	@FindBy  (xpath  = "//*[@id=\"password-challenge\"]/form/p")
	public
	WebElement errorMsg;
	
	@FindBy  (xpath  = "//*[@id=\"username-error\"]")
	public
	WebElement errorMsgforinvalidusername;
	
	
	@FindBy  (id = "header-profile-menu")
	public
	WebElement headerprofilemenu;
	
	@FindBy  (id = "profile-signout-link")
	public
	WebElement logout;
	


	public void UserCanLogToLoginPage(String val1 , String val2) 
	{


		setTextElementText(usernamebtn, val1);
        clickButton(nextbt);
		setTextElementText(password, val2);
		clickButton(nextbtntwo);

        


	}
	
	public void UserCannotLogToLoginPagewihInvalidpassword(String val1 , String val2  , String val3 ) 
	{


		setTextElementText(usernamebtn, val1);
        clickButton(nextbt);
		setTextElementText(password, val2);
        clickButton(nextbtntwo);
        setTextElementText(password, val3);
        clickButton(nextbtntwo);
       
	}
	
	public void UserCannotLogToLoginPagewihInvalidusername(String val2 , String val3, String val4) 
	{


		setTextElementText(usernamebtn, val2);
        clickButton(nextbt);
		try {Thread.sleep(3000);} catch (InterruptedException e) {}
        clearText(usernamebtn);
		setTextElementText(usernamebtn, val3);
        clickButton(nextbt);
		try {Thread.sleep(3000);} catch (InterruptedException e) {}
        clearText(usernamebtn);
        setTextElementText(usernamebtn, val4);
        clickButton(nextbt);

	}
       


	

}