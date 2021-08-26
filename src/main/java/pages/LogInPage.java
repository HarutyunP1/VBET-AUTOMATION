package pages;

import enums.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtils;


/**
 * @author amalyahayrapetova
 */

public class LogInPage extends BasePage {


    private final By USERNAME_FIELD = By.cssSelector("input[name='username']");
    private final By EMAIL_FIELD = By.cssSelector("input[name='email']");
    private final By PASSWORD_FIELD = By.cssSelector("input[name='password']");
    private final By PASSWORD_CONFIRMATION_FIELD = By.cssSelector("input[name='password_confirmation']");
    private final By CURRENCY_FIELD = By.cssSelector("select[name='currency_name']");
    private final By WARNING_ICON = By.cssSelector("div[class='warning-block']");
    private final By NEXT_BUTTON = By.cssSelector("button[type='submit']");
    private final By SIGN_IN = By.cssSelector("span[data-step='sign-in']");
    private final By ALREADY_HAVE_AN_ACCOUNT_TEXT = By.linkText("Already have an account?");
    private final By LAST_NAME_FIELD = By.cssSelector("input[name='last_name']");
    private final By GENDER_CHECK_BOX = By.cssSelector("div[class='checkbox-group gender-group']");
    private final By GENDER_CHOOSER = By.cssSelector("input[class name = 'gender']"); //fixme check, will get by attribute value
    private final By BIRTH_DATE_FIELD = By.cssSelector("input[name='birth_date']");
    private final By DATE_PICKER_PREV = By.cssSelector("a[data-handler='prev']");
    private final By DATE_PICKER_NEXT = By.cssSelector("a[data-handler='next']");
    private final By DATE_PICKER_MONTH_SELECTOR = By.cssSelector("select[class='ui-datepicker-month']");
    private final By DATE_PICKER_YEAR_SELECTOR = By.cssSelector("select[class='ui-datepicker-year']");
    private final By SELECT_DAY = By.cssSelector("td[data-handler='selectDay']");
    private final By COUNTRY_FIELD = By.cssSelector("select[name='country_code']");
    private final By CITY_FIELD = By.cssSelector("input[name='city']");
    private final By ADDRESS_FIELD = By.cssSelector("input[name='address']");
    private final By ZIP_CODE_FIELD = By.cssSelector("input[name='zip_code']");
    private final By PHONE_FIELD = By.cssSelector("input[name='phone']");
    private final By INTERNAL_MESSAGE_NOTIFIER_BOX = By.cssSelector("input[name='subscribe_to_internal_message']");
    private final By EMAIL_NOTIFIER_BOX = By.cssSelector("input[name='subscribe_to_email']");
    private final By SMS_NOTIFIER_BOX = By.cssSelector("input[name='subscribe_to_sms']");
    private final By PHONE_CALL_NOTIFIER_BOX = By.cssSelector("input[name='subscribe_to_phone_call']");
    private final By TERMS_AND_CONDITIONS_CHECK_BOX = By.cssSelector("label[class='checkbox terms-link']");
    private final By BACK_BUTTON = By.cssSelector("button[class='sb-account-btn btn-primary auth-prev-step']");
    private final By LOG_IN_REGISTER_CLOSE_BUTTON = By.cssSelector("span[class='sb-login-form-close icon-icon-clear']");
    private final By LOG_IN_BUTTON = By.cssSelector("button[class='sb-account-btn btn-primary  ']");
    private final By FORGET_PASSWORD = By.cssSelector("span[data-step='forgot-password']");
    private final By PASSWORD_VISIBILITY_ICON_WHEN_VISIBLE = By.cssSelector("span[class='password-visibility icon icon-preview-sb']");
    private final By PASSWORD_VISIBILITY_ICON_WHEN_HIDE = By.cssSelector("span[class='password-visibility icon icon-hide-sb']");
    private final By POPUP_CLOSE_ICON = By.cssSelector("polygon");
    private final By POPUP_FRAME = By.cssSelector("iframe[class='intercom-tour-frame intercom-5x43y3 e1s9bqu40']");
    private final By JOIN_US_LINK = By.cssSelector("span[class='as-link step-change']");
    private final By LOG_IN_POPUP_CLOSE_ICON = By.cssSelector("span[class='sb-login-form-close icon-icon-clear']");
    private final By LOG_IN_POPUP = By.cssSelector("div[class='sb-login-form-container sign-in ']");
    private final By PROFILE_LOGO = By.cssSelector("div[class='profile-overlay']");
    private final By PROFILE_ICON = By.cssSelector("div[class='profile-overlay']");
    private final By USER_BALANCE = By.cssSelector("span[class='userBalance']");
    private final By USER_BALANCE_LOAD = By.cssSelector("span[class='skeleton-animation skeleton-line large']");
    private final By LOGIN_FRAME = By.name("_hjRemoteVarsFrame");
    private final By CONGRET_FRAME = By.cssSelector("iframe[class='intercom-1fonhp6 e1u5aocb0']");
    private final By CONGRET_CLOSE_ICON = By.cssSelector("span[class='intercom-post-close intercom-199syus e1uu5mk82']");

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void openLogInPageViaUrl() {
        openUrl(Url.SIGN_IN_URL.getUrl());

    }

