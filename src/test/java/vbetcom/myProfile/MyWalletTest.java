package vbetcom.myProfile;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import pages.profile.BalanceHistoryPage;
import pages.profile.DepositPage;
import pages.profile.MyProfilePage;
import pages.profile.WithDrawPage;
import utilities.TestBase;

public class MyWalletTest extends TestBase {

    private String signInUrl;
    private String depositUrl;
    private String withDrawUrl;
    private String balanceHistoryUrl;
    private BalanceHistoryPage balanceHistoryPage;
    private DepositPage depositPage;
    private LogInPage logInPage;
    private WithDrawPage withDrawPage;
    private MyProfilePage myProfilePage;
    private String emailWithCompleteProfile = "automation7@yopmail.com";
    private String emailWithNotCompleteProfile = "automation3@yopmail.com";
    private String password = "Test1111";

    @BeforeClass
    @Parameters({"signInUrl","depositUrl","withDrawUrl","balanceHistoryUrl"})
    public void setUp(String signInUrl,String depositUrl,String withDrawUrl,String balanceHistoryUrl){
        this.signInUrl = signInUrl;
        this.depositUrl = depositUrl;
        this.withDrawUrl = withDrawUrl;
        this.balanceHistoryUrl = balanceHistoryUrl;
        depositPage = new DepositPage(driver);
        logInPage = new LogInPage(driver);
        withDrawPage = new WithDrawPage(driver);
        balanceHistoryPage = new BalanceHistoryPage(driver);
        myProfilePage = new MyProfilePage(driver);
    }

    @BeforeMethod
    public void logIn(){
        logInPage.openUrl(signInUrl);
        logInPage.fillEmailPassFields(emailWithCompleteProfile,password);
        logInPage.clickOnLoginButton();
        logInPage.waitUntilProfileLogoDisplayed();
        logInPage.waitUntilBalanceLoad();
        logInPage.openUrl(depositUrl);
    }

    @TmsLink("VBET-T45")
    @Test
    public void validationForImagesDepositPage(){
        depositPage.openUrl(depositUrl);
        myProfilePage.clickOnDeposit();
        withDrawPage.waitUntilLoadFinish();
        Assert.assertTrue(depositPage.isSkrillDisplayed() & depositPage.isQiwiDisplayed(),"Skill or Qiwi isn't displayed.");
        Assert.assertTrue(depositPage.isNetellerDisplayed() & depositPage.isJetonDisplayed(),"Jeton or Netteller isn't displayed.");
        Assert.assertTrue(depositPage.isEcoPayzDisplayed() & depositPage.isAstroPayDisplayed(),"Eco pays or Astro pay isn't displayed.");
        Assert.assertTrue(depositPage.isMuchBetterDisplayed() & depositPage.isWireCardDisplayed(),"Much better or Wire card isn't displayed.");
        Assert.assertTrue(depositPage.isBitCoinDisplayed() & depositPage.isPaySafeCardDisplayed(),"Bit coin or Pay Safe Card isn't displayed.");
    }

