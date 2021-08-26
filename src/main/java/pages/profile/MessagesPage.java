package pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utilities.WaitUtils;

public class MessagesPage extends BasePage {

    private final By INBOX = By.cssSelector("div[class='messages-container'] div[data-tab='inbox']");
    private final By SENT_MESSAGE = By.cssSelector("div[class='messages-container'] div[data-tab='sent-messages']");
    private final By NO_RECORD_FOUND = By.cssSelector("div[class='no-record-found'] span");
    private final By NEW_MESSAGE_LINK = By.cssSelector("span[class='new-message-link-text']");
    private final By SEND_MESSAGE_BUTTON = By.cssSelector("button[class='btn buttons1558357729029 ']");
    private final By SUBJECT_FIELD = By.name("subject");
    private final By MESSAGE_FIELD = By.name("body");
    private final By WARNING_ICON = By.cssSelector("div[class='sb-icon icon-sb-no-record']");

    public MessagesPage(WebDriver driver){
        super(driver);
    }

    public void clickOnInbox(){
        clickOnElement(INBOX);
    }

    public void clickOnSentMessage(){
        clickOnElement(SENT_MESSAGE);
    }

    public boolean isInboxSelected(){
        return getAttribute(INBOX,"class").contains("selected");
    }

    public boolean isISentMessageSelected(){
        return getAttribute(SENT_MESSAGE,"class").contains("selected");
    }

    public boolean isNoRecordFoundTextDisplayed(){
        return isElementDisplayed(NO_RECORD_FOUND);
    }

    public void clickOnNewMessageLink(){
        clickOnElement(NEW_MESSAGE_LINK);
    }

    public boolean isSendMessageButtonDisplayed(){
        return isElementDisplayed(SEND_MESSAGE_BUTTON);
    }

    public boolean isSubjectFieldDisplayed(){
        return isElementDisplayed(SUBJECT_FIELD);
    }

    public boolean isMessageFieldDisplayed(){
        return isElementDisplayed(MESSAGE_FIELD);
    }

    public void waitUntilWarningIconDisplayed(){
        waitUtils.waitUntilElementAppear(WARNING_ICON);
    }
}
