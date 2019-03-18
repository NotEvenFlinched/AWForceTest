package AWForce.tests;

import AWForce.pages.AWForceLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class AWForceTest {
    private static WebDriver driver;
    private static AWForceLoginPage loginPage;

    @BeforeClass
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

    @Test
    @Parameters({"searchTerm", "bookToSearch"})
    public void searchTest(String searchTerm, String bookToSearch) {
        loginPage.clickLoginButton();
        WebElement element = driver.findElement(By.xpath("//div[contains(string(), 'Please fill out this field')]"));
        Assert.assertTrue(element.isDisplayed());
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
