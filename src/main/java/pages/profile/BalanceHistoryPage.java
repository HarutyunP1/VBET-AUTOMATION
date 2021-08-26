package pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utilities.WaitUtils;

public class BalanceHistoryPage extends BasePage {

    private final By ALL_AREAS = By.cssSelector("div[class='tab-inner-container clearfix'] div");
    private final By RANGE_DATE = By.cssSelector("input[class='hasDatepicker']");
    private final By TYPE_DROP_DOWN = By.cssSelector("div[class='styled-dropdown balance-history'] select");
    private final By NO_RECORD_MESSAGE = By.cssSelector("div[class='no-record-found'] span");
    private final By NO_RECORD_ICON = By.cssSelector("div[class='sb-icon icon-sb-no-record']");

    public BalanceHistoryPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAllArea(){
        clickOnElement(ALL_AREAS,0);
    }

    public void clickOnSportsBookArea(){
        clickOnElement(ALL_AREAS,1);
    }

    public void clickOnCasinoArea(){
        clickOnElement(ALL_AREAS,2);
    }

    public boolean isAllAreaSelected(){
        return getElements(ALL_AREAS).get(0).getAttribute("class").contains("selected");
    }

    public boolean isSportsBookAreaSelected(){
        return getElements(ALL_AREAS).get(1).getAttribute("class").contains("selected");
    }

    public boolean isCasinoAreaSelected(){
        return getElements(ALL_AREAS).get(2).getAttribute("class").contains("selected");
    }

    public boolean isTypeDropDownDisplayed(){
        return isElementDisplayed(TYPE_DROP_DOWN);
    }

    public boolean isRangeStartDateDisplayed(){
        return isElementsDisplayed(RANGE_DATE,0);
    }

    public boolean isRangeEndDateDisplayed(){
        return isElementsDisplayed(RANGE_DATE,1);
    }

    public boolean isNorRecordMessageDisplayed(){
        return isElementDisplayed(NO_RECORD_MESSAGE);
    }

    public void waitUntilNoRecordIconDisplayed(){
        waitUtils.waitUntilElementAppear(NO_RECORD_ICON);
    }
}
