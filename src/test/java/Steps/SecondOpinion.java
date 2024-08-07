package Steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SecondOpinion {

	WebDriver driver;

	WebDriverWait wait;

	JavascriptExecutor jsExecutor;

	org.testng.Assert sAssert;

	@Given("Open Browser and Enter Sparsh Url")
	public void open_browser_and_enter_sparsh_url() {
		driver = new FirefoxDriver();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		jsExecutor = (JavascriptExecutor) driver;

		driver.get("https://www.sparshhospital.com/");
	}

	@When("Click on Hospital and Select the Yeshwantpur Hospital Dropdown")

	public void click_on_hospital_and_select_the_yeshwantpur_hospital_dropdown() {

		driver.findElement(By.xpath("(//*[@class='nav-link dropdown-toggle'])[3]")).click();

		driver.findElement(
				By.xpath("(//*[@href='https://www.sparshhospital.com/hospitals/sparsh-hospital-yeswanthpur/'])[1]"))
				.click();

	}

	@When("Select the Second Opinion")
	public void select_the_second_opinion() throws InterruptedException {

		jsExecutor.executeScript("window.scrollBy(0,2000)");

		WebElement secondOpinionElement = driver.findElement(By.xpath("(//*[.='Second Opinion'])[1]"));

		jsExecutor.executeScript("arguments[0].click()", secondOpinionElement);

	}

	@When("Enters the firstname, lastname, phonenumber,emailid")
	public void enters_the_firstname_lastname_phonenumber_emailid() {

		driver.findElement(By.cssSelector("[id='secondopinion_first_name']")).sendKeys("Niraj");

		driver.findElement(By.cssSelector("[id='secondopinion_last_name']")).sendKeys("Kumar");

		driver.findElement(By.cssSelector("[id='secondopinion_phone']")).sendKeys("8579886073");

		driver.findElement(By.cssSelector("[id='secondopinion_email']")).sendKeys("nirajyadav@gmail.com");
	}

	@When("Upload the report and Enter the Message and click the send button")

	public void upload_the_report_and_enter_the_message_and_click_the_send_button() throws InterruptedException {

		driver.findElement(By.cssSelector("#secondopinion_reports"))
				.sendKeys("C:\\Users\\Prince Raj\\OneDrive\\Desktop\\New Text Document.txt");

		driver.findElement(By.cssSelector("[placeholder='Your Message']")).sendKeys("Thanks for Let me Entering data");

		WebElement send = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));

		jsExecutor.executeScript("arguments[0].click()", send);
	}

	@Then("Thank you should have in displayed")

	public void thank_you_should_have_in_displayed() {

		String pr = driver.findElement(By.xpath("//h1[.='Thank you']")).getText();

		sAssert.assertEquals(pr, "Thank you");
	}

	@Then("Bank info should have been displayed")

	public void bank_info_should_have_been_displayed() {

		String pr2 = driver.findElement(By.xpath("//strong[.='Account Holder Name:']")).getText();

		sAssert.assertEquals(pr2, "Account Holder Name:");

		driver.quit();
	}
}
