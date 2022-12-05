package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.Wait;

public class Homepage {
	WebDriver driver;
	Wait wait;
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(xpath = ".//p[text()='About Us']")
	public WebElement aboutUsLink;
	
	@FindBy(xpath = ".//p[text()='Rooms']")
	public WebElement roomsLink;
	
	@FindBy(xpath = ".//p[text()='Activities']")
	public WebElement activitiesLink;
	
	@FindBy(xpath = ".//p[text()='Contact']")
	public WebElement contactLink;
	
	@FindBy(xpath = ".//a[@data-testid='linkElement']/span")
	public WebElement bookNowButton;
	
	public String getUrl() {
    	String URL = driver.getCurrentUrl();
    	return URL;
    }
	
    public void clickAboutUs() throws Throwable {
    	wait.waitUntilObjectClickable(driver, aboutUsLink);
    	aboutUsLink.click();
    }
    
    public void clickRooms() throws Throwable {
    	wait.waitUntilObjectClickable(driver, roomsLink);
    	roomsLink.click();
    }
    
    public void clickActivities() throws Throwable {
    	wait.waitUntilObjectClickable(driver, activitiesLink);
    	activitiesLink.click();
    }
    
    public void clickContact() throws Throwable {
    	wait.waitUntilObjectClickable(driver, contactLink);
    	contactLink.click();
    }
    
    public void clickBookNow() throws Throwable {
    	wait.waitUntilObjectClickable(driver, bookNowButton);
    	bookNowButton.click();
    }
    
   
   
}