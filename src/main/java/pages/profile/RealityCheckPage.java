package pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utilities.WaitUtils;

public class RealityCheckPage extends BasePage {

    private final By LIMITS_TEXT = By.cssSelector("label[class='checkbox'] span");
    private final By LIMITS_CHECK_BOXES = By.cssSelector("input[class='ember-view']");
    private final By SAVE_REALITY_BUTTON = By.cssSelector("a[class='btn buttons1558357729029 ']");
    private final By REALITY_CHECK = By.cssSelector("div[class='tab-container clearfix'] div[data-tab='reality-check']");
    private String[] limitsValuesEn = {"no limit","10 mins","20 mins","30 mins","1 hour","2 hours","4 hours","6 hours","8 hours"};
    private String[] limitsValuesKa = {"ლიმიტის გარეშე","10 წუთი","20 წუთი","30 წუთი","1 საათი","2 საათი","4 საათი","6 საათი","8 საათი"};
    private String[] limitsValuesTr = {"limit yok","10 dk.","20 dk.","30 dk.","1 saat","2 saat","4 saat","6 saat","8 saat"};
    private String[] limitsValuesRu = {"Без лимитов","10 минут","20 минут","30 минут","1 ЧАСА","2 ЧАСА","4 ЧАСА","6 ЧАСА","8 ЧАСА"};

    public RealityCheckPage(WebDriver driver){
        super(driver);
    }

    public boolean checkLimitValues(String signInUrl){
        switch (signInUrl){
            case "https://www.vbet.com/#?sign-in":
                return getChooseLimitsLanguage(limitsValuesEn);
            case "https://www.vbet.com/ka/%E1%83%A1%E1%83%9E%E1%83%9D%E1%83%A0%E1%83%A2%E1%83%98-1#?sign-in":
                return getChooseLimitsLanguage(limitsValuesKa);
            case "https://www.vbet.com/tr/sporlar#?sign-in":
                return getChooseLimitsLanguage(limitsValuesTr);
            case "https://www.vbet.com/ru/sports#?sign-in":
                return getChooseLimitsLanguage(limitsValuesRu);
            default:
                return false;
        }
    }

    private boolean getChooseLimitsLanguage(String[] values){
        boolean bool = false;
        for (int i = 0;i < values.length;i++){
            if (getText(LIMITS_TEXT,i).equals(values[i])){
                bool = true;
            }else {
                bool = false;
                break;
            }
        }
        return bool;
    }

    public boolean isSaveButtonDisplayed(){
        return isElementDisplayed(SAVE_REALITY_BUTTON);
    }

    public boolean isAnHourChecked(){
        return getElements(LIMITS_CHECK_BOXES).get(4).isSelected();
    }

    public void waitUntilSaveRealityButtonAppear(){
        waitUtils.waitUntilElementAppear(SAVE_REALITY_BUTTON);
    }

    public void clickOnRealityCheck(){
        clickOnElement(REALITY_CHECK);
    }
}
