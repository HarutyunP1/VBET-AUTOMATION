package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WaitUtils;

import java.util.ArrayList;
import java.util.List;


public class SportsPage extends BasePage {

    private final By LIVE_EVENTS_RATE = By.cssSelector("div[class='row markets-container '] div[class='col-xs-4 col sb-game-bet-block   ']");
    private final By LIVE_EVENTS_RATE_CHECKED = By.cssSelector("div[class='row markets-container '] div[class='col-xs-4 col sb-game-bet-block added  ']");
    private final By EVENTS_RATE = By.cssSelector("div[class='events-list-container large live'] div[class='sb-game-bet-block-inner']");
    private final By SIGN_IN_AND_BET_BUTTON = By.cssSelector("a[class='btn place-bet-btn buttons1558357729029']");
    private final By CASINO_GAMES_SECTION = By.cssSelector("div[class='row-container  container '] div[class='column col-sm-6 '] h6 span strong");
    private final By REGISTER_BUTTON = By.cssSelector("a[class='btn signup-btn sbRegisterBtn btn1']");
    private final By SIGN_IN_BUTTON = By.cssSelector("a[class='link signin-btn sbLoginBtn']");
    private final By PROFILE_LOGO_AREA = By.cssSelector("div[class='loggedInStateButtons compact desktop ember-view']");
    private final By PROFILE_LOGO = By.cssSelector("div[class='profile-overlay']");
    private final By LOG_OUT_BUTTON = By.cssSelector("span[class='acc-icon icon-sb-log-out']");
    private final By EDIT_PROFILE = By.cssSelector("span[class='acc-icon icon-sb-edit-profile']");
    private final By REGION_CHOOSER_POP_UP_CLOSE_BUTTON = By.cssSelector("i.uci-close");
    private final By INTERCOME_FRAME = By.cssSelector("iframe[class='intercom-1fonhp6 e1u5aocb0']");
    private final By INTERCOME_POP_UP_CLOSE_BUTTON = By.cssSelector("span[aria-label='Close']");
    private final By HEADER_LINKS = By.cssSelector("div[class='column col-xs-5 '] a[class='nav-item']");
    private final By SEARCH_FIELD = By.cssSelector("input[class='search-input ember-text-field ember-view']");
    private final By BANNER_ELEMENTS = By.cssSelector("div img[class='image']");
    private final By WELCOME_OFFER_TEXT = By.cssSelector("div[class='  module ModuleTitle '] h2");
    private final By ESPORT_WELCOME_TEXT = By.cssSelector("h5 strong");
    private final By VAR_ED_GOAL_TEXT = By.cssSelector("p p span strong");
    private final By TABS = By.cssSelector("div[class='uc-row vbetheader header-row sb-account-row'] a[class='nav-item'] span[class='title']");
    private final By EVENTS_RATE_TEXT = By.cssSelector("div[class='row markets-container '] div[class='sb-game-bet-coeficiente ']");
    private final By ERROR_PAGE_TEXT = By.cssSelector("div[class='uc-content '] h3");

    private static ArrayList<String> eventsText = new ArrayList<>();
    List<WebElement> eventsRates;

