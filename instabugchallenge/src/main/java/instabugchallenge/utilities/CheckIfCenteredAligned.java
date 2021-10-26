package instabugchallenge.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.util.List;


public class CheckIfCenteredAligned {
	public static boolean isCentered(WebElement locator, WebDriver driver) {
		//return locator == driver.findElement(By.cssSelector("div[align='center']"));
		List<WebElement> divList = driver.findElements(By.cssSelector("div[align='center']"));
		// and use every single one
		for (WebElement elem : divList) {
			if(elem==locator) {
				return true;
			}
		    //System.out.print(elem.getText());
		}
		return false;
	}

}
