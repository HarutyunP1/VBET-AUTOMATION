package pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utilities.WaitUtils;

public class DocumentsPage extends BasePage {

    private final By BANK_SKIP_DROP_DOWN = By.cssSelector("div[class='btn-select'] select option");
    private final By CHOOSE_FILE = By.id("passportImage");
    private String[] bankSlipValuesEn = {"Bank Slip","Identity Document","Passport","Driver's License","IBAN","Social ID","Other"};
    private String[] bankSlipValuesKa = {"საბანკო ქვითარი","საბუთი","პასპორტი","მართვის მოწმობა","IBAN","სოციალური ბარათის ID","სხვა"};
    private String[] bankSlipValuesTr = {"Banka Fişi","Belge","Pasaport","Sürücü Belgesi","IBAN","Sosyal Kart Id ' si","Diğer"};
    private String[] bankSlipValuesRu = {"Банковская квитанция","Удостоверение личности","Паспорт","Водительские права","IBAN","ID социальной карты","Другое"};

    public DocumentsPage(WebDriver driver){
        super(driver);
    }

    public boolean checkBankSlipsValues(String signInUrl){
        switch (signInUrl){
            case "https://www.vbet.com/#?sign-in":
                return getBankSlipLanguage(bankSlipValuesEn);
            case "https://www.vbet.com/ka/%E1%83%A1%E1%83%9E%E1%83%9D%E1%83%A0%E1%83%A2%E1%83%98-1#?sign-in":
                return getBankSlipLanguage(bankSlipValuesKa);
            case "https://www.vbet.com/tr/sporlar#?sign-in":
                return getBankSlipLanguage(bankSlipValuesTr);
            case "https://www.vbet.com/ru/sports#?sign-in":
                return getBankSlipLanguage(bankSlipValuesRu);
            default:
                return false;
        }
    }

    public boolean isChooseFileTypeFile(){
        return getAttribute(CHOOSE_FILE,"type").equals("file");
    }

    public void waitUntilChooseFileButtonAppear(){
        waitUtils.waitUntilElementAppear(CHOOSE_FILE);
    }

    private boolean getBankSlipLanguage(String[] values){
        boolean bool = false;
        for (int i = 0;i < values.length;i++){
            if (getElements(BANK_SKIP_DROP_DOWN).get(i).getText().equals(values[i])){
                bool = true;
            }else {
                bool = false;
                break;
            }
        }
        return bool;
    }

}
