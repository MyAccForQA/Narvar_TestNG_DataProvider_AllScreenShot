package pom_pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class SignInPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(id = "username")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(xpath = "//button[@class = '_2pL_i btn btn-primary' and contains(text(), 'Sign In')]")
	private WebElement buttonSignIn;

	public SignInPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(this.driver, this);
	}

	@Step("findAndFillInField_Username with name - [{0}]")
	public WebElement findAndFillInField_Username(String st) {
		// username.clear();
		wait.until(ExpectedConditions.visibilityOf(username)).clear();
		wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(st);
		return username;
	}

	@Step("findAndFillInField_Password with pass - [{0}]")
	public WebElement findAndFillInField_Password(String st) {
		// password.clear();
		wait.until(ExpectedConditions.visibilityOf(password)).clear();
		wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(st);
		return password;
	}

	@Step("findButton_SignIn return boolean is isEnabled")
	public boolean findButton_SignIn_isEnabled() {
		return buttonSignIn.isEnabled();
	}

	@Step("findButton_SignIn return boolean is isDisplayed")
	public boolean findButton_SignIn_isDisplayed() {
		return buttonSignIn.isDisplayed();
	}

	@Step("findAndClickButton_SignIn")
	public WebElement findAndClickButton_SignIn() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// buttonSignIn.click();
		wait.until(ExpectedConditions.visibilityOf(buttonSignIn)).click();

		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return buttonSignIn;
	}
}