    public void fillInEmailField(String email) {
        typeText(USERNAME_FIELD, email);
    }

    public void fillInPasswordField(String password) {
        typeText(PASSWORD_FIELD, password);
    }

    public void clickOnLoginButton() {
        clickOnElement(LOG_IN_BUTTON);
    }

    public boolean isOnBoardingPopUpDisplayed() {
        return isElementDisplayed(POPUP_FRAME);
    }

    public void closePopUp(String url) {
        switch (url){
            case "https://www.vbet.com/#?sign-in":
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

    public String getUrl() {
        return getCurrentUrl();
    }

    public void fillEmailPassFields(String email, String password) {
        if (!email.isBlank()) {
            fillInEmailField(email);
        }
        if (!password.isBlank()) {
            fillInPasswordField(password);
        }
    }

    public void reloadLogInPage() {
        refreshPage();
        waitUntilPageIsFinish();
    }

    public void clickOnForgotPasswordLink() {
        clickOnElement(FORGET_PASSWORD);
    }

    public void clickOnJoinUsButton() {
        waitUtils.waitUntilElementAppear(JOIN_US_LINK);
        clickOnElement(JOIN_US_LINK);
    }

    public void waitUntilProfileLogoVisible(){
        waitUtils.waitUntilElementAppear(PROFILE_ICON);
    }

    public void waitUntilUserBalanceVisible(){
        waitUtils.waitUntilElementAppear(USER_BALANCE);
        // a temporary solution has been givens
        WaitUtils.threadSleep(1000);
    }

    public boolean checkWarningIconsCount(int count) {
        return getElementsCount(WARNING_ICON) == count;
    }

    public String getPassFieldAttribute() {
        return getAttribute(PASSWORD_FIELD, "type");
    }

    public void clickOnPasswordVisibilityIconWhenVisible() {
        clickOnElement(PASSWORD_VISIBILITY_ICON_WHEN_VISIBLE);
    }

    public void clickOnPasswordVisibilityIconWhenHide() {
        clickOnElement(PASSWORD_VISIBILITY_ICON_WHEN_HIDE);
    }

    public void clickOnCloseIcon() {
        clickOnElement(LOG_IN_POPUP_CLOSE_ICON);
    }

    public String getEmailFieldText() {
        return getText(USERNAME_FIELD);
    }

    public String getPasswordFieldText() {
        return getText(PASSWORD_FIELD);
    }

    public boolean isLogInPopUpDisplayed() {
        return isElementDisplayed(LOG_IN_POPUP);
    }

    public void waitUntilProfileLogoDisplayed(){
        waitUtils.waitUntilElementAppear(PROFILE_LOGO);
    }

    public void waitUntilPageIsFinish(){
        waitUtils.waitUntilPageIsLoad();
    }

    public void waitUntilLogInButtonDisappear(){
        waitUtils.waitUntilElementDisappear(LOG_IN_BUTTON);
    }

    public void waitUntilBalanceLoad(){
        try {
            waitUtils.waitUntilElementDisappear(USER_BALANCE_LOAD);
        }catch (Exception e){
            //Element not found
        }
    }

    public void closeCongitPopUp(){
        switchFrames(CONGRET_FRAME);
        clickOnElement(CONGRET_CLOSE_ICON);
    }

}