    @TmsLink("VBET-T46")
    @Test
    public void validationForFieldsViewDepositPage(){
        depositPage.openUrl(depositUrl);
        withDrawPage.waitUntilLoadFinish();
        depositPage.clickOnSkrill();
        Assert.assertTrue(depositPage.isEmailFieldDisplayed(0) & depositPage.isAmountFieldDisplayed(0),"Email or Amount field isn't displayed.");
        Assert.assertTrue(depositPage.isSubmitButtonDisplayed(0),"Submit button isn't displayed.");
        depositPage.clickOnQiwi();
        Assert.assertTrue(depositPage.isAmountFieldDisplayed(1),"Amount field isn't displayed.");
        Assert.assertTrue(depositPage.isSubmitButtonDisplayed(1),"Submit button isn't displayed.");
        depositPage.clickOnNeteller();
        Assert.assertTrue(depositPage.isEmailFieldDisplayed(1) & depositPage.isAmountFieldDisplayed(2),"Email or Amount field isn't displayed.");
        Assert.assertTrue(depositPage.isSubmitButtonDisplayed(2) & depositPage.isSecurityFieldDisplayed(),"Submit button or Security field isn't displayed.");
        depositPage.clickOnJeton();
        Assert.assertTrue(depositPage.isAmountFieldDisplayed(3),"Amount field isn't displayed.");
        Assert.assertTrue(depositPage.isSubmitButtonDisplayed(3),"Submit button isn't displayed.");
        depositPage.clickOnEcoPayz();
        Assert.assertTrue(depositPage.isAmountFieldDisplayed(4),"Amount field isn't displayed.");
        Assert.assertTrue(depositPage.isSubmitButtonDisplayed(4),"Submit button isn't displayed.");
        depositPage.clickOnAstroPay();
        Assert.assertTrue(depositPage.isCardNumberFieldDisplayed() & depositPage.isCardCodeFieldDisplayed(),"Card Number or Card Code field isn't displayed.");
        Assert.assertTrue(depositPage.isExpirationMonthFieldDisplayed() & depositPage.isExpirationYearFieldDisplayed(),"Expiration month or Expiration year field isn't displayed.");
        Assert.assertTrue(depositPage.isSubmitButtonDisplayed(5) & depositPage.isAmountFieldDisplayed(5),"Submit button or Amount field isn't displayed.");
        depositPage.clickOnMuchBetter();
        Assert.assertTrue(depositPage.isAmountFieldDisplayed(6),"Amount field isn't displayed.");
        Assert.assertTrue(depositPage.isSubmitButtonDisplayed(6),"Submit button isn't displayed.");
        depositPage.clickOnWireCard();
        Assert.assertTrue(depositPage.isAmountFieldDisplayed(7),"Amount field isn't displayed.");
        Assert.assertTrue(depositPage.isSubmitButtonDisplayed(7),"Submit button isn't displayed.");
        depositPage.clickOnBitCoin();
        Assert.assertTrue(depositPage.isAmountFieldDisplayed(8),"Amount field isn't displayed.");
        Assert.assertTrue(depositPage.isSubmitButtonDisplayed(8),"Submit button isn't displayed.");
        depositPage.clickOnPaySafeCard();
        Assert.assertTrue(depositPage.isAmountFieldDisplayed(9),"Amount field isn't displayed.");
        Assert.assertTrue(depositPage.isSubmitButtonDisplayed(9),"Submit button isn't displayed.");
    }

    @TmsLink("VBET-T49")
    @Test
    public void validationForImagesWithDrawPage(){
        depositPage.openUrl(depositUrl);
        myProfilePage.clickOnWithDraw();
        withDrawPage.waitUntilLoadFinish();
        Assert.assertTrue(withDrawPage.isSkrillDisplayed() & withDrawPage.isQiwiDisplayed(),"Skill or Qiwi isn't displayed.");
        Assert.assertTrue(withDrawPage.isNetellerDisplayed() & withDrawPage.isJetonDisplayed(),"Netteller or Jeton isn't displayed.");
        Assert.assertTrue(withDrawPage.isAstroPlayDirectDisplayed() & withDrawPage.isVisaDisplayed(),"Astro Pay or Visa isn't displayed.");
        Assert.assertTrue(withDrawPage.isAstroPlayMobileDisplayed(),"Astro Pay Mobile isn't displayed.");
        Assert.assertTrue(withDrawPage.isEcoPayzDisplayed() & withDrawPage.isAstroPayDisplayed(),"Eco Pay or Astro Pay isn't displayed.");
        Assert.assertTrue(withDrawPage.isMuchBetterDisplayed() & withDrawPage.isWireCardDisplayed(),"Much better or Wire card isn't displayed.");
        Assert.assertTrue(withDrawPage.isBitCoinDisplayed() & withDrawPage.isPaySafeCardDisplayed(),"Bit coin or Pay safe card isn't displayed.");
    }

