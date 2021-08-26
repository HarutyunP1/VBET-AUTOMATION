package pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utilities.WaitUtils;

public class EditProfilePage extends BasePage {

    private final By FIRST_NAME_FIELD = By.name("first_name");
    private final By LAST_NAME_FIELD = By.name("last_name");
    private final By EMAIL_FIELD = By.name("email");
    private final By BIRTH_DATE = By.cssSelector("input[class='hasDatepicker']");
    private final By GENDER_RADIO_BUTTON_INPUT = By.cssSelector("label[class='checkbox'] input[value = 'M']");
    private final By GENDER_RADIO_BUTTON = By.cssSelector("label[class='checkbox']");
    private final By MOBILE_NUMBER_FIELD = By.name("phone");
    private final By COUNTRY_DROP_DOWN = By.name("countryCode");
    private final By CITY_FIELD = By.name("city");
    private final By ADDRESS_FIELD = By.name("address");
    private final By PASSPORT_NUMBER_FIELD = By.name("doc_number");
    private final By BIRTH_DATE_FIELD = By.cssSelector("input[class='hasDatepicker']");
    private final By YEAR_DROP_DOWN = By.cssSelector("select[class='ui-datepicker-year']");
    private final By MONTH_DROP_DOWN = By.cssSelector("select[class='ui-datepicker-month']");
    private final By DAY_VALUE = By.cssSelector("td a");
    private final By SAVE_PROFILE_BUTTON = By.cssSelector("button[class='btn buttons1558357729029']");
    private final By SAVE_PROFILE_BUTTON_ON_PASSWORD_POPUP = By.cssSelector("button[class='btn buttons1558357729029 ']");
    private final By PASSWORD_FIELD = By.name("password");
    private final By USERNAME_TEXT = By.cssSelector("div[class='profile-name'] span");
    private final By USER_BALANCE = By.cssSelector("span[class='userBalance']");

    public EditProfilePage(WebDriver driver){
        super(driver);
    }

    public String getFirstNameValue(){
        return getAttribute(FIRST_NAME_FIELD,"value");
    }

    public String getLastNameValue(){
        return getAttribute(LAST_NAME_FIELD,"value");
    }

    public String getEmailValue(){
        return getAttribute(EMAIL_FIELD,"value");
    }

    public String getPassportNumberValue(){
        return getAttribute(PASSPORT_NUMBER_FIELD,"value");
    }

    public String getBirthDateValue(){
        return getAttribute(BIRTH_DATE,"value");
    }

    public boolean isGenderRadioButtonSelected(){
        return isRadioButtonChecked(GENDER_RADIO_BUTTON_INPUT);
    }

    public String getMobileNumberValue(){
        return getAttribute(MOBILE_NUMBER_FIELD,"value");
    }

    public String getCountryValue(){
        return getAttribute(COUNTRY_DROP_DOWN,"value");
    }

    public String getCiyValue(){
        return getAttribute(CITY_FIELD,"value");
    }

    public String getAddressValue(){
        return getAttribute(ADDRESS_FIELD,"value");
    }

    public void fillInFirstNameField(String firstName){
        typeText(FIRST_NAME_FIELD,firstName);
    }

    public void fillInLastName(String lastName){
        typeText(LAST_NAME_FIELD,lastName);
    }

    public void fillInPassportNumber(String passportNumber){
        typeText(PASSPORT_NUMBER_FIELD,passportNumber);
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

    public void chooseGenderRadioButton(){
        clickOnElement(GENDER_RADIO_BUTTON,0);
    }

    public void fillInMobileNumberField(String mobileNumber){
        typeText(MOBILE_NUMBER_FIELD,mobileNumber);
    }

    public void chooseCountryValue(String country){
        selectByValue(COUNTRY_DROP_DOWN,country);
    }

    public void fillInCityField(String city){
        typeText(CITY_FIELD,city);
    }

    public void fillInAddressField(String address){
        typeText(ADDRESS_FIELD,address);
    }

    public void clickOnSaveProfileButton(){
        clickOnElement(SAVE_PROFILE_BUTTON);
    }

    public void clickOnSaveProfileButtonOnCurrentPassword(){
        clickOnElement(SAVE_PROFILE_BUTTON_ON_PASSWORD_POPUP);
    }

    public boolean isFirstNameValueValid(String firstName){
        return getFirstNameValue().equals(firstName);
    }

    public boolean isLastNameValueValid(String lastName){
        return getLastNameValue().equals(lastName);
    }

    public boolean isPassportNumberValueValid(String passportNumber){
        return getPassportNumberValue().equals(passportNumber);
    }

    public boolean isBirthDateValueValid(String birthDate){
        return getBirthDateValue().equals(birthDate);
    }

    public boolean isMobileNumberValueValid(String mobileNumber){
        WaitUtils.threadSleep(2000);
        return getMobileNumberValue().equals(mobileNumber);
    }

    public boolean isCountryValueValid(String country){
        return getCountryValue().equals(country);
    }

    public boolean isEmailValueValid(String email){
        return getEmailValue().equals(email);
    }

    public boolean isUserNameValueValid(String username){
        WaitUtils.threadSleep(3000);
        return getText(USERNAME_TEXT).equals(username);
    }

    public boolean isCityValueValid(String city){
        return getCiyValue().equals(city);
    }

    public boolean isAddressValueValid(String address){
        return getAddressValue().equals(address);
    }

    public boolean isFirstNameDisabled(){
        WaitUtils.threadSleep(3000);
        return Boolean.valueOf(getAttribute(FIRST_NAME_FIELD,"disabled"));
    }

    public boolean isLastNameDisabled(){
        return Boolean.valueOf(getAttribute(LAST_NAME_FIELD,"disabled"));
    }

    public boolean isEmailDisabled(){
        return Boolean.valueOf(getAttribute(EMAIL_FIELD,"disabled"));
    }

    public boolean isPassportNumberDisabled(){
        return Boolean.valueOf(getAttribute(PASSPORT_NUMBER_FIELD,"disabled"));
    }

    public boolean isBirthDateDisabled(){
        return Boolean.valueOf(getAttribute(BIRTH_DATE_FIELD,"disabled"));
    }


    public boolean isGenderDisabled(){
        return Boolean.valueOf(getAttribute(GENDER_RADIO_BUTTON_INPUT,"disabled"));
    }

    public boolean isAddressDisabled(){
        return Boolean.valueOf(getAttribute(ADDRESS_FIELD,"disabled"));
    }

    public void fillInPasswordField(String password){
        typeText(PASSWORD_FIELD,password);
    }

    public void waitUntilSaveProfileButtonDisappear(){
        waitUtils.waitUntilElementDisappear(SAVE_PROFILE_BUTTON_ON_PASSWORD_POPUP);
    }

    public void waitUntilUserBalanceAppear(){
        waitUtils.waitUntilElementAppear(USER_BALANCE);
    }

    public void clearMobileNumberField(){
        clearFields(MOBILE_NUMBER_FIELD);
    }

    public void clearCityField(){
        clearFields(CITY_FIELD);
    }

    private void chooseBirthDay(String day){
        for (int i = 0;i < getElements(DAY_VALUE).size();i++){
            if(getElements(DAY_VALUE).get(i).getText().equals(day)){
                getElements(DAY_VALUE).get(i).click();
                break;
            }
        }
    }
}
