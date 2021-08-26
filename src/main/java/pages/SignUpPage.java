package pages;

import enums.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtils;


public class SignUpPage extends BasePage{

    private final By WELCOME_OFFER_IMAGE = By.cssSelector("a[class='account-banner']");
    private final By USERNAME = By.name("username");
    private final By EMAIL = By.name("email");
    private final By PASSWORD = By.name("password");
    private final By CONFIRM_PASS = By.name("password_confirmation");
    private final By PRICE = By.name("currency_name");
    private final By OK_BUTTON = By.cssSelector("a[class='btn  buttons1558357729029']");
    private final By NEXT_BUTTON = By.cssSelector("button[class='sb-account-btn btn-primary']");
    private final By SIGN_IN_LINK = By.cssSelector("span[class='as-link step-change']");
    private final By FIRST_NAME = By.name("first_name");
    private final By LAST_NAME = By.name("last_name");
    private final By PROFILE_LOGO = By.cssSelector("div[class='  module ModuleSbAccount ']");
    private final By CHECKBOXES = By.cssSelector("label[class='checkbox'] span");
    private final By BIRTH_DATE_FIELD = By.name("birth_date");
    private final By MONTH_DROP_DOWN = By.cssSelector("select[class='ui-datepicker-month']");
    private final By YEAR_DROP_DOWN = By.cssSelector("select[class='ui-datepicker-year']");
    private final By DAY_VALUE = By.cssSelector("td a");
    private final By COUNTRY = By.name("country_code");
    private final By COUNTRY_CODE = By.cssSelector("input[class='phone-code']");
    private final By CITY = By.name("city");
    private final By ADDRESS = By.name("address");
    private final By ZIP_CODE = By.name("zip_code");
    private final By MOBILE_NUMBER = By.name("phone");
    private final By TERMS_AND_COND = By.cssSelector("label[class='checkbox terms-link'] span");
    private final By BACK_BUTTON = By.cssSelector("button[class='sb-account-btn btn-primary auth-prev-step']");
    private final By SUBMIT_BUTTON = By.cssSelector("button[class='sb-account-btn btn-primary submit-join-now ']");
    private final By WARNING_ICON = By.cssSelector("span[class='warning icon icon-sb-warning']");
    private final By INPUT_FIELDS = By.cssSelector("input[class='ember-text-field ember-view']");
    private final By INPUT_FIELDS_AFTER_ERROR = By.cssSelector("input[class='error ember-text-field ember-view']");
    private final By PASSWORD_VISIBILITY_ICON = By.cssSelector("span[class='password-visibility icon icon-preview-sb']");
    private final By BIRTH_DATE_CLEAR_ICON = By.cssSelector("span[class='clear icon-icon-clear']");
    private final By DUPLICATE_ERROR_MESSAGE = By.cssSelector("div[class='_c-notification__content_of6y9q']");
    private final By MAX_DAILY_DEPOSIT_FIELD = By.name("max_day_deposit");
    private final By MAX_WEEKLY_DEPOSIT_FIELD = By.name("max_week_deposit");
    private final By MAX_MONTHLY_DEPOSIT_FIELD = By.name("max_month_deposit");
    private final By RADIO_BUTTONS = By.cssSelector("label[class='checkbox']");
    private final By NEXT_BUTTON_NET = By.cssSelector("button[class='sb-account-btn btn-primary auth-next-step']");
    private final By EMAIL_NET = By.name("email");
    private final By PRICE_DROP_DOWN = By.name("currency_name");
    private final By REGISTRATION_SUCCESS_POPUP_BUTTON = By.cssSelector("a[class='btn  buttons1558357729029']");
    private final By PROFILE_CLOSE_ICON = By.cssSelector("span[class='close icon-icon-clear']");
    private final By PROMO_CODE_FIELD = By.name("promo_code");

    public SignUpPage(WebDriver driver){
        super(driver);
    }

    public void fillInMaxDailyDepositFieldNet(String dailyDeposit){
        typeText(MAX_DAILY_DEPOSIT_FIELD,dailyDeposit);
    }

    public void fillInMaxWeeklyDepositFieldNet(String weeklyDeposit){
        typeText(MAX_WEEKLY_DEPOSIT_FIELD,weeklyDeposit);
    }

    public void fillInMaxMonthlyDepositFieldNet(String monthlyDeposit){
        typeText(MAX_MONTHLY_DEPOSIT_FIELD,monthlyDeposit);
    }

    public void chooseInternalMessages(){
        clickOnElement(RADIO_BUTTONS,3);
    }

    public void choosePushNotification(){
        clickOnElement(RADIO_BUTTONS,5);;
    }

    public void chooseEmail(){
        clickOnElement(RADIO_BUTTONS,6);
    }

    public void chooseSms(){
        clickOnElement(RADIO_BUTTONS,9);;
    }

    public void choosePhoneCall(){
        clickOnElement(RADIO_BUTTONS,11);
    }

    public void clickOnRadioButtonsNet(boolean intMessage, boolean pushNot, boolean email, boolean sms, boolean phoneCall){
        if (intMessage)
            chooseInternalMessages();
        if (pushNot)
            choosePushNotification();
        if (email)
            chooseEmail();
        if (sms)
            chooseSms();
        if(phoneCall)
            choosePhoneCall();
    }


    public void clickOnNextButtonNet(){
        clickOnElement(NEXT_BUTTON_NET);
    }

    public boolean isEmailFieldDisplayedNet(){
        return isElementDisplayed(EMAIL_NET);
    }

    public boolean isPriceDropDownDisabledNet(){
        return Boolean.valueOf(getAttribute(PRICE_DROP_DOWN,"disabled"));
    }