    @TmsLink("VBET-T50")
    @Test
    public void validationForFieldsViewWithDrawPage(){
        withDrawPage.openUrl(withDrawUrl);
        withDrawPage.waitUntilLoadFinish();
        withDrawPage.clickOnSkrill();
        Assert.assertTrue(withDrawPage.isEmailFieldDisplayed(0) & withDrawPage.isAmountFieldDisplayed(0),"Email or Amount field isn't displayed.");
        Assert.assertTrue(withDrawPage.isSubmitButtonDisplayed(0),"Submit button isn't displayed.");
        withDrawPage.clickOnQiwi();
        Assert.assertTrue(withDrawPage.isAmountFieldDisplayed(1) & withDrawPage.isPhoneNumberFieldDisplayed(),"Amount or Phone Number field isn't displayed.");
        Assert.assertTrue(withDrawPage.isSubmitButtonDisplayed(1),"Submit button isn't displayed.");
        withDrawPage.clickOnNeteller();
        Assert.assertTrue(withDrawPage.isEmailFieldDisplayed(1) & withDrawPage.isAmountFieldDisplayed(2),"Email or Amount field isn't displayed.");
        Assert.assertTrue(withDrawPage.isSubmitButtonDisplayed(2),"Submit button isn't displayed.");
        withDrawPage.clcikOnAstroPayDirect();
        Assert.assertTrue(withDrawPage.isAmountFieldDisplayed(3) & withDrawPage.isSubmitButtonDisplayed(3),"Submit button or Amount field isn't displayed.");
        withDrawPage.clickOnJeton();
        Assert.assertTrue(withDrawPage.isAmountFieldDisplayed(4) & withDrawPage.isPCustomNumberFieldDisplayed(),"PC Custom Number or Amount field isn't displayed.");
        Assert.assertTrue(withDrawPage.isSubmitButtonDisplayed(4),"Submit button isn't displayed.");
        withDrawPage.clickOnEcoPayz();
        Assert.assertTrue(withDrawPage.isAmountFieldDisplayed(5) & withDrawPage.isWalletIdDisplayed(),"Wallet Id or Amount field isn't displayed.");
        Assert.assertTrue(withDrawPage.isSubmitButtonDisplayed(5),"Submit button isn't displayed.");
        withDrawPage.clickOnAstroPay();
        Assert.assertTrue(withDrawPage.isEmailFieldDisplayed(2) & withDrawPage.isSurnameDisplayed(0),"Email or Surname field isn't displayed.");
        Assert.assertTrue(withDrawPage.isDocumentNumberDisplayed(0) & withDrawPage.isAmountFieldDisplayed(6),"Document Number or Amount field isn't displayed.");
        Assert.assertTrue(withDrawPage.isSubmitButtonDisplayed(6),"Submit button isn't displayed.");
        withDrawPage.clickOnMuchBetter();
        Assert.assertTrue(withDrawPage.isAmountFieldDisplayed(7),"Amount field isn't displayed.");
        Assert.assertTrue(withDrawPage.isSubmitButtonDisplayed(7),"Submit button isn't displayed.");
        withDrawPage.clickOnVisa();
        Assert.assertTrue(withDrawPage.isCardNumberDisplayed() & withDrawPage.isExpireDateDisplayed(),"Card Number or Expire date isn't displayed.");
        Assert.assertTrue(withDrawPage.isCountryCodeDisplayed() & withDrawPage.isCardHolderDisplayed(),"Country code or Card Holder isn't displayed.");
        Assert.assertTrue(withDrawPage.isAmountFieldDisplayed(8) & withDrawPage.isSubmitButtonDisplayed(8),"Submit button or Amount field isn't displayed.");
        withDrawPage.clickOnAstroPayMobile();
        Assert.assertTrue(withDrawPage.isPhoneNumberAstroDisplayed() & withDrawPage.isSurnameDisplayed(1),"Phone number or Surname field isn't displayed.");
        Assert.assertTrue(withDrawPage.isDocumentNumberDisplayed(1) & withDrawPage.isAmountFieldDisplayed(9),"Document Number or Amount field isn't displayed.");
        Assert.assertTrue(withDrawPage.isSubmitButtonDisplayed(9),"Submit button isn't displayed.");
        withDrawPage.clickOnWireCard();
        Assert.assertTrue(withDrawPage.isCreditCardNumberDisplayed() & withDrawPage.isExpirationYearFieldDisplayed(),"Credit card number or Expiration date field isn't displayed.");
        Assert.assertTrue(withDrawPage.isExpirationMonthFieldDisplayed() & withDrawPage.isCardHolderNameDisplayed(),"Expiration month or Card holder name field isn't displayed.");
        Assert.assertTrue(withDrawPage.isAmountFieldDisplayed(10) & withDrawPage.isSubmitButtonDisplayed(10),"Submit button or Amount field isn't displayed.");
        withDrawPage.clickOnBitCoin();
        Assert.assertTrue(withDrawPage.isAmountFieldDisplayed(11) & withDrawPage.isBitCoinDisplayed(),"Bit coin or Amount field isn't displayed.");
        Assert.assertTrue(withDrawPage.isSubmitButtonDisplayed(11),"Submit button isn't displayed.");
        withDrawPage.clickOnPaySafeCard();
        Assert.assertTrue(withDrawPage.isAmountFieldDisplayed(12) & withDrawPage.isEmailFieldDisplayed(3),"Email or Amount field isn't displayed.");
        Assert.assertTrue(withDrawPage.isSubmitButtonDisplayed(12),"Submit button isn't displayed.");
    }