    private List<WebElement> eventsRate;
    private final String welcomeOfferImageEn = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/37348-a-104-vbet-com-promo-eng-15731377338955.jpg";
    private final String esportWelcomeImageEn = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/37348-a-587-a-639-welcome-bonus-copy-15731377339314.jpg";
    private final String varEdGoalImageEn = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/37348-a-674-var-vbet-15731377338825.jpg";
    private final String welcomeOfferImageKa = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/37183-a-458-vbet-com-promo-geo-15730486871581.jpg";
    private final String esportWelcomeImageKa = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/37183-a-606-a-652-geo-15668256625124-15730486872088.jpg";
    private final String varEdGoalImageKa = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/37183-a-93-edit-bet-15604038864541-15730486871595.jpg";
    private final String welcomeOfferImageTr = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/37161-a-452-vbet-com-promo-turk-15729571025426.jpg";
    private final String esportWelcomeImageTr = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/37185-a-615-a-644-arm-copy-15730283501156.jpg";
    private final String varEdGoalImageTr = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/37185-8.png";
    private final String welcomeOfferImageRu = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/37186-a-103-vbet-com-promo-ru-15730497032432.jpg";
    private final String esportWelcomeImageRu = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/37186-a-596-a-645-rus-15668129275591-15730497032563.jpg";
    private final String varEdGoalImageRu = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/a-55-jacksport-15603551770305.jpg";
    private final String welcomeOfferImageUk = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/38402-vbet-ukr.jpg";
    private final String esportWelcomeImageUk = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/a-766-a-267-edit-bet-15615459388621.jpg";
    private final String varEdGoalImageUk = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/38402-a-770-a-271-jacksport-15615461759913-15755520064363.jpg";
    private final String[] tabsTextEn = {"Sports", "Casino", "Live Casino", "Poker", "Games", "Lottery"};
    private final String[] tabsTextKa = {"სპორტი", "კაზინო", "ლაივ კაზინო", "პოკერი", "თამაშები", "ლატარია"};
    private final String[] tabsTextTr = {"Sporlar", "Casino", "Canlı Casino", "Poker", "Oyunlar", "Lottery"};
    private final String[] tabsTextRu = {"Спорт", "Казино", "Лайв Казино", "Покер", "Игры", "ЛОТОРЕЯ"};
    private final String[] tabsTextUk = {"Спорт", "Лайв Казино", "Казино", "Покер", "Ігри", "Лотерея"};

    public SportsPage(WebDriver driver) {
        super(driver);
    }

    public void getEventsRateTextFromLive() {
        eventsRate = getElements(EVENTS_RATE_TEXT);
        for (int i = 0; i < eventsRate.size(); i++) {
            if (eventsRate.get(i).getAttribute("background-color").equals("#fecb5a")) {
                eventsText.add(eventsRate.get(i).getText());
            }
        }
    }

    public ArrayList getEventsText() {
        return eventsText;
    }

    public void clickRegionChooserPopCloseButton() {
        clickOnElement(REGION_CHOOSER_POP_UP_CLOSE_BUTTON);
    }

    public void clickOnFirstRates() {
        clickOnElement(LIVE_EVENTS_RATE, 1);
    }

    public void clickOnSignInAndBetButton() {
        clickOnElement(SIGN_IN_AND_BET_BUTTON);
    }


    public void scrollToCasinoGamesSection(String sportsUrl) {
        switch (sportsUrl) {
            case "https://www.vbet.com/sports":
                scrollToElement(CASINO_GAMES_SECTION);
            case "https://www.vbet.com/ru/sports":
                break;
            default:
                break;
        }
    }

    public void clickRegisterButton() {
        clickOnElement(REGISTER_BUTTON);
    }

    public void clickSignInButton() {
        clickOnElement(SIGN_IN_BUTTON);
    }

    public void hoverOnProfileLogo() {
        mouseHover(PROFILE_LOGO_AREA);
    }

    public boolean isProfileIconDisplayed() {
        return isElementDisplayed(PROFILE_LOGO_AREA);
    }

    public void clickOnLogOutButton() {
        clickOnElement(LOG_OUT_BUTTON);
    }

    public void clickOnEditProfileLink() {
        clickOnElement(EDIT_PROFILE);
    }

    public void waitUntilPageIsLoad() {
        waitUtils.waitUntilPageIsLoad();
    }

    public void clickInterComeCloseButton() {
        switchFrames(INTERCOME_FRAME);
        clickOnElement(INTERCOME_POP_UP_CLOSE_BUTTON);
    }

    public void switchInterComeFrame() {
        switchFrames(INTERCOME_FRAME);

    }

    public void waitUntilProfileIconVisible() {
        waitUtils.waitUntilElementVisible(PROFILE_LOGO_AREA);
    }

