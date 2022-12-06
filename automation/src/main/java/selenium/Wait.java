package selenium;


import java.util.function.Function;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import managers.FileReaderManager;

public abstract class Wait {

	public static void untilJqueryIsDone(WebDriver driver) throws InterruptedException {
		untilJqueryIsDone(driver, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
	}

	public static void untilJqueryIsDone(final WebDriver driver, Long timeoutInSeconds) throws InterruptedException {
		until(driver, new Function<WebDriver, Boolean>() {
			@Override
			public Boolean apply(WebDriver d) {
				Boolean isJqueryCallDone = (Boolean) ((JavascriptExecutor) driver)
						.executeScript("return jQuery.active==0");
				if (!isJqueryCallDone)
					System.out.println("JQuery call is in Progress");
				return isJqueryCallDone;
			}
		}, timeoutInSeconds);
	}

	public static void untilPageLoadComplete(WebDriver driver) throws InterruptedException {
		untilPageLoadComplete(driver, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
	}

	public static void untilPageLoadComplete(final WebDriver driver, Long timeoutInSeconds)
			throws InterruptedException {
		until(driver, new Function<WebDriver, Boolean>() {
			@Override
			public Boolean apply(WebDriver d) {
				Boolean isPageLoaded = (Boolean) ((JavascriptExecutor) driver)
						.executeScript("return document.readyState").equals("complete");
				if (!isPageLoaded)
					System.out.println("Document is loading");
				return isPageLoaded;
			}
		}, timeoutInSeconds);
	}

	public static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition) throws InterruptedException {
		until(driver, waitCondition, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
	}

	private static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition, Long timeoutInSeconds)
			throws InterruptedException {
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutInSeconds);
		webDriverWait.wait(timeoutInSeconds);
		try {
			webDriverWait.until(waitCondition);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	public static void waitUntilObjectFound(WebDriver driver, WebElement element) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,60);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	@SuppressWarnings("deprecation")
	public static void waitUntilObjectClickable(WebDriver driver, WebElement element) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Thread.sleep(10000);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void clickByAction(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}
	
	public static void clickUsingJavaScriptExecutor(WebDriver driver, WebElement element) throws Throwable {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(5000);
		jse.executeScript("arguments[0].scrollIntoView()", element); 
	}

}