    public void clickOnSuccessButtonNet(){
        clickOnElement(REGISTRATION_SUCCESS_POPUP_BUTTON);
    }

    public void clickOnProfileCloseIconNet(){
        clickOnElement(PROFILE_CLOSE_ICON);
    }

    public void fillInPromoCodeFieldNet(String promoCode){
        typeText(PROMO_CODE_FIELD,promoCode);
    }

    public String getSignUpUrl(){
        return getCurrentUrl();
    }

    public String registerUrl(){
        return Url.SIGN_UP_URL.getUrl();
    }

    public void fillInUsernameField(String username){
        typeText(USERNAME,username);
    }

    public void fillInEmailField(String email){
        typeText(EMAIL_NET,email);
    }

    public void fillInPasswordField(String password){
        typeText(PASSWORD,password);
    }

    public void fillInConfirmPassField(String confirmPass){
        typeText(CONFIRM_PASS,confirmPass);
    }

    public void choosePriceDropDownValue(String value){
        selectByValue(PRICE,value);
    }

    public void clickOnNextButton(){
        clickOnElement(NEXT_BUTTON);
    }

    public void fillInFirstNameField(String firstName){
        typeText(FIRST_NAME,firstName);
    }

    public void fillInLastNameField(String lastName){
        typeText(LAST_NAME,lastName);
    }

    public void chooseGender(int gender){
        chooseNotificationSendTo(gender);
    }

    public void chooseBirthDate(String year,String month,String day){
        clickOnElement(BIRTH_DATE_FIELD);
        if (!year.isBlank()){
            selectByValue(YEAR_DROP_DOWN,year);
        }
        if (!month.isBlank()) {
            selectByValue(MONTH_DROP_DOWN,month);
        }
        if (!day.isBlank()){
            chooseBirthDay(day);
        }
    }

    public void chooseInternalMessages(int internalMessage){
        chooseNotificationSendTo(internalMessage);
    }

    public void choosePushNotification(int pushNotification){
        chooseNotificationSendTo(pushNotification);
    }

    public void chooseEmail(int email){
        chooseNotificationSendTo(email);
    }

    public void chooseSms(int sms){
        chooseNotificationSendTo(sms);
    }

    public void choosePhoneCall(int phoneCall){
        chooseNotificationSendTo(phoneCall);
    }

    public void chooseCountryValue(String country){
        if (!country.isBlank())
            selectByValue(COUNTRY,country);
    }

    public void fillInCityField(String city){
        typeText(CITY,city);
    }

    public void fillInAddressField(String address){
        typeText(ADDRESS,address);
    }

    public void fillInZipCodeField(String zipCode){
        typeText(ZIP_CODE,zipCode);
    }

    public void fillInMobileNumberField(String mobileNumber){
        typeText(MOBILE_NUMBER,mobileNumber);
    }

    public void clickOnTermsAndPolicyCheckbox(){
        clickOnElement(TERMS_AND_COND);
    }

    public void clickOnSubmitButton(){
        clickOnElement(SUBMIT_BUTTON);
    }

    public void clickOnBackButton(){
        clickOnElement(BACK_BUTTON);
    }

    public void clickOnOkButton(){
            clickOnElement(OK_BUTTON);
    }

    public boolean isFirstNameDisplayed(){
        return isElementDisplayed(FIRST_NAME);
    }

    public boolean isUsernameDisplayed(){
        return isElementDisplayed(USERNAME);
    }

    public boolean checkWarningIconsCount(int count){
        return getElementsCount(WARNING_ICON) == count;
    }

    public void clearAllFields(){
        clearFields(INPUT_FIELDS);
    }

    public void clearAllFieldsAfterErrorMessage(){
        clearFields(INPUT_FIELDS_AFTER_ERROR);
    }

    public void clickOnPasswordVisibilityIcon(int index){
        clickOnElement(PASSWORD_VISIBILITY_ICON,index);
    }

    public void clickOnBirthDateClearIcon(){
        clickOnElement(BIRTH_DATE_CLEAR_ICON);
    }

    public boolean isCountryCodeEquals(String countryCode){
        return getAttribute(COUNTRY_CODE,"value").equals(countryCode);
    }

    public void clickOnWelcomeOfferImage(){
        clickOnElement(WELCOME_OFFER_IMAGE);
    }

    public void switchToWelcomeOfferTab(){
        switchDriverToNewTab(1);
    }

    public void switchToRegisterTab(){
        switchDriverToNewTab(0);
    }

    public void closeWelcomeOfferTab(){
        closeWindow();
    }

    public void clickOnSignInLink(){
        clickOnElement(SIGN_IN_LINK);
        WaitUtils.threadSleep(1000);
    }

    public boolean isProfileLogoDisplayed(){
        return isElementDisplayed(PROFILE_LOGO);
    }

    public void scrollToBackButton(){
        scrollToElement(BACK_BUTTON);
    }

    public void waitUntilWelcomeOfferLinkDisplay(){
        waitUtils.waitUntilElementAppear(WELCOME_OFFER_IMAGE);
        WaitUtils.threadSleep(1000);
    }

    public void waitUntilLogInLinkAppear(){
        waitUtils.waitUntilElementAppear(SIGN_IN_LINK);
    }

    private void chooseBirthDay(String day){
        for (int i = 0;i < getElements(DAY_VALUE).size();i++){
            if(getElements(DAY_VALUE).get(i).getText().equals(day)){
                getElements(DAY_VALUE).get(i).click();
                break;
            }
        }
    }

    private void chooseNotificationSendTo(int index){
        clickOnElement(CHECKBOXES,index);
    }

}
