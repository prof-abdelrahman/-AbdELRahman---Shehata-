package instabugchallenge.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AfterNextPage {
	public WebElement previousPageButton = null;
	
	public AfterNextPage(WebDriver driver) {
		previousPageButton = driver.findElement(By.xpath("//*[contains(@id,'pnprev')]"));
	}
}
