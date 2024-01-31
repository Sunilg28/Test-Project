package com.crm.qa.pages;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ElementsPage extends TestBase{
	
	@FindBy(xpath="//input[@id=\"userName\"]")
	WebElement userNameTxt;
	
	@FindBy(xpath="//*[@id=\"userEmail\"]")
	WebElement userEmailTxt;
	
	@FindBy(xpath="//*[@id=\"currentAddress\"]")
	WebElement currentAddTxt;
	
	@FindBy(xpath="//*[@id=\"permanentAddress\"]")
	WebElement permanentAddTxt;
	
	@FindBy(xpath="//button[@id=\"submit\"]")
	WebElement submitBtn;
	
	@FindBy(xpath="//*[@id=\"item-0\"]/span")
	WebElement textBtn;
	
	@FindBy(xpath="//*[@id=\"tree-node\"]/ol/li/span/label/span[1]")
	WebElement homeCheckbox;
	
	@FindBy(xpath="//*[@id=\"alertButton\"]")
	WebElement clickMeBtn;
	
	@FindBy(xpath="//*[@id=\"confirmButton\"]")
	WebElement clickConfirmMeBtn;
	
	@FindBy(xpath="//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[3]")
	WebElement elementsBtn;
	
	
	@FindBy(xpath="//*[@id=\"item-1\"]/span")
	WebElement checkBoxBtn;

	
	@FindBy(xpath="	//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[3]/span/div/div[1]")
	WebElement alertsHomeBtn;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[2]/span")
	WebElement alertsBtn;
	

	
	
	
	// Initializing the Page Objects:
		public ElementsPage() {
			PageFactory.initElements(driver, this);
		}
		
	
	public void userRegistration() {
		TestUtil.scrollUpScreen();
		elementsBtn.click();
		textBtn.click();
		userNameTxt.sendKeys("vaibhav");
		userEmailTxt.sendKeys("email@gmail.com");
		currentAddTxt.sendKeys("Pune 411033");
		permanentAddTxt.sendKeys("Pune");
		TestUtil.scrollUpScreen();
		submitBtn.click();
		
	}
	public void verifyCheckBox() {
		TestUtil.scrollUpScreen();
		elementsBtn.click();
		checkBoxBtn.click();
		homeCheckbox.click();
	}
	public void verifyAltert() {
		TestUtil.scrollUpScreen();
		elementsBtn.click();
		TestUtil.scrollUpScreen();
		alertsHomeBtn.click();
		TestUtil.scrollUpScreen();
		alertsBtn.click();
		clickMeBtn.click();
		driver.switchTo().alert().accept();
		clickConfirmMeBtn.click();
		driver.switchTo().alert().dismiss();
		
		
		
		/*
		 * Set<String> handles = driver.getWindowHandles(); String mainWind =
		 * driver.getWindowHandle(); for(String popup : handles) { if(popup!=mainWind) {
		 * driver.switchTo().window(popup); } }
		 */
		
		
		
		
	}
}
