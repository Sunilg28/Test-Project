package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ElementsPage;
import com.crm.qa.util.TestUtil;

public class ElementsTest extends TestBase{
	
	ElementsPage elementsPage;
	
	@BeforeMethod
	void setUp() throws InterruptedException {
		initialization();
		elementsPage=new ElementsPage();
		System.out.println("Setup Succcess!!!");
	}
	
	@Test(priority=1)
	void userRegistrationTest() {
		elementsPage.userRegistration();
	}
	
	@Test
	void checkBoxTest() {
		elementsPage.verifyCheckBox();
		
	}
	
	@Test
	void alertTest() {
		elementsPage.verifyAltert();
	}
	
	@AfterMethod
	void tearDown()
	{
	driver.quit();
	}

}
