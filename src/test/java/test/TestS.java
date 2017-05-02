package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom_pf.AccPage;
import pom_pf.HomePage;
import pom_pf.SignInPage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

@Title("TestS_Start")
@Description("Description")
public class TestS extends Test_BeforeAndAfter {

	// #1
	@Title("test_HomePage")
	@Test(groups = { "ff", "ok" })
	public void test_HomePage() {

		// ????????????????????????
		String exp = "Narvar | Go Beyond the Buy Button";
		// ????????????????????????
		try {
			String act = driver.getTitle();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePage - " + exp);
		}
	}

	// #2
	@Title("test_HomePageToGoSignIn")
	@Test(groups = { "ff", "ok" })
	public void test_HomePageToGoSignIn() {

		boolean exp = true;
		try {
			new HomePage(driver, wait).findAndClickButton_SignIn();

			SignInPage signInPF = new SignInPage(driver, wait);

			boolean act = signInPF.findButton_SignIn_isDisplayed();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePageToGoSignIn " + exp);
		}
	}

	@DataProvider(name = "WrongEmail")
	public static String[][] wrongEmail() {
		String[][] str = { { "qwe", "qweasdzxc", "false" }, { "qwe@", "qweasdzxc", "false" },
				{ "qwe@asd", "qweasdzxc", "false" }, { "qwe@asd.", "qweasdzxc", "false" },
				{ "qwe@asd.c", "qweasdzxc", "false" }, { "qwe@.com", "qweasdzxc", "false" },
				{ "qwe@.", "qweasdzxc", "false" } };
		return str;
	}

	// #3
	@Title("test_HomePageToGoLogin_WrongEmail_ErrorValid")
	@Test(groups = { "ff", "ok" }, dataProvider = "WrongEmail")
	public void test_HomePageToGoLogin_WrongEmail_ErrorValid(String email, String pass, String must) {

		boolean exp = true;
		try {
			new HomePage(driver, wait).findAndClickButton_SignIn();

			SignInPage signInPF = new SignInPage(driver, wait);
			signInPF.findAndFillInField_Username(email);
			signInPF.findAndFillInField_Password(pass);
			signInPF.findAndClickButton_SignIn();

			boolean act = signInPF.findButton_SignIn_isDisplayed();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePageToGoLogin_WrongEmail_ErrorValid - " + email + ":" + pass + " = " + exp);
		}
	}

	@DataProvider(name = "IncorrectEmail")
	public static String[][] incorrectEmail() {
		String[][] str = { { "qwerty@asdf.com", "qweasdzxc", "Your email or password was incorrect." },
				{ "asdfgh@asdf.com", "qweasdzxc", "Your email or password was incorrect." },
				{ "zxcvbn@asdf.com", "qweasdzxc", "Your email or password was incorrect." } };
		return str;
	}

	// #4
	@Title("test_HomePageToGoLogin_IncorrectEmail_ErrorValid")
	@Test(groups = { "ff", "ok" }, dataProvider = "IncorrectEmail")
	public void test_HomePageToGoLogin_IncorrectEmail_ErrorValid(String email, String pass, String must) {

		boolean exp = true;
		try {
			new HomePage(driver, wait).findAndClickButton_SignIn();

			SignInPage signInPF = new SignInPage(driver, wait);
			signInPF.findAndFillInField_Username(email);
			signInPF.findAndFillInField_Password(pass);
			signInPF.findAndClickButton_SignIn();

			boolean act = signInPF.findButton_SignIn_isDisplayed();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePageToGoLogin_IncorrectEmail_ErrorValid - " + email + ":" + pass + " = " + exp);
		}
	}

	@DataProvider(name = "CorrectEmail")
	public static String[][] correctEmail() {
		String[][] str = { { "qwerty@asdf.com", "qweasdzxc", "MyAccName" } };
		return str;
	}

	// #5
	@Title("test_HomePageToGoLogin_CorrectEmail")
	@Test(groups = { "ff", "ok" }, dataProvider = "CorrectEmail")
	public void test_HomePageToGoLogin_CorrectEmail(String email, String pass, String must) {

		String exp = must;
		try {
			new HomePage(driver, wait).findAndClickButton_SignIn();

			SignInPage signInPF = new SignInPage(driver, wait);
			signInPF.findAndFillInField_Username(email);
			signInPF.findAndFillInField_Password(pass);
			signInPF.findAndClickButton_SignIn();
			
			AccPage accPage = new AccPage(driver, wait);

			String act = accPage.findAndFillInField_AccName();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePageToGoLogin_IncorrectEmail_ErrorValid - " + email + ":" + pass + " = " + exp);
		}
	}
}