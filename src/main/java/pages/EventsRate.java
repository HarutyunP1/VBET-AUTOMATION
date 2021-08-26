package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class EventsRate  extends BasePage{

    private final By EVENTS_RATE_TEXT = By.cssSelector("div[class='events-list-container large live'] span[class='sb-game-bet-coeficiente']");
    private SportsPage sportsPage;
    private List<WebElement> eventsRate;
    private static ArrayList<String> eventsText = new ArrayList<>();


    public EventsRate(WebDriver driver) {
        super(driver);
        sportsPage = new SportsPage(driver);
    }

    public void getEventsRateText() {
        eventsRate = getElements(EVENTS_RATE_TEXT);
        for (int i = 0; i < eventsRate.size(); i++) {
            if (eventsRate.get(i).getAttribute("background-color").equals("#fecb5a")) {
                eventsText.add(eventsRate.get(i).getText());
            }
        }
    }

    public ArrayList getEventsText(){
        return eventsText;
    }

}