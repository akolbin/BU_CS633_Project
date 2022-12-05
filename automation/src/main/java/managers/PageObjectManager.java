package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.Homepage;
import pageObjects.Rooms;
import pageObjects.UrlLaunchPage;


public class PageObjectManager {
	private WebDriver driver;
	private Rooms room;
	private Homepage home;
	private UrlLaunchPage urlLaunchPage;

	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public Homepage getHomePage() {
		return (home == null) ? home = new Homepage(driver) : home;
	}
	
	public Rooms getRoomsPage() {
		return (room == null) ? room = new Rooms(driver) : room;
	}
	
	public UrlLaunchPage getUrlLaunchPage() {
		return (urlLaunchPage == null) ? urlLaunchPage = new UrlLaunchPage(driver) : urlLaunchPage;
	}

}
