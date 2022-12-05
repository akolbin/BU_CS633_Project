package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Homepage;
import pageObjects.Rooms;
import pageObjects.UrlLaunchPage;

public class HomepageStepDefinitions {
	
	WebDriver driver;

	TestContext testContext;
	Homepage home;
	UrlLaunchPage urlLaunchPage;
	Rooms room;
	
	public HomepageStepDefinitions(TestContext context) {
		testContext = context;
		home = testContext.getPageObjectManager().getHomePage();
		urlLaunchPage =  testContext.getPageObjectManager().getUrlLaunchPage();
		room = testContext.getPageObjectManager().getRoomsPage();
	}
	
	@Given("^I am on homepage$")
	public void i_am_on_homepage() throws Throwable{
		urlLaunchPage.navigateToApplicationPage();
	}
	
	@When("^I click on About us link$")
	public void i_click_on_About_us_link() throws Throwable{
		home.clickAboutUs();
	}
	
	@When("^I click on Rooms link$")
	public void i_click_on_Rooms_link() throws Throwable{
		home.clickRooms();
	}
	
	@When("^I click on Activities link$")
	public void i_click_on_Activities_link() throws Throwable{
		home.clickActivities();
	}
	
	@When("^I click on Book Now Button$")
	public void i_click_on_Book_Now_button() throws Throwable{
		home.clickBookNow();
	}
	
	@When("^I click on Contact link")
	public void i_click_on_Contact_link() throws Throwable{
		home.clickContact();
	}
	
	@Then("^I should be navigated to About us Page$")
	public void i_should_be_naviagted_to_About_us_Page() throws Throwable{
		Thread.sleep(10000);
		String Url = home.getUrl();
		Assert.assertTrue("User is not navigated to About us Page", Url.contains("/about-us"));
	}
	
	@Then("^I should be navigated to Rooms Page$")
	public void i_should_be_navigated_to_Rooms_Page() throws Throwable{
		Thread.sleep(10000);
		String Url = home.getUrl();
		Assert.assertTrue("User is not navigated to Rooms Page", Url.contains("/rooms-rates"));
	}
	
	@Then("^I should be navigated to Activities Page$")
	public void i_should_be_navigated_to_Activities_Page() throws Throwable{
		Thread.sleep(10000);
		String Url = home.getUrl();
		Assert.assertTrue("User is not navigated to Activities Page", Url.contains("/activities"));
	}
	
	@Then("^I should be navigated to Contact Page$")
	public void i_should_be_navigated_to_Contact_Page() throws Throwable{
		Thread.sleep(10000);
		String Url = home.getUrl();
		Assert.assertTrue("User is not navigated to Contact Page", Url.contains("/contact"));
	}
	
	@When("^I book a room entering my details$")
	public void i_book_a_room_entering_my_details() throws Throwable{
		room.clickStandardDouble();
		room.selectCheckInDate();
		room.selectCheckOutDate();
		room.clickBookNowButton();
		room.enterFirstName("Chaitra");
		room.enterLastName("Joshi");
		room.enterEmail("chaitraj@bu.edu");
		room.enterPhone("1234567890");
		Select se = new Select(room.country);
		se.selectByVisibleText("India");
		room.clickContinueToCheckout();
		room.clickCompleteCheckout();
	}

	@Then("^I should get a booking ID and room booked on my name$")
	public void i_should_get_a_booking_ID_and_room_booked_on_my_name() throws Throwable{
		Thread.sleep(2000);
		Assert.assertTrue("Confirmation message is not displayed", room.confirmationMessage.isDisplayed());
		Assert.assertTrue("Confirmation number is not displayed", room.confirmationNumber.isDisplayed());
	}
}