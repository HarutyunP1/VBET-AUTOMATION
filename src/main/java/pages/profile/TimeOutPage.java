package pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utilities.WaitUtils;

public class TimeOutPage extends BasePage {

    private final By CHOOSE_PERIOD_DROP_DOWN = By.name("self-exlusion");
    private final By SAVE_TIME_OUT_BUTTON = By.cssSelector("div[class='form-container'] a");
    private final By CHOOSE_PERIOD_DROP_DOWN_VALUES = By.cssSelector("select[name='self-exlusion'] option");
    private final By SB_ICON = By.cssSelector("span[class='icon-sb-info']");
    private final By TIME_OUT = By.cssSelector("div[class='tab-container clearfix'] div[data-tab='time-out']");
    private String[] choosePeriodValuesEn = {"1 day","1 week","2 weeks","6 weeks","1 month","2 months","1 year","2 years"};
    private String[] choosePeriodValuesKa = {"1 დღე","7 დღე","2 კვირა","6 კვირა","1 თვე","2 თვე","1 წელი","2 წელი"};
    private String[] choosePeriodValuesTr = {"1 Gün","7 Gün","2 Hafta","6 hafta","1 Ay","2 Ay","1 Yıl","2 Yıl"};
    private String[] choosePeriodValuesRu = {"1 день","1 неделю","2 недели","6 недель","1 месяц","2 месяца","1 год","2 года"};

    public TimeOutPage(WebDriver driver){
        super(driver);
    }

    public boolean checkChoosePeriodValues(String signInUrl){
        switch (signInUrl){
            case "https://www.vbet.com/#?sign-in":
                return getChoosePeriodLanguage(choosePeriodValuesEn);
            case "https://www.vbet.com/ka/%E1%83%A1%E1%83%9E%E1%83%9D%E1%83%A0%E1%83%A2%E1%83%98-1#?sign-in":
                return getChoosePeriodLanguage(choosePeriodValuesKa);
            case "https://www.vbet.com/tr/sporlar#?sign-in":
                return getChoosePeriodLanguage(choosePeriodValuesTr);
            case "https://www.vbet.com/ru/sports#?sign-in":
                return getChoosePeriodLanguage(choosePeriodValuesRu);
            default:
                return false;
        }
    }

    private boolean getChoosePeriodLanguage(String[] values){
        boolean bool = false;
        for (int i = 0;i < values.length;i++){
            if (getElements(CHOOSE_PERIOD_DROP_DOWN_VALUES).get(i+1).getText().equals(values[i])){
                bool = true;
            }else {
                bool = false;
                break;
            }
        }
        return bool;
    }

    public boolean isSaveSelfButtonDisabled(){
        return getAttribute(SAVE_TIME_OUT_BUTTON,"class").contains("disabled");
    }

    public void chooseSaveTimeOutDropDown(){
        selectByValue(CHOOSE_PERIOD_DROP_DOWN,"1");
    }

    public void waitUntilSbIconAppear(){
        waitUtils.waitUntilElementAppear(SB_ICON);
    }

    public void clickOnTimeOut(){
        clickOnElement(TIME_OUT);
    }
}
