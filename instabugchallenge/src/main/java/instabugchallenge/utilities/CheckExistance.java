package instabugchallenge.utilities;

import org.openqa.selenium.WebElement;

public class CheckExistance {
	public static boolean elementExists(WebElement locator)
	{
	    return locator.getSize() != null;
	}

}
