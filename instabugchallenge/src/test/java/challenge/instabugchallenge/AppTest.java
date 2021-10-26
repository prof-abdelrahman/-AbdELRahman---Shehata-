package challenge.instabugchallenge;


//import org.openqa.selenium.By;

//import static org.testng.Assert.assertTrue;

//import java.io.IOException;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import org.testng.annotations.TestInstance;
import org.testng.asserts.SoftAssert;

import instabugchallenge.page.*;
import instabugchallenge.utilities.*;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
	
    @Test
    public void shouldAnswerWithTrueWhenClickOnSearch() /*throws InterruptedException*/
    {
    	//SoftAssert softAssert = new SoftAssert();
    	WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(); 
        driver.navigate().to("https://www.google.com/");
        GooglePage searchPage = new GooglePage(driver);
        driver.manage().window().maximize();
        //softAssert.assertTrue(CheckExistance.elementExists(searchPage.googleLogo),"Logo not Found");
        //softAssert.assertTrue(CheckIfCenteredAligned.isCentered(searchPage.googleLogo,driver),"Logo not Centered");
        //searchPage.EnterSearchRequest("QualityLogic");
        //searchPage.ClearSearchRequest(searchPage.searchTextBox);
        searchPage.EnterSearchRequest("Instabug");
        searchPage.ClickSearch();
        //NextWebPage nextPage = new NextWebPage(driver);
        //Thread.sleep(1000);
        //WaitForWebElement.waitForElement(allChoice,driver); no need to make a wait for the element to be shown
        //softAssert.assertTrue(CheckExistance.elementExists(nextPage.newPageElement),"Next Web Page is not Correct");
        //softAssert.assertAll();   
        
        // No need to make same tests twice so I made them in the test when pressing enter only
    }
    @Test
    public void shouldAnswerWithTrueWhenClickOnEnter() /*throws InterruptedException*/
    {
    	SoftAssert softAssert = new SoftAssert();
    	WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(); 
        driver.navigate().to("https://www.google.com/");
        GooglePage searchPage = new GooglePage(driver);
        driver.manage().window().maximize();
        softAssert.assertTrue(CheckExistance.elementExists(searchPage.googleLogo),"Logo not Found");
        softAssert.assertTrue(CheckExistance.elementExists(searchPage.changeLanguages),"Choice of Different Languages not Shown");
        //softAssert.assertTrue(CheckIfCenteredAligned.isCentered(searchPage.googleLogo,driver),"Logo not Centered");
        searchPage.EnterSearchRequest("QualityLogic");
        searchPage.ClearSearchRequest(searchPage.searchTextBox);
        searchPage.EnterSearchRequest("Instabug");
        searchPage.PressEnter(searchPage.searchRequest);
        NextWebPage nextPage = new NextWebPage(driver);
        //Thread.sleep(1000); no need for the sleep
        //WaitForWebElement.waitForElement(allChoice,driver); no need to make a wait for the element to be shown
        softAssert.assertTrue(CheckExistance.elementExists(nextPage.newPageElement),"Next Web Page is not Correct");
        //String expected = "https://www.google.com/search?q=Instabug&source=hp&ei=CmZ3YZb1H62JlwTsq4yQAg&iflsig=ALs-wAMAAAAAYXd0GpK3b6DPJ1h-G0PvaCLRMaanmvsp&ved=0ahUKEwiWopiGgufzAhWtxIUKHewVAyIQ4dUDCAs&oq=Instabug&gs_lcp=Cgdnd3Mtd2l6EAxQ6gRYqQVgwwVoAXAAeACAAQCIAQCSAQCYAQCgAQGwAQA&sclient=gws-wiz";
        //softAssert.assertEquals(expected, nextPage.ActualLink(driver),"Next Web Page result is not Correct");
        // when tested found that same web page result on google get different urls so cannot use assertEquals to test the urls
        //softAssert.assertTrue(CheckExistance.elementExists(nextPage.diffLanguages),"Choice of Different Languages not Shown");
        softAssert.assertTrue(CheckExistance.elementExists(nextPage.ResultsStats), "Results Stats not Shown");
        if(CheckExistance.elementExists(nextPage.secondPageButton))
        	System.out.println("Results Page got more than one Page");
        softAssert.assertTrue(CheckExistance.elementExists(nextPage.nextPageButton),"Next Page for Result Button is not Shown");
        softAssert.assertTrue(CheckExistance.elementExists(nextPage.secondPageButton),"Second Page for Result Button is not Shown");
        if(CheckExistance.elementExists(nextPage.nextPageButton)) { 
            ClickOnWebElement.ClickButton(nextPage.nextPageButton);
            AfterNextPage afterNextPage = new AfterNextPage(driver);
            softAssert.assertTrue(CheckExistance.elementExists(afterNextPage.previousPageButton),"Previous Page Button is not Shown in the Second Page");
            ClickOnWebElement.ClickButton(afterNextPage.previousPageButton);
        }
        softAssert.assertAll();
    }
}
