package test;

import java.sql.Driver;
import java.sql.DriverAction;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class BaseTest {
	public static WebDriver driver;
	  
	  public void switchToChildWindow(String expectedTiltle)   {
	    
	  Set<String>handles =driver.getWindowHandles();
	  
	    Iterator<String> i = handles.iterator();
	    
	    while(i.hasNext())
	    {
	      String handle  =i.next();
	      driver.switchTo().window(handle);
	      String currentTitle = driver.getTitle();
	      
	      if(currentTitle.equalsIgnoreCase(expectedTiltle))
	      {
	        break;
	      }
	    }
	  }
}
	    
	  

