package loginTesting;

import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {
	
	    ChromeDriver driver;
//Open the browser & redirect to Facebook login page 
	    
public void openURL (String url){
		
		String path = System.getProperty("user.dir")+"\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(url);

		 
	}
}
