package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();	
	}
	// Class- VerifyLoginPage  / LoginPageTest
	@Test(dataProvider = "skip",testName = "login",groups = "TC-ID")
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();

		//validate if user able to see the logo
		Assert.assertTrue(loginPage.validateLogoOfLoginPage(),"Logo is not matching");

		//validate the title of Login page
		Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, marketing campaigns and support.","Title of page is not matching");
		Assert.assertTrue(title.equals("title"),"Title of page is not matching");
		Assert.assertFalse(title.equals("title"),"Title of page is not matching"+loginPage.validateLoginPageTitle());
	}
	
/*	@Test(priority=1)
	public void crmLogoImageTest(){
		//boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(loginPage.validateLogoOfLoginPage(),"Logo is not matching");
	}*/
	
	//@Test(enabled=false)
/*	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}*/
	@Test
	public void takeScreenshot() {
		loginPage.takeScreenShot();
		
	}
	
	@Test
	public void clickOnPopup() {
	loginPage.clickOnPopup();
		
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
