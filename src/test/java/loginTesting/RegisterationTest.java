package loginTesting;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import loginBase.RegisterationPage;
import testData.TestData_Reader;

public class RegisterationTest extends OpenBrowser  {
	
	@BeforeTest
	public void openBrowser() throws InterruptedException {
		openURL("https://www.facebook.com/r.php?locale=en_GB&display=page");
		Thread.sleep(1000);
	}
	
	//Invalid Test cases for sign up by wrong pass 
	@DataProvider 
	public Object[][] getpass() throws Throwable
	{
		TestData_Reader obj = new TestData_Reader();
		return obj.getExcelData(3, 4);
	}
	
	@Test(priority = 1 , dataProvider = "getpass")

    public void Invalidsignup (String firstna , String surna ,String Email , String Password) throws Throwable {
	     RegisterationPage obj = new RegisterationPage(driver);
	     //Throw data from sheet to login form 
	     obj.SignupMethod(firstna, surna, Email, Password);
		 Thread.sleep(6000);
		 //Make sure that actual result = Expected result 
	     assertEquals(driver.findElement(By.xpath("//*[@id=\"reg_error_inner\"]")).getText(), "It looks like you may have entered an incorrect email address. Please correct it if necessary, then click to continue.");
	
	}

	//Invalid Test cases for sign up by invalid Email 
	@DataProvider 
	public Object[][] getemail() throws Throwable
	{
		TestData_Reader obj = new TestData_Reader();
		return obj.getExcelData(4, 4);
	}
	
	@Test(priority = 2 , dataProvider = "getemail")

    public void Invalidsignup02 (String firstna , String surna ,String Email , String Password) throws Throwable {
	     RegisterationPage obj = new RegisterationPage(driver);
	     //Throw data from sheet to login form 
	     obj.SignupMethod02(firstna, surna, Email, Password);
		 Thread.sleep(2000);
		 //Make sure that actual result = Expected result by make sure that it redirect to error page 
	     assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[5]/div/div/div")).getText(), "Please enter a valid mobile number or email address.");
	     driver.navigate().to("https://www.facebook.com/r.php?locale=en_GB&display=page");
    }
	
	
	//Valid Test cases for Sign up 
	@DataProvider (name="Test")
	public Object[][] getvalidSignupData() throws Throwable
	{
		TestData_Reader obj = new TestData_Reader();
		return obj.getExcelData(2, 4);
	}
	//Test vaild cases for signup
    @Test(priority = 3 , dataProvider = "Test")

    public void validsignup (String firstna , String surna ,String Email , String Password) throws Throwable {
	     RegisterationPage obj = new RegisterationPage(driver);
	     //Throw data from sheet to login form 
	     obj.SignupMethod(firstna, surna, Email, Password);
		 Thread.sleep(6000);
		 //Make sure that actual result = Expected result by make sure that it redirect to error page 
	     assertEquals(driver.findElement(By.className("uiHeaderTitle")), "Enter the code from your email");
    }
    
    //Close browser after finish Test cases 
    @AfterTest
    public void closeDriver () {
    	driver.close();
    }
}
