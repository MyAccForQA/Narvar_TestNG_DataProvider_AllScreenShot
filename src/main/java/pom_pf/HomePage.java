package pom_pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class HomePage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//a[contains(text(), 'Login')]")
	private WebElement login;

	@FindBy(xpath = "//a[contains(text(), 'Sign In')]")
	private WebElement signIn;

	public HomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(this.driver, this);
	}

	@Step("findAndClickButton_SignIn")
	public WebElement findAndClickButton_SignIn() {
		// signIn.click();
		wait.until(ExpectedConditions.elementToBeClickable(signIn)).click();
		return signIn;
	}
}