package loginBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterationPage extends BasePage {

	public RegisterationPage(WebDriver driver) {
		super(driver);
	}
	
	
	
	//Locate first name field 
	//Actions in signup form
		public void SignupMethod (String firstna , String surna ,String Email, String Password) throws InterruptedException {
			WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
			firstname.clear();
			firstname.sendKeys(firstna);
			//Locate surname field 
			WebElement surname = driver.findElement(By.xpath("//input[@name='lastname']"));
			surname.clear();
			surname.sendKeys(surna);
			//Locate Mobile or email field 
			WebElement Mobile = driver.findElement(By.xpath("//input[@name='reg_email__']"));
			Mobile.clear();
			Mobile.sendKeys(Email);
			//Locate email 
			WebElement readdemail =driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
			readdemail.clear();
			readdemail.sendKeys(Email);
			//Locate new password field 
			WebElement pass = driver.findElement(By.id("password_step_input"));
			pass.clear();
			pass.sendKeys(Password);
			//Locate Birth of date
			//find day select
			WebElement day = driver.findElement(By.id("day"));
			Select dayoptions = new Select(day);
			dayoptions.selectByValue("5");
			//find month select 
			WebElement month = driver.findElement(By.id("month"));
			Select monthoptions = new Select(month);
			monthoptions.selectByValue("5");
			//find year select 
			WebElement year = driver.findElement(By.id("year"));
			Select yearoptions =new Select(year);
			yearoptions.selectByValue("2012");
			//Locate geneder 
			WebElement gender = driver.findElement(By.className("_8esa"));
			gender.click();
			//Locate sign up button 
			WebElement signup = driver.findElement(By.className("_1lch"));
			signup.click();
			
		}
	
	//invalid email 
		public void SignupMethod02 (String firstna , String surna ,String Email, String Password) throws InterruptedException {
			WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
			firstname.clear();
			firstname.sendKeys(firstna);
			//Locate surname field 
			WebElement surname = driver.findElement(By.xpath("//input[@name='lastname']"));
			surname.clear();
			surname.sendKeys(surna);
			//Locate Mobile or email field 
			WebElement Mobile = driver.findElement(By.xpath("//input[@name='reg_email__']"));
			Mobile.clear();
			Mobile.sendKeys(Email);
			//Locate new password field 
			WebElement pass = driver.findElement(By.id("password_step_input"));
			pass.clear();
			pass.sendKeys(Password);
			//Locate Birth of date
			//find day select
			WebElement day = driver.findElement(By.id("day"));
			Select dayoptions = new Select(day);
			dayoptions.selectByValue("5");
			//find month select 
			WebElement month = driver.findElement(By.id("month"));
			Select monthoptions = new Select(month);
			monthoptions.selectByValue("5");
			//find year select 
			WebElement year = driver.findElement(By.id("year"));
			Select yearoptions =new Select(year);
			yearoptions.selectByValue("2012");
			//Locate geneder 
			WebElement gender = driver.findElement(By.className("_8esa"));
			gender.click();
			//Locate sign up button 
			WebElement signup = driver.findElement(By.className("_1lch"));
			signup.click();
		}
	

}
