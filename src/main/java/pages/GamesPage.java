package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtils;

public class GamesPage extends BasePage{

    private final By PLAY_NOW_BUTTONS = By.cssSelector("a[class='btn buttons1558521212874']");
    private final By GAME_IMAGES = By.cssSelector("div[class=' effect-block public-mode figure effect-steve  '] img");
    private final By GAME_TABLE_POKER = By.cssSelector("div[class=\"logo-p-contain\"]");
    private final By GAME_TABLE_BELOTE = By.id("blotMainTablesDiv");
    private final By GAME_TABLE_FARKLE = By.cssSelector("div[class='for-sheet-block'] div[class='for-scroll-y']");
    private final By GAME_TABLE_FSPORT = By.cssSelector("div[class='fsport']");
    private final By GAME_TABLE_BLAST = By.cssSelector("div[class='layout-main']");
    private final By GAME_TABLE_RUSSIAN_ROULETTE = By.cssSelector("div[class='russianRoulette']");
    private final By GAME_TABLE_BACKGAMMON = By.cssSelector("div[class='main-col ng-scope']");
    private final By GAME_TABLE_CHECKERS = By.cssSelector("div[class='data-table']");
    private final By GAME_TABLE_TALISMAN = By.cssSelector("div[class='root-component']");
    private final By GAME_TABLE_KENO = By.cssSelector("div[class='game-b-c-b-c']");
    private final By GAME_TABLE_OGWIL = By.cssSelector("div[class='ogwil']");
    private final By GAME_TABLE_CHINGACHOONG = By.cssSelector("div[class='chingachoong']");
    private final By GAMES_FRAME_0 =By.cssSelector("div[id=\"poker-container22642\"] iframe");
    private final By GAMES_FRAME = By.cssSelector("html body iframe[id=\"gameFrame\"]");
    private final By CATEGORIES = By.cssSelector("img[class='image']");
    private final By NICKNAME_POPUP_BUTTON=By.tagName("iframe");
    private final By FIELD_FOR_NICKNAME=By.cssSelector(" div[class=\"input-wrapper-m darken-view\"] input");
    private final By OK_BUTTON_ON_NICK_BUTTON=By.cssSelector("div[class=\"modal-window-wrapper\"] button");

    private final String pokerImage = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/2873-poker-15602532053062.png";
    private final String farkleImage = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/2889-zonk.png";
    private final String blastImage = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/8038-blast.png";
    private final String backgammonImage = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/2856-5868-backgammon.png";
    private final String talismanImage = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/2860-group-1.png";
    private final String ogwilImage = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/2852-ogwil.png";
    private final String beloteImage = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/2868-belote.png";
    private final String fsportImage = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/24760-fsport.png";
    private final String russianRouletteImage = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/2881-russian-roulette.png";
    private final String checkersImage = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/2885-checkers.png";
    private final String kenoImage = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/25071-group-1-15741588962474.png";
    private final String chingachoongImage = "https://static.betconstruct.me/fs/userFiles/vbetcom-updated/images/2877-chingachoong1.png";

    public GamesPage(WebDriver driver) {
        super(driver);
    }

    public void fillInNickNameField(){
        WaitUtils.threadSleep(2000);
        switchFrames(GAMES_FRAME_0);
        switchFrames(GAMES_FRAME);
        typeText(FIELD_FOR_NICKNAME,"Joker007");

    }
    public void clickOnOkButtonOnNickPopUp(){
        WaitUtils.threadSleep(2000);
        clickOnElement(OK_BUTTON_ON_NICK_BUTTON,0);
    }


    public boolean isPokerOnWrightPlace(){
        return getElements(GAME_IMAGES).get(0).getAttribute("src").equals(pokerImage);
    }

    public boolean isBeloteOnWrightPlace(){
        return getElements(GAME_IMAGES).get(1).getAttribute("src").equals(beloteImage);
    }

    public boolean isFarkleOnWrightPlace(){
        return getElements(GAME_IMAGES).get(2).getAttribute("src").equals(farkleImage);
    }

    public boolean isFsportOnWrightPlace(){
        return getElements(GAME_IMAGES).get(3).getAttribute("src").equals(fsportImage);
    }

    public boolean isBlastOnWrightPlace(){
        return getElements(GAME_IMAGES).get(4).getAttribute("src").equals(blastImage);
    }

    public boolean isRussianRouletteOnWrightPlace(){
        return getElements(GAME_IMAGES).get(5).getAttribute("src").equals(russianRouletteImage);
    }


