package xyzBank;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases extends parametrs {

	@BeforeTest
	public void beforeTest() {
		driver.get("https://globalsqa.com/angularJs-protractor/BankingProject/#/login ");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void signup() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement bankManagerLoginButton = driver.findElement(By.cssSelector("button[ng-click='manager()']"));
		bankManagerLoginButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement addCustomerButton = driver.findElement(By.cssSelector(".btn.btn-lg.tab[ng-class='btnClass1']"));
		addCustomerButton.click();
		Thread.sleep(2000);
		WebElement userFirstName = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
		WebElement userLastName = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
		WebElement userPostCode = driver.findElement(By.cssSelector("input[placeholder='Post Code']"));
		userFirstName.sendKeys(userFirstNames[randomIndex]);
		userLastName.sendKeys(userLastNames[randomNumber]);
		userPostCode.sendKeys(userPostCodes[randomInt]);
		Thread.sleep(2000);
		try {
			WebElement addButton = driver.findElement(By.cssSelector("button[type='submit']"));
			addButton.click();
			handleAlert();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 2)
	public void addCustomer() throws InterruptedException {

		WebElement openAccountButton = driver.findElement(By.cssSelector(".btn.btn-lg.tab[ng-class='btnClass2']"));
		openAccountButton.click();
		Thread.sleep(2000);
		WebElement cusomerName = driver.findElement(By.name("userSelect"));
		Select select = new Select(cusomerName);
		select.selectByIndex(6);
		WebElement currencyElement = driver.findElement(By.id("currency"));
		Select sele = new Select(currencyElement);
		sele.selectByIndex(randomNum);
		Thread.sleep(2000);
		try {
			WebElement processButton = driver.findElement(By.cssSelector("button[type='submit']"));
			processButton.click();
			handleAlert();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void deleteCutomer() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement cusomersButton = driver.findElement(By.xpath("//button[normalize-space()='Customers']"));
		cusomersButton.click();
		Thread.sleep(4000);
		WebElement deleteButton = driver
				.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[6]/td[5]/button"));
		deleteButton.click();
	}

	@AfterTest
	public void postTest() {
	}

	private void handleAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert Message: " + alert.getText());
			alert.accept();
		} catch (Exception e) {

		}
	}

}
