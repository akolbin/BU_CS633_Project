package pageObjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.Wait;

import managers.FileReaderManager;
import dataProviders.*;


public class Rooms {
	WebDriver driver;
	Wait wait;
	
	public Rooms(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(css = "#check-in > div.calendar-button.s-separator.s-field.focused > wix-svg > svg")
	public WebElement checkinDate;
	
	@FindBy(css = "#icx86r8x_0 > iframe")
	public WebElement bookRoomFrame;
	
	@FindBy(css = " div.s-separator.visible>div > nav > button.navigate-right")
	public WebElement checkinNextMonth;
	
	@FindBy(css = "div.s-separator.visible > div > div.body > table > tbody > tr > td > button > span")
	public WebElement selectCheckInDate;
	
	@FindBy(xpath = "(.//span[text()='Check-Out'])[2]")
	public WebElement checkoutDate;
	
	@FindBy(css = "div.calendar-popup.s-field.s-separator.visible > div > div.body > table > tbody > tr > td>button>span")
	public WebElement selectCheckOutDate;
	
	@FindBy(css = "div#adults > a.up")
	public WebElement adults;
	
	@FindBy(css = "div#children > a.up")
	public WebElement kids;
	
	@FindBy(xpath = ".//span[text()='Search']")
	public WebElement searchButton;
	
	@FindBy(css = "#content > div > div.content-body > div > ul > li:nth-child(1) > div > div.info > div.bottom > button > span")
	public WebElement standardDoubleRoomBook;
	
	@FindBy(css = "#content > div > div.content-body > div > ul > li:nth-child(2) > div > div.info > div.bottom > button > span")
	public WebElement standardKingRoomBook;
	
	@FindBy(css = "#content > div > div.content-body > div > ul > li:nth-child(3) > div > div.info > div.bottom > button > span")
	public WebElement SuiteRoomBook;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/ul/li[1]/div/div[2]/div[4]/span/span/form/button")
	public WebElement standardDoubleBookNow;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/ul/li[2]/div/div[2]/div[4]/span/span/form/button")
	public WebElement standardKingBookNow;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/ul/li[3]/div/div[2]/div[4]/span/span/form/button")
	public WebElement suiteBookNow;
	
	@FindBy(css = "input#firstName")
	public WebElement firstName;
	
	@FindBy(css = "input#lastName")
	public WebElement lastName;
	
	@FindBy(css = "input#email")
	public WebElement email;
	
	@FindBy(css = "input#phone")
	public WebElement phone;
	
	@FindBy(css = "input#country")
	public WebElement country;
	
	@FindBy(css = "button.btn.btn-confirm.pay-now")
	public WebElement continueToCheckout;
	
	@FindBy(xpath = ".//button[text()='Complete Checkout']")
	public WebElement completeCheckout;
	
	@FindBy(css = "div.thank-you>h1")
	public WebElement confirmationMessage;
	
	@FindBy(css = "div.reservation-number>strong")
	public WebElement confirmationNumber;
	
	@FindBy(css = "#singleroom > div.widget.s-separator.s-background2.breakdown-widget > div.booknow > span > form > button")
	public WebElement bookNowButton;

	public void selectCheckInDate() throws Throwable {
//		driver.switchTo().frame(bookRoomFrame);
//		wait.waitUntilObjectClickable(driver, checkinDate);
		checkinDate.click();
		WebElement checkIndateWidget = selectCheckInDate;
		List<WebElement> columns = checkIndateWidget.findElements(By.tagName("button"));
		
		for (WebElement cell : columns) {
			if (cell.getText().equals("14")){
			      cell.findElement(By.linkText("14")).click();
			      break;
			}
		}
	}
	
	public void selectCheckOutDate() throws Throwable {
//		wait.waitUntilObjectClickable(driver, checkoutDate);
//		checkoutDate.click();
		WebElement checkoutdateWidget = selectCheckOutDate;
		List<WebElement> columns = checkoutdateWidget.findElements(By.tagName("button"));
		
		for (WebElement cell : columns) {
			if (cell.getText().equals("15")){
			      cell.findElement(By.linkText("15")).click();
			      break;
			}
		}
		driver.switchTo().defaultContent();
	}
	
	public void clickStandardDouble() throws Throwable{
		wait.waitUntilObjectClickable(driver, standardDoubleRoomBook);
		standardDoubleRoomBook.click();
//		wait.waitUntilObjectClickable(driver, standardDoubleBookNow);
//		standardDoubleBookNow.click();
	}
	
	public void clickStandardKing() throws Throwable{
//		wait.waitUntilObjectClickable(driver, standardKingRoomBook);
//		standardKingRoomBook.click();
		wait.waitUntilObjectClickable(driver, standardDoubleBookNow);
		standardKingBookNow.click();
	}
	
	public void clickSuite() throws Throwable{
//		wait.waitUntilObjectClickable(driver, SuiteRoomBook);
//		SuiteRoomBook.click();
		wait.waitUntilObjectClickable(driver, suiteBookNow);
		suiteBookNow.click();
	}
	
	public void enterFirstName(String test) throws Throwable{
		wait.waitUntilObjectClickable(driver, firstName);
		firstName.sendKeys(test);
	}
	
	public void enterLastName(String test) throws Throwable {
		wait.waitUntilObjectClickable(driver, lastName);
		lastName.sendKeys(test);
	}
	
	public void enterEmail(String test) throws Throwable{
		wait.waitUntilObjectClickable(driver, email);
		email.sendKeys(test);
	}
	
	public void enterPhone(String test) throws Throwable{
		wait.waitUntilObjectClickable(driver, phone);
		phone.sendKeys(test);
	}
	
	public void clickContinueToCheckout() throws Throwable{
		wait.waitUntilObjectClickable(driver, continueToCheckout);
		continueToCheckout.click();
	}
	
	public void clickCompleteCheckout() throws Throwable{
		wait.waitUntilObjectClickable(driver, completeCheckout);
		completeCheckout.click();
	}
	
	public void clickBookNowButton() throws Throwable{
		wait.waitUntilObjectClickable(driver, bookNowButton);
		bookNowButton.click();
	}
}