    public List<WebElement> getLiveEventsRate() {
        return getElements(LIVE_EVENTS_RATE);
    }

    public void clickOnEventsRate(int[] index) {
        List<WebElement> eventsRate = getLiveEventsRate();
        for (int i = 0; i < eventsRate.size(); i++) {
            for (int j = 0; j < index.length; j++) {
                if (j < eventsRate.size()) {
                    if (j == i) {
                        eventsRate.get(i).click();
                        eventsText.add(eventsRate.get(i).getText());
                    }
                }
            }
        }
    }


    public void clickOnEventsRate(int index) {
        // a temporary solution has been given
        WaitUtils.threadSleep(4000);
        eventsRates = getElements(LIVE_EVENTS_RATE);
        int count = 0;
        for (int i = 0; i < eventsRates.size(); i = i + 3) {
            if (count == index) {
                break;
            }
            eventsRates.get(i).click();
            eventsText.add(getText(EVENTS_RATE_TEXT, i));
            count++;
        }
    }

    public static ArrayList<String> getEventsRateText() {
        return eventsText;
    }

    public void clickOnGamesLink() {
        clickOnElement(HEADER_LINKS, 5);
    }

    public void clickOnProfileLogo() {
        clickOnElement(PROFILE_LOGO);
    }

    public boolean isSearchFieldDisplayed() {
        return isElementDisplayed(SEARCH_FIELD);
    }

    public boolean isWelcomeOfferDisplayed(String sportsUrl) {
        switch (sportsUrl) {
            case "https://www.vbet.com/sports":
                return getElements(BANNER_ELEMENTS).get(0).getAttribute("src").equals(welcomeOfferImageEn);
            case "https://www.vbet.com/ka/%E1%83%A1%E1%83%9E%E1%83%9D%E1%83%A0%E1%83%A2%E1%83%98-1":
                return getElements(BANNER_ELEMENTS).get(0).getAttribute("src").equals(welcomeOfferImageKa);
            case "https://www.vbet.com/tr/sporlar":
                return getElements(BANNER_ELEMENTS).get(0).getAttribute("src").equals(welcomeOfferImageTr);
            case "https://www.vbet.com/ru/sports":
                return getElements(BANNER_ELEMENTS).get(0).getAttribute("src").equals(welcomeOfferImageRu);
            case "https://www.vbet.com/uk/%D1%81%D0%BF%D0%BE%D1%80%D1%82":
                return getElements(BANNER_ELEMENTS).get(0).getAttribute("src").equals(welcomeOfferImageUk);
            default:
                return false;
        }
    }

    public boolean isEsportsWelcomeDisplayed(String sportsUrl) {
        switch (sportsUrl) {
            case "https://www.vbet.com/sports":
                return getElements(BANNER_ELEMENTS).get(1).getAttribute("src").equals(esportWelcomeImageEn);
            case "https://www.vbet.com/ka/%E1%83%A1%E1%83%9E%E1%83%9D%E1%83%A0%E1%83%A2%E1%83%98-1":
                return getElements(BANNER_ELEMENTS).get(1).getAttribute("src").equals(esportWelcomeImageKa);
            case "https://www.vbet.com/tr/sporlar":
                return getElements(BANNER_ELEMENTS).get(1).getAttribute("src").equals(esportWelcomeImageTr);
            case "https://www.vbet.com/ru/sports":
                return getElements(BANNER_ELEMENTS).get(1).getAttribute("src").equals(esportWelcomeImageRu);
            case "https://www.vbet.com/uk/%D1%81%D0%BF%D0%BE%D1%80%D1%82":
                return getElements(BANNER_ELEMENTS).get(1).getAttribute("src").equals(esportWelcomeImageUk);
            default:
                return false;
        }
    }

