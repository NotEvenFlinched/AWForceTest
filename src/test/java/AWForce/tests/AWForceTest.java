package AWForce.tests;

import AWForce.pages.AWForceLoginPage;
import AWForce.pages.AWForceResetPasswordPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class AWForceTest {
    private static WebDriver driver;
    private static AWForceLoginPage loginPage;
    private static AWForceResetPasswordPage resetPasswordPage;

    @BeforeClass
    public void init() {
        driver = Init.getDriver();
        loginPage = new AWForceLoginPage(driver);
        resetPasswordPage = new AWForceResetPasswordPage(driver);
    }

    @BeforeMethod()
    public void openLoginPage() {
        driver.get("https://accounts.us1.advisor.ws/user/login");
    }

    @Test(testName = "Check the possibility to log in with all the fields empty")
    public void testA() {
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getUsernameFieldValidationMessage(), "Please fill out this field.", "Validation message does not match the expected message");
    }

    @Test(testName = "Check the possibility to log in with the invalid password")
    public void testB() {
        loginPage.enterUsernameOrEmail("Wonderio619");
        loginPage.enterPassword("123456");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getWrongUsernameMessageElementText(), "Unrecognized username or password. Have you forgotten your password?", "Validation message does not match the expected message");
    }

    @Test(testName = "Check the possibility to reset the password")
    public void testC() {
        loginPage.clickResetPasswordButton();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://accounts.us1.advisor.ws/user/password", "Reset password page is not opened");
    }

    @Test(testName = "Check the possibility to reset the password with the valid Email")
    public void testD() {
        loginPage.clickResetPasswordButton();
        resetPasswordPage.enterUsernameOrEmail("Wonderio619");
        resetPasswordPage.clickSubmitButton();
        Assert.assertTrue(loginPage.getPasswordResetMessage().contains("Further instructions have been sent to your email address."));
    }


    @Test(testName = "Check the possibility to reset the password with the invalid e-mail")
    public void testE() {
        loginPage.clickResetPasswordButton();
        resetPasswordPage.enterUsernameOrEmail("1111@gmail.com");
        resetPasswordPage.clickSubmitButton();
        Assert.assertEquals(resetPasswordPage.getWrongUsernameMessageElementText(), "1111@gmail.com is not recognized as a username or an email address.", "Error message does not match the expected message");
    }

    @Test(testName = "Check the possibility to log in with the Google account")
    public void testF() {
        loginPage.clickLogInWithGoogleButton();
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.startsWith("https://accounts.google.com/"), "Google authorization page is not opened");
    }

    @Test(testName = "Check the possibility to reset the password with empty e-mail field")
    public void testH() {
        loginPage.clickResetPasswordButton();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://accounts.us1.advisor.ws/user/password", "Reset password page is not opened");
        resetPasswordPage.clickSubmitButton();
        Assert.assertEquals(resetPasswordPage.getUsernameFieldValidationMessage(), "Please fill out this field.", "Validation message does not match the expected message");
    }

    @Test(testName = "Check the possibility to see the symbols in the password field")
    public void testG() {
        loginPage.enterPassword("123456");
        loginPage.showEnteredPassword();
        Assert.assertTrue(loginPage.checkIsPasswordVisible());
    }


    @Test(testName = "Check the possibility to create  a new account")
    public void testI() {
        loginPage.clickCreateAccountButton();
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.startsWith("https://signup.advisor.ws"), "Account creation page is not opened");
    }

    @Test(testName = "Check the possibility to log in with the valid data")
    public void testJ() {
        loginPage.enterUsernameOrEmail("Wonderio619");
        loginPage.enterPassword("WWE619");
        loginPage.clickLoginButton();
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.startsWith("https://accounts.us1.advisor.ws/dashboard/account_management/"), "Authorization is not successful");
        // log out
        driver.findElement(By.xpath("//i")).click();
        driver.findElement(By.xpath("//li[4]/a")).click();
    }
}
