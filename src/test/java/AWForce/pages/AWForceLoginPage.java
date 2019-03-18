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

    @FindBy(id = "edit-name")
    private WebElement usernameField;

    @FindBy(id = "edit-pass")
    private WebElement passwordField;

    @FindBy(id = "edit-forgot")
    private WebElement resetPasswordButton;

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickResetPasswordButton() {
        resetPasswordButton.click();
    }

    public void enterUsernameOrEmail(String text) {
        usernameField.sendKeys(text);
    }

    public void enterPassword (String password) {
        passwordField.sendKeys(password);
    }
}
