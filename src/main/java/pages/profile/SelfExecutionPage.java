package pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utilities.WaitUtils;

public class SelfExecutionPage extends BasePage {

    private final By CHOOSE_PERIOD_DROP_DOWN_VALUES = By.cssSelector("select[name='self-exlusion'] option");
    private final By CHOOSE_PERIOD_DROP_DOWN= By.cssSelector("select[name='self-exlusion']");
    private final By SAVE_SELF_BUTTON = By.cssSelector("div[class='form-container'] a");
    private final By SELF_EXECUTION = By.cssSelector("div[class='tab-container clearfix'] div[data-tab = 'self-exclusion']");
    private String[] choosePeriodValuesEn = {"1 week","1 month","6 months","1 year","3 years","Infinite"};
    private String[] choosePeriodValuesKa = {"1 კვირა","1 თვე","6 თვე","1 წელი","3 წელი","უსასრულო"};
    private String[] choosePeriodValuesTr = {"1 hafta","1 Ay","6 Ay","1 Yıl","3 Yıl","Infinite"};
    private String[] choosePeriodValuesRu = {"1 неделю","1 месяц","6 месяцев","1 год","3 года","Без лимитов"};

    public SelfExecutionPage(WebDriver driver){
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
        return getAttribute(SAVE_SELF_BUTTON,"class").contains("disabled");
    }

    public void chooseSaveSelfDropDown(){
        selectByValue(CHOOSE_PERIOD_DROP_DOWN,"1");
    }

    public void waitUntilSaveSelfButtonAppear(){
        waitUtils.waitUntilElementAppear(SAVE_SELF_BUTTON);
    }

    public void clickOnSelfExecution(){
        clickOnElement(SELF_EXECUTION);
    }
}
