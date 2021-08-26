package pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class ChangePasswordPage extends BasePage {

    private final By CURRENT_PASSWORD_FIELD = By.name("password");
    private final By NEW_PASSWORD_FIELD = By.name("new_password");
    private final By CONFIRM_NEW_PASSWORD_FIELD = By.name("new_password_confirmation");
    private final By SAVE_PASSWORD_BUTTON = By.cssSelector("button[class='btn buttons1558357729029 ']");

    public ChangePasswordPage(WebDriver driver){
        super(driver);
    }

    public void fillInCurrentPassField(String currentPass){
        typeText(CURRENT_PASSWORD_FIELD,currentPass);
    }

    public void fillInNewPassField(String newPass){
        typeText(NEW_PASSWORD_FIELD,newPass);
    }

    public void fillInConfNewPass(String confNewPass){
        typeText(CONFIRM_NEW_PASSWORD_FIELD,confNewPass);
    }

    public void clickOnSavePassword(){
        clickOnElement(SAVE_PASSWORD_BUTTON);
    }
}