    public boolean isVarEdGoalDisplayed(String sportsUrl) {
        switch (sportsUrl) {
            case "https://www.vbet.com/sports":
                return getElements(BANNER_ELEMENTS).get(2).getAttribute("src").equals(varEdGoalImageEn);
            case "https://www.vbet.com/ka/%E1%83%A1%E1%83%9E%E1%83%9D%E1%83%A0%E1%83%A2%E1%83%98-1":
                return getElements(BANNER_ELEMENTS).get(2).getAttribute("src").equals(varEdGoalImageKa);
            case "https://www.vbet.com/tr/sporlar":
                return getElements(BANNER_ELEMENTS).get(2).getAttribute("src").equals(varEdGoalImageTr);
            case "https://www.vbet.com/ru/sports":
                return getElements(BANNER_ELEMENTS).get(2).getAttribute("src").equals(varEdGoalImageRu);
            case "https://www.vbet.com/uk/%D1%81%D0%BF%D0%BE%D1%80%D1%82":
                return getElements(BANNER_ELEMENTS).get(2).getAttribute("src").equals(varEdGoalImageUk);
            default:
                return false;
        }
    }

    public void clickOnWelcomeOffer() {
        clickOnElement(BANNER_ELEMENTS, 0);
    }

    public void clickOnEsportsOffer() {
        clickOnElement(BANNER_ELEMENTS, 1);
    }

    public void clickOnVarEdGoal() {
        clickOnElement(BANNER_ELEMENTS, 2);
    }

    public boolean isErrorPageTextDisplayed(){
        return isElementDisplayed(ERROR_PAGE_TEXT);
    }

    public boolean isSportsDisplayed(String sportsUrl) {
        switch (sportsUrl) {
            case "https://www.vbet.com/sports":
                return getText(TABS,0).contains(tabsTextEn[0].toUpperCase());
            case "https://www.vbet.com/ka/%E1%83%A1%E1%83%9E%E1%83%9D%E1%83%A0%E1%83%A2%E1%83%98-1":
                return getText(TABS,0).length() == tabsTextKa[0].length();
            case "https://www.vbet.com/tr/sporlar":
                return getText(TABS,0).contains(tabsTextTr[0].toUpperCase());
            case "https://www.vbet.com/ru/sports":
                return getText(TABS,0).contains(tabsTextRu[0].toUpperCase());
            case "https://www.vbet.com/uk/%D1%81%D0%BF%D0%BE%D1%80%D1%82":
                return getText(TABS,0).contains(tabsTextUk[0].toUpperCase());
            default:
                return false;
        }
    }

    public boolean isCasinoDisplayed(String sportsUrl) {
        switch (sportsUrl) {
            case "https://www.vbet.com/sports":
                return getText(TABS,1).contains(tabsTextEn[1].toUpperCase());
            case "https://www.vbet.com/ka/%E1%83%A1%E1%83%9E%E1%83%9D%E1%83%A0%E1%83%A2%E1%83%98-1":
                return getText(TABS,1).length() == tabsTextKa[1].length();
            case "https://www.vbet.com/tr/sporlar":
                return getText(TABS,1).contains(tabsTextTr[1].toUpperCase());
            case "https://www.vbet.com/ru/sports":
                return getText(TABS,1).contains(tabsTextRu[1].toUpperCase());
            case "https://www.vbet.com/uk/%D1%81%D0%BF%D0%BE%D1%80%D1%82":
                return getText(TABS,1).contains(tabsTextUk[1].toUpperCase());
            default:
                return false;
        }
    }

    public boolean isSLiveCasinoDisplayed(String sportsUrl) {
        switch (sportsUrl) {
            case "https://www.vbet.com/sports":
                return getText(TABS,2).contains(tabsTextEn[2].toUpperCase());
            case "https://www.vbet.com/ka/%E1%83%A1%E1%83%9E%E1%83%9D%E1%83%A0%E1%83%A2%E1%83%98-1":
                return getText(TABS,2).length() == tabsTextKa[2].length();
            case "https://www.vbet.com/tr/sporlar":
                return getText(TABS,2).contains(tabsTextTr[2].toUpperCase());
            case "https://www.vbet.com/ru/sports":
                return getText(TABS,2).contains(tabsTextRu[2].toUpperCase());
            case "https://www.vbet.com/uk/%D1%81%D0%BF%D0%BE%D1%80%D1%82":
                return getText(TABS,2).contains(tabsTextUk[2].toUpperCase());
            default:
                return false;
        }
    }

