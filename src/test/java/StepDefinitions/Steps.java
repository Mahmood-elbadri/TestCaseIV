package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import Pages.HomePage;
import Pages.MobilesMenu;

public class Steps {
	WebDriver driver;
	HomePage home;
	MobilesMenu mobile;
	String url;

	@Before
	public void beforeRun() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		home = new HomePage(driver);

		mobile = new MobilesMenu(driver);
		url = "http://live.techpanda.org/index.php/";
	}

	@After
	public void afterRun() {
		driver.quit();
	}

	@Given("Navigate to the site ,Click on mobile menu")
	public void navigate_to_the_site_click_on_mobile_menu() {
		driver.navigate().to(url);
		home.clickMobileBtn();
	}

	@When("In mobile product list click add to compare two devices")
	public void in_mobile_product_list_click_add_to_compare_devices() {
		mobile.clickAddtoCompare();
	}

	@And("Click compare button, verify the pop-up window")
	public void click_compare_button_verify_the_pop_up_window() {
		mobile.clickCompareBtn();
	}

	@Test
	@And("check the products reflected on it")
	public void check_the_products_reflected_on_it() {
		Assert.assertEquals(2, mobile.numberOfMobiles());
		System.out.println("yasta elsize aho yasta " + mobile.numberOfMobiles());
	}

	@Then("close the pop-up window")
	public void close_the_pop_up_window() {
		try {
			Thread.sleep(5_000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mobile.closePop();
		try {
			Thread.sleep(5_000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
