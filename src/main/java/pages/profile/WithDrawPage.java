package pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utilities.WaitUtils;

public class WithDrawPage extends BasePage {

    private final By CARDS = By.cssSelector("div[class='card-image']");
    private final By SKRILL = By.cssSelector("img[src='https://static.betconstruct.me/fs/userFiles/vbetcom-updated/media/thumb/logo-8.png']");
    private final By QIWI = By.cssSelector("img[src='https://static.betconstruct.me/assets/addon/payment-icons/14.png'");
    private final By NETELLER = By.cssSelector("img[src='https://static.betconstruct.me/fs/userFiles/vbetcom-updated/media/thumb/logo-5-15598058104114.png'");
    private final By JETON = By.cssSelector("img[src='https://static.betconstruct.me/fs/userFiles/vbetcom-updated/media/thumb/download-2.png'");
    private final By ECO_PAYZ = By.cssSelector("img[src='https://static.betconstruct.me/fs/userFiles/vbetcom-updated/media/thumb/logo-4-15598190022243.png'");
    private final By ASTRO_PAY = By.cssSelector("img[src='https://static.betconstruct.me/assets/addon/payment-icons/5.png'");
    private final By ASTRO_PAY_DIRECT = By.cssSelector("img[src='https://static.betconstruct.me/assets/addon/payment-icons/58.png'");
    private final By ASTRO_PAY_MOBILE = By.cssSelector("img[src='https://static.betconstruct.me/fs/userFiles/vbetcom-updated/media/thumb/artboard-2-copy-10.png'");
    private final By MUCH_BETTER = By.cssSelector("img[src='https://static.betconstruct.me/fs/userFiles/vbetcom-updated/media/thumb/logo-2.png'");
    private final By WIRE_CARD = By.cssSelector("img[src='https://static.betconstruct.me/fs/userFiles/vbetcom-updated/media/thumb/visa-master-wire.png'");
    private final By BIT_COIN = By.cssSelector("img[src='https://static.betconstruct.me/fs/userFiles/vbetcom-updated/media/thumb/bclogotype-1.png'");
    private final By PAY_SAFE_CARD = By.cssSelector("img[src='https://static.betconstruct.me/assets/addon/payment-icons/89.png'");
    private final By VISA = By.cssSelector("img[src='https://static.betconstruct.me/fs/userFiles/vbetcom-updated/media/thumb/artboard-2-copy.png'");
    private final By EMAIL_FIELD = By.name("email");
    private final By AMOUNT_FIELD = By.name("amount");
    private final By SECURITY_ID = By.name("secure_id");
    private final By CARD_NUMBERS = By.cssSelector("div[class='input-wrapper ']");
    private final By SUBMIT_BUTTON = By.cssSelector("div[class='card-button']");
    private final By DEPOSIT_METHODS = By.cssSelector("div[class='special'] span");
    private final By PHONE_NUMBER = By.name("phone");
    private final By CUSTOMER_NAME = By.name("CustomerNumber");
    private final By WALLET_ID = By.name("account");
    private final By SURNAME = By.name("x_name");
    private final By DOCUMENT_NUMBER = By.name("x_document");
    private final By CARD_NUMBER = By.name("cardNumber");
    private final By CARD_EXPIRE_DATE = By.name("expiryDate");
    private final By CARD_REGISTERED_COUNTRY = By.name("cardHolderNationality");
    private final By CARD_HOLDER = By.name("cardName");
    private final By CREDIT_CARD_NUMBER = By.name("CreditCardNumber");
    private final By EXPIRATION_YEAR = By.name("ExpirationYear");
    private final By EXPIRATION_MONTH = By.name("ExpirationMonth");
    private final By CREDIT_CARD_HOLDER = By.name("CardHolderName");
    private final By BIT_COIN_ADDRESS = By.name("address");
    private final By PHONE_NUMBER_ASTRO = By.name("mobile_number");
    private final By CARD_HOLDER_NAME = By.name("CardHolderName");
    private final By CARD_BLOCK = By.cssSelector("div[class='sb-preloader']");
    private final By PROFILE_DATA_MISSING_MESSAGE = By.cssSelector("div[class='profile-not-filled-header-msg'] span");
    private final By FIRST_NAME_INPUT = By.name("first_name");

