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

    @FindBy(id = "edit-openid-connect-client-google-login")
    private WebElement logInWithGoogleButton;

    @FindBy(xpath = "//strong")
    private WebElement wrongUsernameOrEmailMessageElement;

    @FindBy(xpath = "//li")
    private WebElement passwordResetMessageElement;

    @FindBy(xpath = "//button[contains(@class,'hideShowPassword-toggle')]")
    private WebElement showEnteredPasswordButton;

    @FindBy(id = "edit-create")
    private WebElement createAccountButton;

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickResetPasswordButton() {
        resetPasswordButton.click();
    }

    public void clickLogInWithGoogleButton() {
        logInWithGoogleButton.click();
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    public boolean checkIsPasswordVisible() {
        return passwordField.getAttribute("class").contains("hideShowPassword-shown");
    }

    public void showEnteredPassword() {
        showEnteredPasswordButton.click();
    }

    public void enterUsernameOrEmail(String text) {
        usernameField.sendKeys(text);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public String getUsernameFieldValidationMessage() {
        return usernameField.getAttribute("validationMessage");
    }

    public String getWrongUsernameMessageElementText() {
        return wrongUsernameOrEmailMessageElement.getAttribute("innerText");
    }

    public String getPasswordResetMessage() {
        return passwordResetMessageElement.getAttribute("innerText");
    }
}