    public boolean isBackgammonOnWrightPlace(){
        return getElements(GAME_IMAGES).get(6).getAttribute("src").equals(backgammonImage);
    }

    public boolean isCheckersOnWrightPlace(){
        return getElements(GAME_IMAGES).get(7).getAttribute("src").equals(checkersImage);
    }

    public boolean isTalismanOnWrightPlace(){
        return getElements(GAME_IMAGES).get(8).getAttribute("src").equals(talismanImage);
    }

    public boolean isKenoOnWrightPlace(){
        return getElements(GAME_IMAGES).get(9).getAttribute("src").equals(kenoImage);
    }

    public boolean isOgwilOnWrightPlace(){
        return getElements(GAME_IMAGES).get(10).getAttribute("src").equals(ogwilImage);
    }

    public boolean isChingachoongOnWrightPlace(){
        return getElements(GAME_IMAGES).get(11).getAttribute("src").equals(chingachoongImage);
    }

    public void clickOnPokerCategory(){
        clickOnElement(CATEGORIES,0);
    }





    public void clickOnFarkleCategory(){
        clickOnElement(CATEGORIES,1);
    }

    public void clickOnBlastCategory(){
        clickOnElement(CATEGORIES,2);
    }

    public void clickOnBackgammonCategory(){
        clickOnElement(CATEGORIES,3);
    }

    public void clickOnTalismanCategory(){
        clickOnElement(CATEGORIES,4);
    }

    public void clickOnOgwilCategory(){
        clickOnElement(CATEGORIES,5);
    }

    public void clickOnBeloteCategory(){
        clickOnElement(CATEGORIES,6);
    }

    public void clickOnFsportCategory(){
        clickOnElement(CATEGORIES,7);
    }

    public void clickOnRussianRouletteCategory(){
        clickOnElement(CATEGORIES,8);
    }

    public void clickOnCheckersCategory(){
        clickOnElement(CATEGORIES,9);
    }

    public void clickOnKenoCategory(){
        clickOnElement(CATEGORIES,10);
    }

    public void clickOnChingaChoongCategory(){
        clickOnElement(CATEGORIES,11);
    }

    public boolean isGameTablePokerDisplayed(){
        WaitUtils.threadSleep(2000);
        switchFrames(GAMES_FRAME_0);
        switchFrames(GAMES_FRAME);
        return true;
    }

    public boolean isGameTableBlastDisplayed(){
        return isElementDisplayedGamePage(GAME_TABLE_BLAST);
    }

    public boolean isGameTableBeloteDisplayed(){
        return isElementDisplayedGamePage(GAME_TABLE_BELOTE);
    }

    public boolean isGameTableFarkleDisplayed(){
        return isElementDisplayedGamePage(GAME_TABLE_FARKLE);
    }

    public boolean isGameTableFsportDisplayed(){
        return isElementDisplayed(GAME_TABLE_FSPORT);
    }

    public boolean isGameTableRussianRouletteDisplayed(){
        return isElementDisplayedGamePage(GAME_TABLE_RUSSIAN_ROULETTE);
    }

    public boolean isGameTableBackgammonDisplayed(){
        return isElementDisplayedGamePage(GAME_TABLE_BACKGAMMON);
    }

    public boolean isGameTableCheckersDisplayed(){
        return isElementDisplayedGamePage(GAME_TABLE_CHECKERS);
    }

    public boolean isGameTableTalismanDisplayed(){
        return isElementDisplayedGamePage(GAME_TABLE_TALISMAN);
    }

    public boolean isGameTableKenoDisplayed(){
        return isElementDisplayedGamePage(GAME_TABLE_KENO);
    }

    public boolean isGameTableOgwilDisplayed(){
        return isElementDisplayed(GAME_TABLE_OGWIL);
    }

    public boolean isGameTableChingachoongDisplayed(){
        return isElementDisplayed(GAME_TABLE_CHINGACHOONG);
    }

    public void clickOnPlayNowButton(int index){
        waitUtils.waitUntilPageIsLoad();
        clickOnElement(PLAY_NOW_BUTTONS,index);
    }

    public void navigateBack(){
        navigateBackFromThePage();
        waitUtils.waitUntilPageIsLoad();
        refreshPage();
        waitUtils.waitUntilPageIsLoad();
    }


    private boolean isElementDisplayedGamePage(By by){
            boolean bool = false;
            int count = 0;
            while (!bool){
                if (count > 9)
                    break;
                if (isElementDisplayedOnFrame(by))
                    bool = true;
                count++;
                WaitUtils.threadSleep(1000);
            }
            return bool;
        }


    }