    public WithDrawPage(WebDriver driver) {
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

    public boolean isAstroPlayDirectDisplayed(){
        return isElementDisplayed(ASTRO_PAY_DIRECT);
    }

    public boolean isVisaDisplayed(){
        return isElementDisplayed(VISA);
    }

    public boolean isAstroPlayMobileDisplayed(){
        return isElementDisplayed(ASTRO_PAY_MOBILE);
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

    public void clcikOnAstroPayDirect(){
        clickOnElement(CARDS,3);
    }

    public void clickOnNeteller(){
        clickOnElement(CARDS,2);
    }

    public void clickOnJeton(){
        clickOnElement(CARDS,4);
    }

    public void clickOnEcoPayz(){
        clickOnElement(CARDS,5);
    }

    public void clickOnAstroPay(){
        clickOnElement(CARDS,6);
    }

    public void clickOnMuchBetter(){
        clickOnElement(CARDS,7);
    }

    public void clickOnVisa(){
        clickOnElement(CARDS,8);
    }

    public void clickOnAstroPayMobile(){
        clickOnElement(CARDS,9);
    }
    public void clickOnWireCard(){
        clickOnElement(CARDS,10);
    }

    public void clickOnBitCoin(){
        clickOnElement(CARDS,11);
    }

    public void clickOnPaySafeCard(){
        clickOnElement(CARDS,12);
    }

    public boolean isEmailFieldDisplayed(int index){
        return isElementsDisplayed(EMAIL_FIELD,index);
    }

    public boolean isAmountFieldDisplayed(int index){
        return isElementsDisplayed(AMOUNT_FIELD,index);
    }

    public boolean isPhoneNumberFieldDisplayed(){
        return isElementDisplayed(PHONE_NUMBER);
    }

    public boolean isPCustomNumberFieldDisplayed(){
        return isElementDisplayed(CUSTOMER_NAME);
    }

    public boolean isWalletIdDisplayed(){
        return isElementDisplayed(WALLET_ID);
    }

    public boolean isSurnameDisplayed(int index){
        return isElementsDisplayed(SURNAME,index);
    }

    public boolean isDocumentNumberDisplayed(int index){
        return isElementsDisplayed(DOCUMENT_NUMBER,index);
    }

    public boolean isCardNumberDisplayed(){
        return  isElementDisplayed(CARD_NUMBER);
    }

    public boolean isExpireDateDisplayed(){
        return  isElementDisplayed(CARD_EXPIRE_DATE);
    }

    public boolean isCountryCodeDisplayed(){
        return  isElementDisplayed(CARD_REGISTERED_COUNTRY);
    }

    public boolean isCardHolderDisplayed(){
        return isElementDisplayed(CARD_HOLDER);
    }

    public boolean isPhoneNumberAstroDisplayed(){
        return isElementDisplayed(PHONE_NUMBER_ASTRO);
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
        return isElementDisplayed(EXPIRATION_MONTH);
    }

    public boolean isExpirationYearFieldDisplayed(){
        return isElementDisplayed(EXPIRATION_YEAR);
    }

    public boolean isCardHolderNameDisplayed(){
        return isElementDisplayed(CARD_HOLDER_NAME);
    }

    public boolean isCreditCardNumberDisplayed(){
        return isElementDisplayed(CREDIT_CARD_NUMBER);
    }

    public boolean isSubmitButtonDisplayed(int index){
        return isElementsDisplayed(SUBMIT_BUTTON,index);
    }

    public void waitUntilDepositMethodsDisplayed(){
        waitUtils.waitUntilElementAppear(DEPOSIT_METHODS);
    }

    public void waitUntilLoadFinish(){
        try {
            waitUtils.waitUntilElementDisappear(CARD_BLOCK);
        }catch (Exception e){

        }
    }

    public void clickOnProfileText(){
        clickOnElement(PROFILE_DATA_MISSING_MESSAGE);
    }

    public boolean isProfileDataMissingMessageDisplayed(){
        return isElementDisplayed(PROFILE_DATA_MISSING_MESSAGE);
    }

    public boolean isFirstNameInputDisplayed(){
        return isElementDisplayed(FIRST_NAME_INPUT);
    }
}
