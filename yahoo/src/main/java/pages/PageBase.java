package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

	protected WebDriver drvier ; 
	public JavascriptExecutor jse ; 
	public Select select ; 
	public static Actions action ; 

	// create constructor 
	public PageBase(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	protected static void clickButton(WebElement button) 
	{
		button.click();
	}
	
	protected static void setTextElementText(WebElement textElement , String value) 
	{
		textElement.sendKeys(value);
	}
	
	public void scrollToBottom() 
	
	{
		jse.executeScript("scrollBy(0,2500)"); 
	}
	
	public void scrollToElement(WebElement element)
	{
    	jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void clearText(WebElement element) 
	{
		element.clear();
	}
	  
	protected static void hoverrButton(WebElement fromelement,WebElement toelement  ) 
	{
		
		action
		.moveToElement(fromelement)
		.moveToElement(toelement)
		.click()
		.build()
		.perform();
	}
	
	public static void usingselect(WebElement element , String text , int number) 
	{
		Select select = new Select(element);
		try {
			select.selectByVisibleText(text);

		} catch (Exception e) {
			select.selectByIndex(number);

		}
	}
		public static void usingallselect(WebElement element , String text , int number,  String value) 
		{
			Select select = new Select(element);
			char grade = 'C';
			switch(grade) {
			   case 1 :
					select.selectByVisibleText(text);

				   break; // optional
			   
			   case 2 :
					select.selectByIndex(number);

			      break; // optional
			   
			   // You can have any number of case statements.
			   default : // Optional
			     select.selectByValue(value);
			}


			
		
	}
	

}
