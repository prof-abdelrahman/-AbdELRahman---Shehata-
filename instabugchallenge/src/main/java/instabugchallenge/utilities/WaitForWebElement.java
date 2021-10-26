package instabugchallenge.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WaitForWebElement {
	
	public static void waitForElement(WebElement locator, WebDriver driver)
	{
		//WebDriver driver=new ;
		while(locator.getSize() == null) {
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   }
	}

}
