package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtils;


public class BettingPage extends BasePage {

    private SportsPage sportsPage;
    private final By STAKE_FIELD = By.cssSelector("div[class='sb-input-inner-label'] input");
    private final By STAKE_FIELD_SINGLE_BET = By.cssSelector("div[class='betslip-matches-total-info'] input");
    private final By STAKE_FIELD_SINGLE_BET_MULTI_STAKE = By.cssSelector("div[class='sb-input-inner-label'] input");
    private final By POSSIBLE_WIN = By.cssSelector("span[class='possible-win']");
    private final By PLACE_BET_BUTTON = By.cssSelector("div[class='sb-bet-button-wrapper'] a");
    private final By USER_PRICE = By.cssSelector("span[class='userBalance']");
    private final By BETTING_TYPE = By.cssSelector("div[class='betslip-panel'] select");

    public BettingPage(WebDriver driver){
        super(driver);
        sportsPage = new SportsPage(driver);
    }

    public int getUserPriceValue(){
        return Integer.parseInt(getText(USER_PRICE).substring(0,getText(USER_PRICE).indexOf(".")));
    }

    public void fillInStakeField(String stakeValue){
        typeText(STAKE_FIELD,stakeValue);
    }

    public boolean isPriceSelectedFromUserPrice(int price,int previousPrice){
        return Integer.parseInt(getText(USER_PRICE).substring(0,getText(USER_PRICE).indexOf("."))) == previousPrice - price;
    }

    public boolean isPriceSelectedFromUserPrice(int price,int previousPrice,int count){
        return Integer.parseInt(getText(USER_PRICE).substring(0,getText(USER_PRICE).indexOf("."))) == previousPrice - (count*price);
    }

    public boolean possibleWinCalculation(String price){
        // a temporary solution has been given
        WaitUtils.threadSleep(3000);
        String actualPrice = (multiplyEventsRate()*Double.valueOf(price)) + "";
        // a temporary solution has been given
        WaitUtils.threadSleep(1000);
        return Integer.parseInt(actualPrice.substring(0,actualPrice.indexOf("."))) == Integer.parseInt(getText(POSSIBLE_WIN).substring(0,getText(POSSIBLE_WIN).indexOf(".")));
    }

    public void clickOnPlaceBetButton(){
        clickOnElement(PLACE_BET_BUTTON);
    }

    public void waitUntilPlaceBetButtonDisappear(){
        waitUtils.waitUntilElementDisappear(PLACE_BET_BUTTON);
    }

    private Double multiplyEventsRate(){
        double sum = 1;
        for (int i = 0;i < sportsPage.getEventsRateText().size();i++){
            sum *= Double.valueOf(sportsPage.getEventsRateText().get(i));
        }
        return sum;
    }

    public void fillInStakeFieldSingleBetMultiStake(String[] stakeValue){
        for (int i = 0;i < getElementsCount(STAKE_FIELD_SINGLE_BET_MULTI_STAKE) - 1;i++){
            typeText(STAKE_FIELD_SINGLE_BET_MULTI_STAKE,i,stakeValue[i]);
        }
    }

    public void selectBettingType(String bettingType){
        selectByValue(BETTING_TYPE,bettingType);
    }

    public int sumOfStakes(String[] stakeValue){
        int sum = 0;
        for (String stake : stakeValue){
            sum+=Integer.parseInt(stake);
        }
        return sum;
    }

    public void fillInStakeFieldSingleBet(String stakeValue){
        typeText(STAKE_FIELD_SINGLE_BET,stakeValue);
    }

    public boolean isPriceSelectedFromUserPriceSingleBetMultiStake(String[] stakeValue, int previousPrice){
        return Integer.parseInt(getText(USER_PRICE).substring(0,getText(USER_PRICE).indexOf("."))) == previousPrice - sumOfStakes(stakeValue);
    }

    public void waitUntilPlaceBetButtonAppear(){
        waitUtils.waitUntilElementAppear(PLACE_BET_BUTTON);
    }

}
