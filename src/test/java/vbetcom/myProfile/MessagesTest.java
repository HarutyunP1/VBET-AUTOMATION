package vbetcom.myProfile;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.profile.MessagesPage;
import pages.profile.MyProfilePage;
import utilities.TestBase;

public class MessagesTest extends TestBase {

    private String signInUrl;
    private String inboxUrl;
    private String sentMessageUrl;
    private String newMessage;
    private MessagesPage messagesPage;
    private MyProfilePage myProfilePage;
    private LogInPage logInPage;
    private String email = "automation7@yopmail.com";
    private String password = "Test1111";

    @BeforeClass
    @Parameters({"signInUrl","inboxUrl","sentMessageUrl","newMessage"})
    public void setUp(String signInUrl,String inboxUrl,String sentMessageUrl,String newMessage){
        this.signInUrl = signInUrl;
        this.inboxUrl = inboxUrl;
        this.sentMessageUrl = sentMessageUrl;
        this.newMessage = newMessage;
        messagesPage = new MessagesPage(driver);
        logInPage = new LogInPage(driver);
        myProfilePage = new MyProfilePage(driver);
        logInPage.openUrl(signInUrl);
        logInPage.fillEmailPassFields(email,password);
        logInPage.clickOnLoginButton();
        logInPage.waitUntilProfileLogoDisplayed();
        logInPage.waitUntilBalanceLoad();
    }

    @TmsLink("VBET-T61")
    @Test
    public void validationForNoRecordFoundMessageShouldBeDisplayed(){
        messagesPage.openUrl(newMessage);
        myProfilePage.clickOnInbox();
        messagesPage.waitUntilWarningIconDisplayed();
        Assert.assertTrue(messagesPage.isNoRecordFoundTextDisplayed(),"No record fount message isn't displayed.");
        messagesPage.clickOnSentMessage();
        Assert.assertTrue(messagesPage.isNoRecordFoundTextDisplayed(),"No record fount message isn't displayed.");
    }

    @TmsLink("VBET-T62")
    @Test
    public void validationForHeaderElementsDisplayed(){
        messagesPage.openUrl(inboxUrl);
        myProfilePage.clickOnNewMessage();
        Assert.assertTrue(messagesPage.isSubjectFieldDisplayed(),"Subject field isn't displayed.");
        Assert.assertTrue(messagesPage.isMessageFieldDisplayed(),"Message field isn't displayed.");
        Assert.assertTrue(messagesPage.isSendMessageButtonDisplayed(),"Send message isn't displayed.");
    }

    @TmsLink("VBET-T63")
    @Test
    public void validationForNewMessageLinkRedirection(){
        messagesPage.openUrl(inboxUrl);
        messagesPage.waitUntilWarningIconDisplayed();
        messagesPage.clickOnNewMessageLink();
        Assert.assertTrue(messagesPage.isSubjectFieldDisplayed(),"Subject field isn't displayed.");
    }

    @TmsLink("VBET-T64")
    @Test
    public void validationForHeaderElementsSelected(){
        messagesPage.openUrl(inboxUrl);
        messagesPage.waitUntilWarningIconDisplayed();
        messagesPage.clickOnSentMessage();
        messagesPage.waitUntilWarningIconDisplayed();
        Assert.assertTrue(messagesPage.isISentMessageSelected(),"Send Message isn't selected.");
        messagesPage.clickOnInbox();
        Assert.assertTrue(messagesPage.isInboxSelected(),"Inbox isn't selected.");
    }
}
