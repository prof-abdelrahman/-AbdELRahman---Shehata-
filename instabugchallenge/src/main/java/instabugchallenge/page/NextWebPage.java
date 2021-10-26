package instabugchallenge.page;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NextWebPage {
	public WebElement newPageElement = null;
	public WebElement ResultsStats = null;
	public WebElement nextPageButton = null;
	public WebElement secondPageButton = null;
	//WebElement newPageElement = null;
	//WebElement newPageElement = null;
	public NextWebPage(WebDriver driver) {
		newPageElement = driver.findElement(By.xpath("//*[contains(@class,'hdtb-mitem hdtb-msel')]"));
		ResultsStats = driver.findElement(By.xpath("//*[contains(@id,'result-stats')]"));
		nextPageButton = driver.findElement(By.xpath("//*[contains(@id,'pnnext')]"));
		secondPageButton = driver.findElement(By.xpath("//*[contains(@aria-label,'Page 2')]"));
	}
	public String ActualLink(WebDriver driver) {
		return driver.getCurrentUrl();
	}

}
