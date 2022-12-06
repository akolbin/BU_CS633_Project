package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;

public class UrlLaunchPage {

	WebDriver driver;
	
	public UrlLaunchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);    
	}
	
	public void navigateToApplicationPage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}

}
