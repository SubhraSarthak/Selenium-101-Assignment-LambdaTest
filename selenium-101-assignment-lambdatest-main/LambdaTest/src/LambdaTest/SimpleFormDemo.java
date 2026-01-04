package LambdaTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleFormDemo {
	@Test
	public void setUp() throws MalformedURLException {

		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("dev");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "routsubhrasarthak");
		ltOptions.put("accessKey", "LT_9y4b7Fnm15QNrqbqu1KlOxPHYAXcEuH4X3c6ACkGyUrSxG7");
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("network", true);
		ltOptions.put("project", "Untitled");
		ltOptions.put("selenium_version", "4.0.0");
		ltOptions.put("w3c", true);
		ltOptions.put("accessibility", true);
		browserOptions.setCapability("LT:Options", ltOptions);

		WebDriver driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);

		driver.get("https://www.lambdatest.com/selenium-playground");

		driver.findElement(By.linkText("Simple Form Demo")).click();

		Assert.assertTrue(driver.getCurrentUrl().contains("simple-form-demo"));

		String message = "Welcome to LambdaTest";

		WebElement messageBox = driver.findElement(By.id("user-message"));
		messageBox.sendKeys(message);

		driver.findElement(By.xpath("//button[@id='showInput']")).click();

		WebElement outputMessage = driver.findElement(By.id("message"));
		Assert.assertEquals(outputMessage.getText(), message);

		driver.quit();

	}
}