package loginBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage extends BasePage{
	
	public Loginpage (WebDriver driver) {
		super (driver);
	}
	//Locate mail field in login form 
	WebElement Email = driver.findElement(By.id("email"));
	
	//Locate pass field in login form 
	WebElement Pass = driver.findElement(By.id("pass"));
	
	//Locate login button in login form 
	WebElement btn = driver.findElement(By.className("_6ltg"));
	
	//Locate Validation error message 

	
	//Actions in login form
	public void loginMethod (String mail , String password) throws InterruptedException {
		
		Email.clear();
		Email.sendKeys(mail);
		Pass.clear();
		Pass.sendKeys(password);
		btn.click();
		Thread.sleep(3000);
		
	}
	
	
	
	

}