    public boolean isPokerDisplayed(String sportsUrl) {
        switch (sportsUrl) {
            case "https://www.vbet.com/sports":
                return getText(TABS,3).contains(tabsTextEn[3].toUpperCase());
            case "https://www.vbet.com/ka/%E1%83%A1%E1%83%9E%E1%83%9D%E1%83%A0%E1%83%A2%E1%83%98-1":
                return getText(TABS,3).length() == tabsTextKa[3].length();
            case "https://www.vbet.com/tr/sporlar":
                return getText(TABS,3).contains(tabsTextTr[3].toUpperCase());
            case "https://www.vbet.com/ru/sports":
                return getText(TABS,3).contains(tabsTextRu[3].toUpperCase());
            case "https://www.vbet.com/uk/%D1%81%D0%BF%D0%BE%D1%80%D1%82":
                return getText(TABS,3).contains(tabsTextUk[3].toUpperCase());
            default:
                return false;
        }
    }

    public boolean isGamesDisplayed(String sportsUrl) {
        switch (sportsUrl) {
            case "https://www.vbet.com/sports":
                return getText(TABS,4).contains(tabsTextEn[4].toUpperCase());
            case "https://www.vbet.com/ka/%E1%83%A1%E1%83%9E%E1%83%9D%E1%83%A0%E1%83%A2%E1%83%98-1":
                return getText(TABS,4).length() == tabsTextKa[4].length();
            case "https://www.vbet.com/tr/sporlar":
                return getText(TABS,4).contains(tabsTextTr[4].toUpperCase());
            case "https://www.vbet.com/ru/sports":
                return getText(TABS,4).contains(tabsTextRu[4].toUpperCase());
            case "https://www.vbet.com/uk/%D1%81%D0%BF%D0%BE%D1%80%D1%82":
                return getText(TABS,4).contains(tabsTextUk[4].toUpperCase());
            default:
                return false;
        }
    }

    public boolean isLotteryDisplayed(String sportsUrl) {
        switch (sportsUrl) {
            case "https://www.vbet.com/sports":
                return getText(TABS,5).contains(tabsTextEn[5].toUpperCase());
            case "https://www.vbet.com/ka/%E1%83%A1%E1%83%9E%E1%83%9D%E1%83%A0%E1%83%A2%E1%83%98-1":
                return getText(TABS,5).length() == tabsTextKa[5].length();
            case "https://www.vbet.com/tr/sporlar":
                return getText(TABS,5).contains(tabsTextTr[5].toUpperCase());
            case "https://www.vbet.com/ru/sports":
                return getText(TABS,5).contains(tabsTextRu[5].toUpperCase());
            case "https://www.vbet.com/uk/%D1%81%D0%BF%D0%BE%D1%80%D1%82":
                return getText(TABS,5).contains(tabsTextUk[5].toUpperCase());
            default:
                return false;
        }
    }

    public void waitUntilRatesAppear(){
        waitUtils.waitUntilElementAppear(getElements(LIVE_EVENTS_RATE).get(0),15);
    }

    public void waitUntilSignInAndPlaceBetButtonAppear(){
        waitUtils.waitUntilElementAppear(SIGN_IN_AND_BET_BUTTON);
    }

    public void clickOnCheckedEventsRates(){
        for (int i = 0;i < getElements(LIVE_EVENTS_RATE_CHECKED).size();i++){
            getElements(LIVE_EVENTS_RATE_CHECKED).get(i).click();
        }
        eventsRates = getElements(LIVE_EVENTS_RATE);
    }
}
