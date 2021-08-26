package pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class MyProfilePage extends BasePage {

    private final By NOTIFICATIONS_AREA = By.cssSelector("div[class='tab-item section-tab ']");
    private final By CON_CLOSE_ICON = By.cssSelector("span[class='intercom-post-close intercom-199syus e1uu5mk82']");
    private final By MY_PROJECT_CLOSE_ICON = By.cssSelector("span[class='close icon-icon-clear']");
    private final By CON_FRAME = By.cssSelector("iframe[class='intercom-1fonhp6 e1u5aocb0']");
    private final By MY_PROFILE_MENU_BARS = By.cssSelector("div[class='accordion-title']");
    private final By MY_PROFILE_PAGES = By.cssSelector("div[class='accordion-content-inner'] div");

    public MyProfilePage(WebDriver driver){
        super(driver);
    }

    public void clickOnNotificationsArea(){
        clickOnElement(NOTIFICATIONS_AREA,5);
    }

    public void closeConPopUp(){
        switchFrames(CON_FRAME);
        clickOnElement(CON_CLOSE_ICON);
    }

    public void closeMyProjectPopUp(){
        clickOnElement(MY_PROJECT_CLOSE_ICON,0);
    }

    public void clickOnMyWallet(){
        clickOnElement(MY_PROFILE_MENU_BARS,0);
    }

    public void clickOnMyProfile(){
        clickOnElement(MY_PROFILE_MENU_BARS,1);
    }

    public void clickOnMyBets(){
        clickOnElement(MY_PROFILE_MENU_BARS,2);
    }

    public void clickOnBonuses(){
        clickOnElement(MY_PROFILE_MENU_BARS,3);
    }

    public void clickOnMessages(){
        clickOnElement(MY_PROFILE_MENU_BARS,4);
    }

    public void clickOnDeposit(){
        clickOnElement(MY_PROFILE_PAGES,0);
    }

    public void clickOnWithDraw(){
        clickOnElement(MY_PROFILE_PAGES,1);
    }

    public void clickOnBalanceHistory(){
        clickOnElement(MY_PROFILE_PAGES,2);
    }

    public void clickOnEditProfile(){
        clickOnElement(MY_PROFILE_PAGES,3);
    }

    public void clickOnChangePassword(){
        clickOnElement(MY_PROFILE_PAGES,4);
    }

    public void clickOnDocuments(){
        clickOnElement(MY_PROFILE_PAGES,5);
    }

    public void clickOnSelfExecution(){
        clickOnElement(MY_PROFILE_PAGES,6);
    }

    public void clickOnTimeOut(){
        clickOnElement(MY_PROFILE_PAGES,7);
    }

    public void clickOnRealityCheck(){
        clickOnElement(MY_PROFILE_PAGES,8);
    }

    public void clickOnLimits(){
        clickOnElement(MY_PROFILE_PAGES,9);
    }

    public void clickOnNotifications(){
        clickOnElement(MY_PROFILE_PAGES,10);
    }

    public void clickOnSportsBook(){
        clickOnElement(MY_PROFILE_PAGES,11);
    }

    public void clickOnCasino(){
        clickOnElement(MY_PROFILE_PAGES,12);
    }

    public void clickOnInbox(){
        clickOnElement(MY_PROFILE_PAGES,13);
    }

    public void clickOnSentMessage(){
        clickOnElement(MY_PROFILE_PAGES,14);
    }

    public void clickOnNewMessage(){
        clickOnElement(MY_PROFILE_PAGES,15);
    }
}
