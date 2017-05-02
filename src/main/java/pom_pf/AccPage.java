package pom_pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class AccPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(name = "accName")
	private WebElement accName;

	public AccPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(this.driver, this);
	}

	@Step("findAndFillInField_AccName")
	public String findAndFillInField_AccName() {
		return wait.until(ExpectedConditions.visibilityOf(accName)).getText();
	}
}