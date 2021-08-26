package pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utilities.WaitUtils;

public class DepositPage extends BasePage {

    private final By CARDS = By.cssSelector("div[class='card-image']");
    private final By SKRILL = By.cssSelector("img[src='https://static.betconstruct.me/fs/userFiles/vbetcom-updated/media/thumb/logo-8.png']");
    private final By QIWI = By.cssSelector("img[src='https://static.betconstruct.me/assets/addon/payment-icons/14.png'");
    private final By NETELLER = By.cssSelector("img[src='https://static.betconstruct.me/fs/userFiles/vbetcom-updated/media/thumb/logo-5-15598058104114.png'");
    private final By JETON = By.cssSelector("img[src='https://static.betconstruct.me/fs/userFiles/vbetcom-updated/media/thumb/download-2.png'");
    private final By ECO_PAYZ = By.cssSelector("img[src='https://static.betconstruct.me/fs/userFiles/vbetcom-updated/media/thumb/logo-4-15598190022243.png'");
    private final By ASTRO_PAY = By.cssSelector("img[src='https://static.betconstruct.me/assets/addon/payment-icons/5.png'");
    private final By MUCH_BETTER = By.cssSelector("img[src='https://static.betconstruct.me/fs/userFiles/vbetcom-updated/media/thumb/logo-2.png'");
    private final By WIRE_CARD = By.cssSelector("img[src='https://static.betconstruct.me/fs/userFiles/vbetcom-updated/media/thumb/visa-master-wire.png'");
    private final By BIT_COIN = By.cssSelector("img[src='https://static.betconstruct.me/fs/userFiles/vbetcom-updated/media/thumb/bclogotype-1.png'");
    private final By PAY_SAFE_CARD = By.cssSelector("img[src='https://static.betconstruct.me/assets/addon/payment-icons/89.png'");
    private final By EMAIL_FIELD = By.name("email");
    private final By AMOUNT_FIELD = By.name("amount");
    private final By SECURITY_ID = By.name("secure_id");
    private final By CARD_NUMBERS = By.cssSelector("div[class='input-wrapper ']");
    private final By SUBMIT_BUTTON = By.cssSelector("div[class='card-button']");
    private final By DEPOSIT_METHODS = By.cssSelector("div[class='special'] span");

    public DepositPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSkrillDisplayed(){
        return isElementDisplayed(SKRILL);
    }

    public boolean isQiwiDisplayed(){
        return isElementDisplayed(QIWI);
    }

    public boolean isNetellerDisplayed(){
        return isElementDisplayed(NETELLER);
    }


    public boolean isJetonDisplayed(){
        return isElementDisplayed(JETON);
    }

    public boolean isEcoPayzDisplayed(){
        return isElementDisplayed(ECO_PAYZ);
    }

    public boolean isAstroPayDisplayed(){
        return isElementDisplayed(ASTRO_PAY);
    }

    public boolean isMuchBetterDisplayed(){
        return isElementDisplayed(MUCH_BETTER);
    }

    public boolean isWireCardDisplayed(){
        return isElementDisplayed(WIRE_CARD);
    }

    public boolean isBitCoinDisplayed(){
        return isElementDisplayed(BIT_COIN);
    }

    public boolean isPaySafeCardDisplayed(){
        return isElementDisplayed(PAY_SAFE_CARD);
    }

    public void clickOnSkrill(){
        clickOnElement(CARDS,0);
    }

    public void clickOnQiwi(){
        clickOnElement(CARDS,1);
    }

    public void clickOnNeteller(){
        clickOnElement(CARDS,2);
    }

    public void clickOnJeton(){
        clickOnElement(CARDS,3);
    }

    public void clickOnEcoPayz(){
        clickOnElement(CARDS,4);
    }

    public void clickOnAstroPay(){
        clickOnElement(CARDS,5);
    }

    public void clickOnMuchBetter(){
        clickOnElement(CARDS,6);
    }

    public void clickOnWireCard(){
        clickOnElement(CARDS,7);
    }

    public void clickOnBitCoin(){
        clickOnElement(CARDS,8);
    }

    public void clickOnPaySafeCard(){
        clickOnElement(CARDS,9);
    }

    public boolean isEmailFieldDisplayed(int index){
        return isElementsDisplayed(EMAIL_FIELD,index);
    }

    public boolean isAmountFieldDisplayed(int index){
        return isElementsDisplayed(AMOUNT_FIELD,index);
    }

    public boolean isSecurityFieldDisplayed(){
        return isElementDisplayed(SECURITY_ID);
    }

    public boolean isCardNumberFieldDisplayed(){
        return isElementsDisplayed(CARD_NUMBERS,8);
    }

    public boolean isCardCodeFieldDisplayed(){
        return isElementsDisplayed(CARD_NUMBERS,9);
    }

    public boolean isExpirationMonthFieldDisplayed(){
        return isElementsDisplayed(CARD_NUMBERS,10);
    }

    public boolean isExpirationYearFieldDisplayed(){
        return isElementsDisplayed(CARD_NUMBERS,11);
    }

    public boolean isSubmitButtonDisplayed(int index){
        return isElementsDisplayed(SUBMIT_BUTTON,index);
    }

    public void waitUntilDepositMethodsDisplayed(){
        waitUtils.waitUntilElementAppear(DEPOSIT_METHODS);
    }
}
