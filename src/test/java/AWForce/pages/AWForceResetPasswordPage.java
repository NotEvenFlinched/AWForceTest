package AWForce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AWForceResetPasswordPage {
    public AWForceResetPasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private WebDriver driver;

    @FindBy(id = "edit-submit")
    private WebElement submitButton;

    @FindBy(id = "edit-name")
    private WebElement usernameField;

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void enterUsernameOrEmail(String text) {
        usernameField.sendKeys(text);
    }
}
