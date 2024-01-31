package com.crm.qa.pages;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.utils.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(name="email")
	WebElement username;

	WebElement userName= driver.findElement(By.name("email"));
	
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement password;

	WebElement Password = driver.findElement(By.xpath("//input[@name=\"password\"]"));

	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	@FindBy(xpath = "//*[@id=\"navbar-collapse\"]/ul/li[1]/a")
	WebElement loginBtnPrimary;  
	//Initializing the Page Objects:
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/div[1]/a")
	WebElement forgotBtn;
	@FindBy(id="windowButton")
	WebElement windowButton;

	@FindBy(id="messageWindowButton")
	WebElement messageWindowButton;

	//Constructor
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions: Methods
	public String validateLoginPageTitle(){
		String title= driver.getTitle();
		return title;
	}
	
	public boolean validateLogoOfLoginPage(){

		return crmLogo.isDisplayed();
	}

	//login(prop.getProperty("userName"),prop.getProperty("Password"))
	public HomePage login(String userName, String pwd) throws InterruptedException {

		loginBtnPrimary.click();
		WebDriverWait wait = new WebDriverWait(driver,2);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"password\"]")));
		username.sendKeys(userName);
		password.sendKeys(pwd);
		//forgotBtn.click();
		loginBtn.click();   //login Btn click
//		    	JavascriptExecutor js = (JavascriptExecutor)driver;
//		    	js.executeScript("arguments[0].click();", loginBtn);
		    	
		return new HomePage();
	}
	public boolean takeScreenShot() {
		loginBtnPrimary.click();
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(file,new File("C:\\Users\\Mallinath Paratnale\\Downloads\\screenshot"+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean clickOnPopup() {
		windowButton.click();      //after clicking window tab POP up
		String mainWindow = driver.getWindowHandle();  //current window String id
		messageWindowButton.click();
		
		Set<String>  windows=  driver.getWindowHandles();// set(1,2,3)- unique value save, List- duplicate(1,1,1,1,2)
		//driver.switchTo().window(mainWindow); // parent window

		Iterator<String> winItr = windows.iterator();     //
		while(winItr.hasNext()) {
			
			String childWindow =  winItr.next();
//			System.out.println("Windows Name: "+childWindow);
//			System.out.println();
			if(! mainWindow.equals( childWindow) ) {
				driver.switchTo().window(childWindow);
			  //WebElement label=  driver.findElement(By.id("sampleHeading"));
			 //System.out.println("Lablel in child window: "+ label.getText());
			}
			
		}
		driver.switchTo().window(mainWindow);
		messageWindowButton.click();
		
		
		return true;

		//Note- test data with {}- Map<String,String>, []- List<String> or List<Map<String,String>>
	}
	
}
