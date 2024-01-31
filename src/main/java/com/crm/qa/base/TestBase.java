package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	/*public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;*/
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() throws InterruptedException { //initialization
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "E:/Softwares/Testing/chromedriver_win32/chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		/*else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "E:/Automation Suite/Selenium Configurtion/chromedriver_win32/geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}*/
		
		
/*		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;*/
		
		driver.manage().window().maximize(); //fresh browser
		driver.manage().deleteAllCookies();  //Cookies
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS); //wait function
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);   //wait function
		driver.manage().wait(1000);
		Thread.sleep(2000);    //not used in framework

//		Thread.sleep(2000);
		driver.get(prop.getProperty("url"));   //URL hit
		/*WebElement ele= driver.findElement(By.xpath("//td[contains(text(),'Contacts')]"));
		System.out.println(ele.isEnabled());
		ele.click();
		ele.sendKeys("Name");
		System.out.println(ele.getText()); //Contacts
*/

	//	List<WebElement> elements= driver.findElements(By.id("multipleElement"));

	}

}
