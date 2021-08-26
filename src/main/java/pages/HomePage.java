package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private final By BANNERS = By.cssSelector("a[class='btn buttons1569486204818']");
    private final By REGISTER_NOW_BUTTON = By.cssSelector("a[class='btn signup-btn sbRegisterBtn buttons1569925557795']");
    private final By SIGN_IN_BUTTON = By.cssSelector("a[class='btn signin-btn sbLoginBtn buttons1569479603427']");
    private final By VBET_IMAGE = By.cssSelector("div[class='animated animated-24567 '] img[class='image lazy initial loaded']");
    private final By ALL_PROMOTIONS_TEXT = By.cssSelector("a[class='btn buttons1571989454901']");
    private final By SIGN_IN_BUTTON_UK = By.cssSelector("a[class='btn buttons1569479603427']");
    private final By SIGN_IN_BUTTON_TR = By.cssSelector("a[class='link signin-btn sbLoginBtn']");
    private final By POPUP_CLOSE_ICON = By.cssSelector("polygon");
    private final By POPUP_FRAME = By.cssSelector("iframe[class='intercom-tour-frame intercom-5x43y3 e1s9bqu40']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegisterNowButton(){
        clickOnElement(REGISTER_NOW_BUTTON);
    }

    public void waitUntilRegisterButtonAppear(){
        waitUtils.waitUntilElementAppear(REGISTER_NOW_BUTTON);
    }

    public void clickOnSignInButton(String homePageUrl){
        switch (homePageUrl){
            case "https://www.vbet.com/uk":
                clickOnElement(SIGN_IN_BUTTON_UK);
                break;
            case "https://www.vbet.com/tr":
                clickOnElement(SIGN_IN_BUTTON_TR);
                break;
            default:
                clickOnElement(SIGN_IN_BUTTON);
                break;
        }
    }

    public void clickOnVbetImage(){
        clickOnElement(VBET_IMAGE);
    }

    public void clickOnSports(){
        clickOnElement(BANNERS,0);
        waitUtils.waitUntilPageIsLoad();
    }

    public void clickOnCasino(){
        clickOnElement(BANNERS,1);
        waitUtils.waitUntilPageIsLoad();
    }

    public void clickOnLiveCasino(){
        clickOnElement(BANNERS,2);
        waitUtils.waitUntilPageIsLoad();
    }

    public void clickOnPoker(){
        clickOnElement(BANNERS,3);
        waitUtils.waitUntilPageIsLoad();
    }

    public boolean isCasinoPageOpen(String casinoUrl){
        return getCurrentUrl().equals(casinoUrl);
    }

    public boolean isLiveCasinoPageOpen(String liveCasino){
        return getCurrentUrl().equals(liveCasino);
    }

    public boolean isPokerPageOpen(String pokerUrl){
        return getCurrentUrl().equals(pokerUrl);
    }

    public boolean isAllPromoTextDisplayed(){
        return isElementDisplayed(ALL_PROMOTIONS_TEXT);
    }


    public void waitUntilSignInButtonAppear(String homePageUrl){
        switch (homePageUrl){
            case "https://www.vbet.com/tr":
                waitUtils.waitUntilElementAppear(SIGN_IN_BUTTON_TR);
                break;
            case "https://www.vbet.com/uk":
                waitUtils.waitUntilElementAppear(SIGN_IN_BUTTON_UK);
                break;
            default:
                waitUtils.waitUntilElementAppear(SIGN_IN_BUTTON);
                break;
        }
    }

    public void closePopUp(String url) {
        switch (url){
            case "https://www.vbet.com/uk":
                try {
                    switchFrames(POPUP_FRAME);
                    clickOnElement(POPUP_CLOSE_ICON);
                }catch (Exception e){
                    //Can't find element
                }
                break;
            default:
                break;
        }
    }
}

