package loginTesting;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import loginBase.Loginpage;
import testData.TestData_Reader;

public class LoginTest extends OpenBrowser {
	@BeforeTest
	public void openBrowser() throws InterruptedException {
		openURL("https://www.facebook.com/");
		Thread.sleep(2000);
	}
	
	//Use data from sheet 0 in test data workbook to test with 
	@DataProvider (name="InvalidData")
	public Object[][] getTestData01() throws Throwable
	{
		TestData_Reader obj = new TestData_Reader();
		return obj.getExcelData(0, 2);
	}
	
	
	//Test invalid cases for Login
    @Test(priority = 1 , dataProvider = "InvalidData")

    public void InvalidLogin (String mail , String password) throws Throwable {
	     Loginpage obj01 = new Loginpage(driver);
	     //Throw data from sheet to login form 
	     obj01.loginMethod(mail, password);
		 Thread.sleep(2000);
		 //Make sure that actual result = Expected result by make sure that it redirect to error page 
		 assertEquals(driver.findElement(By.xpath("//*[@id=\"error_box\"]/div[1]")).getText(),"Wrong credentials");
		 Thread.sleep(1000);
	     driver.navigate().to("https://www.facebook.com/");
	}
    
    //Use data from sheet 1 in test data workbook to test with 
  	@DataProvider (name="validData")
  	public Object[][] getTestData02() throws Throwable
  	{
  		TestData_Reader obj = new TestData_Reader();
  		return obj.getExcelData(1, 2);
  	}
  	
	
    // Test Valid case for Login 
    @Test (priority = 2 , dataProvider = "validData")
    public void ValidLogin(String mail , String password) throws InterruptedException {
    	 Loginpage obj01 = new Loginpage(driver);
	     //Throw data from sheet to login form 
	     obj01.loginMethod(mail, password);
		 Thread.sleep(2000);
		 assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/?sk=welcome");
	}
    
    
    //Close browser after finish Test cases 
    @AfterTest
    public void closeDriver () {
    	driver.close();
    }
	}

