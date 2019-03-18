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

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) throws Exception {
        switch (browser.toLowerCase()) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "lib/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "lib/MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                throw new Exception("Browser is not correct");
        }

        loginPage = new AWForceLoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://accounts.us1.advisor.ws/user/login");
    }

//    @Test(testName = "Check the possibility to log in with all the fields empty")
//    public void test1() {
//        loginPage.clickLoginButton();
//    }
//
//    @Test(testName = "Check the possibility to log in with the invalid password")
//    public void test2() {
//        loginPage.clickLoginButton();
//    }
//
//    @Test(testName = "Check the possibility to log in with the invalid username")
//    public void test3() {
//        loginPage.clickLoginButton();
//    }

    @Test(testName = "Check the possibility to reset the password")
    public void test4() {
        loginPage.clickResetPasswordButton();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://accounts.us1.advisor.ws/user/password","Reset password page is not opened");
    }

    @Test(testName = "Check the possibility to reset the password")
    public void test5() {
        loginPage.clickResetPasswordButton();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://accounts.us1.advisor.ws/user/password","Reset password page is not opened");
        resetPasswordPage.clickSubmitButton();
    }



    @AfterMethod
    public static void tearDown() {
        driver.quit();
    }
}
