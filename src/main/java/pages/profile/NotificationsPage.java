package pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class NotificationsPage extends BasePage {

    private final By NOTIFICATION_RADIO_BUTTONS_INPUT = By.cssSelector("label[class='checkbox']");
    private final By NOTIFICATION_RADIO_BUTTONS = By.cssSelector("label[class='checkbox'] input");
    private final By CONFIRM_BUTTON = By.cssSelector("div[class='btn buttons1558357729029  ']");
    private final By NOTIFICATION = By.cssSelector("div[class='tab-container clearfix'] div[data-tab='notifications']");
    private ArrayList<Integer> checkedRadios = new ArrayList<>();
    private List<WebElement> radioButtons;

    public NotificationsPage(WebDriver driver) {
        super(driver);
    }


    public boolean isInternalMessageRadioButtonSelected(){
        return isRadioButtonsChecked(NOTIFICATION_RADIO_BUTTONS,1);
    }

    public boolean pushNotificationRadioButtonSelected(){
        return isRadioButtonsChecked(NOTIFICATION_RADIO_BUTTONS,3);
    }

    public boolean emailRadioButtonSelected(){
        return isRadioButtonsChecked(NOTIFICATION_RADIO_BUTTONS,4);
    }

    public boolean smsRadioButtonSelected(){
        return isRadioButtonsChecked(NOTIFICATION_RADIO_BUTTONS,7);
    }

    public boolean isPhoneCallRadioButtonSelected(){
        return isRadioButtonsChecked(NOTIFICATION_RADIO_BUTTONS,9);
    }

    public void clickOnRadioButtons(){
        radioButtons = getElements(NOTIFICATION_RADIO_BUTTONS);
        for (int i = 0; i < radioButtons.size();i++){
            if (!isRadioButtonsChecked(NOTIFICATION_RADIO_BUTTONS,i)){
                getElements(NOTIFICATION_RADIO_BUTTONS_INPUT).get(i).click();
                checkedRadios.add(i);
                i++;
            }
        }
    }

    public boolean isRadioButtonsChecked(){
        radioButtons = getElements(NOTIFICATION_RADIO_BUTTONS);
        boolean bool = false;
        for (int i = 0;i < checkedRadios.size();i++){
            if (isRadioButtonsChecked(NOTIFICATION_RADIO_BUTTONS,checkedRadios.get(i))){
                bool = true;
            }else{
                bool = false;
                break;
            }
        }
        return bool;
    }

    public void clickOnConfirmButton(){
        clickOnElement(CONFIRM_BUTTON);
    }

    public void clickOnNotification(){
        clickOnElement(NOTIFICATION);
    }
}
