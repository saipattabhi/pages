package hpack;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class downloadingfile {
	
	WebDriver driver;
	@Test
	public void downloadfile() throws InterruptedException
	{
	
	ChromeOptions options = new ChromeOptions();
	
	Map<String, Object> prefs = new HashMap<String, Object>();
	prefs.put("download.prompt_for_download", false);
	
	String destinationfilepath = System.getProperty("user.dir");
	
	prefs.put("download.default_directory",destinationfilepath );
	
	
	
	options.setExperimentalOption("prefs", prefs);
	
	WebDriverManager.chromedriver().setup();
	
	driver = new ChromeDriver(options);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	

	driver.get("https://chromedriver.storage.googleapis.com/index.html?path=79.0.3945.36/");
	Thread.sleep(2000);
	WebElement btnDownload = driver.findElement(By.xpath(".//a[text()='chromedriver_win32.zip']"));
	btnDownload.click();
	
	
	File file =new File(destinationfilepath+"\\remo");
	
	if(file.exists())
	{
		
		System.out.println("yes");
	}
	
	else
	{
		
		System.out.println("No");
	}
	
	}
	
	
	
	
	
	
	

}
