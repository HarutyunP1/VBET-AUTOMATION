package dataproviders;

import org.testng.annotations.DataProvider;
import utilities.RandomUtils;

public class SignUpDataProvider {

    @DataProvider(name="warningIcons")
    public Object[][] dataForWarningIconsTest(){
        return new Object[][]
                {       {"","","",2},
                        { "", RandomUtils.generateRandomLetters(5) + "@betmail.com","Test1234",1},
                        {  RandomUtils.generateRandomLettersAndNumbers(8) + "S",RandomUtils.generateRandomLetters(5) + "@betmail.com","",1},
                };

    }

    @DataProvider(name="emailFieldValidation")
    public Object[][] dataForEmailFieldValidation(){
        return new Object[][]
                {       {RandomUtils.generateRandomLettersAndNumbers(8) + "S",RandomUtils.generateRandomLetters(5) + "betmail.com","Test1234",1},
                        {RandomUtils.generateRandomLettersAndNumbers(8) + "S", "@" + RandomUtils.generateRandomLetters(5) + ".com","Test1234",1},
                        {RandomUtils.generateRandomLettersAndNumbers(8) + "S",RandomUtils.generateRandomLetters(5) + "@" + ".com","Test1234",1},
                        {RandomUtils.generateRandomLettersAndNumbers(8) + "S",RandomUtils.generateRandomLetters(5) + "@betmail"  + "com","Test1234",1},
                        {RandomUtils.generateRandomLettersAndNumbers(8) + "S",RandomUtils.generateRandomLetters(5) + "@betmail" + ".","Test1234",1},
                };

    }

    @DataProvider(name="passwordFieldValidation")
    public Object[][] dataForPasswordFieldValidation(){
        return new Object[][]
                {       {RandomUtils.generateRandomLettersAndNumbers(8) + "S",RandomUtils.generateRandomLetters(5) + "@betmail.com","TestTest",1},
                        {RandomUtils.generateRandomLettersAndNumbers(8) + "S",RandomUtils.generateRandomLetters(5) + "@betmail.com","12345678",1},
                        {RandomUtils.generateRandomLettersAndNumbers(8) + "S",RandomUtils.generateRandomLetters(5) + "@betmail.com","test1234",1},
                        {RandomUtils.generateRandomLettersAndNumbers(8) + "S",RandomUtils.generateRandomLetters(5) + "@betmail.com","Test123",1},
                };

    }
}
