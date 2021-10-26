package instabugchallenge.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {
	public WebElement googleLogo = null;
	public WebElement searchTextBox = null;
	public WebElement searchRequest = null;
	public WebElement changeLanguages = null;
	//public WebElement allChoice = null;
	
	public GooglePage(WebDriver driver) {
		googleLogo = driver.findElement(By.xpath("//*[contains(@class,'lnXdpd')]"));
		searchTextBox = driver.findElement(By.xpath("//*[contains(@class,'gLFyf gsfi')]"));
		searchRequest = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]"));
		changeLanguages = driver.findElement(By.xpath("//*[contains(@dir,'rtl')]"));
		//allChoice = driver.findElement(By.xpath("//*[contains(@class,'hdtb-mitem hdtb-msel')]"));
	}
	
	public void EnterSearchRequest(String search){
		searchTextBox.sendKeys(search);
	}
	public void ClearSearchRequest(WebElement toClear){
		toClear.sendKeys(Keys.CONTROL + "a");
		toClear.sendKeys(Keys.DELETE);
	}
	public void PressEnter(WebElement toEnter){
		toEnter.sendKeys(Keys.ENTER);
	}
	public void ClickSearch() /*throws InterruptedException*/{
		//Thread.sleep(1000);
		searchRequest.click();
	}
	}