package AWForce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AWForceLoginPage {
    public AWForceLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private WebDriver driver;

    @FindBy(id = "edit-submit")
    private WebElement loginButton;

    public void clickLoginButton() {
        loginButton.click();
    }
}