    @TmsLink("VBET-T51")
    @Test
    public void validationForNotCompleteProfileWithDraw(){
        clearCaches();
        logInPage.openUrl(signInUrl);
        logInPage.closePopUp(signInUrl);
        logInPage.fillEmailPassFields(emailWithNotCompleteProfile,password);
        logInPage.clickOnLoginButton();
        logInPage.waitUntilLogInButtonDisappear();
        logInPage.waitUntilProfileLogoDisplayed();
        withDrawPage.openUrl(withDrawUrl);
        withDrawPage.waitUntilLoadFinish();
        Assert.assertTrue(withDrawPage.isProfileDataMissingMessageDisplayed(),"Is profile data missing message isn't displayed.");
        withDrawPage.clickOnProfileText();
        Assert.assertTrue(withDrawPage.isFirstNameInputDisplayed(),"First name input isn't displayed.");
    }

    @TmsLink("VBET-T52")
    @Test
    public void validationForCasinoPageElements() {
        balanceHistoryPage.openUrl(balanceHistoryUrl);
        balanceHistoryPage.clickOnCasinoArea();
        balanceHistoryPage.waitUntilNoRecordIconDisplayed();
        Assert.assertTrue(balanceHistoryPage.isTypeDropDownDisplayed() & balanceHistoryPage.isRangeStartDateDisplayed(),"Type drop down or Range start date isn't displayed.");
        Assert.assertTrue(balanceHistoryPage.isRangeEndDateDisplayed() & balanceHistoryPage.isNorRecordMessageDisplayed(),"No record message or Range end date isn't displayed.");
    }

    @TmsLink("VBET-T53")
    @Test
    public void validationForSportsBookPageElements() {
        balanceHistoryPage.openUrl(balanceHistoryUrl);
        balanceHistoryPage.clickOnSportsBookArea();
        balanceHistoryPage.waitUntilNoRecordIconDisplayed();
        Assert.assertTrue(balanceHistoryPage.isRangeEndDateDisplayed() & balanceHistoryPage.isRangeStartDateDisplayed(),"Range start or Range end date isn't displayed.");
        Assert.assertTrue(balanceHistoryPage.isNorRecordMessageDisplayed(),"No record message isn't displayed.");
    }

    @TmsLink("VBET-T54")
    @Test
    public void validationForAllPageElements() {
        balanceHistoryPage.openUrl(balanceHistoryUrl);
        balanceHistoryPage.waitUntilNoRecordIconDisplayed();
        Assert.assertTrue(balanceHistoryPage.isTypeDropDownDisplayed() & balanceHistoryPage.isRangeStartDateDisplayed(),"Type drop down or Range start date isn't displayed.");
        Assert.assertTrue(balanceHistoryPage.isRangeEndDateDisplayed() & balanceHistoryPage.isNorRecordMessageDisplayed(),"No record message or Range end date isn't displayed.");
    }

    @TmsLink("VBET-T55")
    @Test
    public void validationForSelectionOfAres(){
        balanceHistoryPage.openUrl(depositUrl);
        myProfilePage.clickOnBalanceHistory();
        balanceHistoryPage.waitUntilNoRecordIconDisplayed();
        balanceHistoryPage.clickOnSportsBookArea();
        Assert.assertTrue(balanceHistoryPage.isSportsBookAreaSelected(),"Sports book isn't selected");
        balanceHistoryPage.clickOnCasinoArea();
        Assert.assertTrue(balanceHistoryPage.isCasinoAreaSelected(),"Casino area isn't selected");
        balanceHistoryPage.clickOnAllArea();
        Assert.assertTrue(balanceHistoryPage.isAllAreaSelected(),"All area isn't selected");
    }

    @AfterMethod
    public void clearCookies(){
        clearCaches();
    }
}
