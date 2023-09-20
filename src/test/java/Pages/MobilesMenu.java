package Pages;

import java.util.ArrayList;
import java.awt.Window;
import java.util.*;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobilesMenu {
	private String homepage;

	WebDriver driver;
	@FindBy(xpath = "(//a[@class='link-compare'][normalize-space()='Add to Compare'])[1]")
	private WebElement addFirstMobileToCompare;
	@FindBy(xpath = "//button[@title='Compare']")
	private WebElement compareBtn;
	@FindBy(xpath = "(//a[@class='link-compare'][normalize-space()='Add to Compare'])[2]")
	private WebElement addSecondMobileToCompare;
	@FindBy(xpath = "//a[@class='product-image']")
	private List<WebElement> Mobiles;

	public MobilesMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickAddtoCompare() {
		addFirstMobileToCompare.click();
		addSecondMobileToCompare.click();
	}

	public void clickCompareBtn() {
		compareBtn.click();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> ite = handles.iterator();
		String homepage = ite.next(); // get the main window handle
		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();
			if (!popupHandle.contains(homepage)) {
				driver.switchTo().window(popupHandle); // switch to the popup window
			}
		}

	}
	public int numberOfMobiles() {
		return(Mobiles.size());
	}
	public void closePop() {
		driver.close();
	}
}
