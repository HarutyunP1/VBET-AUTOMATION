package dataproviders;

import org.testng.annotations.DataProvider;
import utilities.RandomUtils;

public class SignUpNetDataProvider {

    @DataProvider(name="missingFieldsOnFirstStep")
    public Object[][] dataForMissingFieldsOnFirstStep(){
        return new Object[][]
                {       {"","","","",3},
                        {"","Test1234","Test1234","1234",1},
                        {RandomUtils.generateRandomLetters(5) + "@betmail.com","","Test1234","1234",2},
                        {RandomUtils.generateRandomLetters(5) + "@betmail.com","Test1234","","1234",1},
                };

    }

    @DataProvider(name="missingFieldsOnSecondStep")
    public Object[][] dataForMissingFieldsOnSecondStep(){
        return new Object[][]
                {       {"","","","","","","","","","","","","","",17,false,false,false,false,false},
                        {"","TestLast",RandomUtils.generateRandomLettersAndNumbers(8) + "S", "1995","4","12","DE","Yerevan","Address","1234","8963648018","1000","5000","10000",1,true,true,true,true,true},
                        {"TestFirst","TestLast","", "1995","4","12","DE","Yerevan","Address","1234","8963648018","1000","5000","10000",1,true,true,true,true,true},
                        {"TestFirst","TestLast",RandomUtils.generateRandomLettersAndNumbers(8) + "S","","","","DE","Yerevan","Address","1234","8963648018","1000","5000","10000",1,true,true,true,true,true},
                        {"TestFirst","TestLast",RandomUtils.generateRandomLettersAndNumbers(8) + "S","1995","4","12","DE","","Address","1234","8963648018","1000","5000","10000",1,true,true,true,true,true},
                        {"TestFirst","TestLast",RandomUtils.generateRandomLettersAndNumbers(8) + "S","1995","4","12","DE","Yerevan","","1234","8963648018","1000","5000","10000",1,true,true,true,true,true},
                        {"TestFirst","TestLast",RandomUtils.generateRandomLettersAndNumbers(8) + "S","1995","4","12","DE","Yerevan","Address","1234","","1000","5000","10000",1,true,true,true,true,true},
                        {"TestFirst","TestLast",RandomUtils.generateRandomLettersAndNumbers(8) + "S","1995","4","12","DE","Yerevan","Address","1234","8963648018","","5000","10000",1,true,true,true,true,true},
                        {"TestFirst","TestLast",RandomUtils.generateRandomLettersAndNumbers(8) + "S","1995","4","12","DE","Yerevan","Address","1234","8963648018","1000","","10000",1,true,true,true,true,true},
                        {"TestFirst","TestLast",RandomUtils.generateRandomLettersAndNumbers(8) + "S","1995","4","12","DE","Yerevan","Address","1234","8963648018","1000","5000","",1,true,true,true,true,true},
                        {"TestFirst","TestLast",RandomUtils.generateRandomLettersAndNumbers(8) + "S","1995","4","12","DE","Yerevan","Address","1234","8963648018","1000","5000","10000",1,false,true,true,true,true},
                        {"TestFirst","TestLast",RandomUtils.generateRandomLettersAndNumbers(8) + "S","1995","4","12","DE","Yerevan","Address","1234","8963648018","1000","5000","10000",1,true,false,true,true,true},
                        {"TestFirst","TestLast",RandomUtils.generateRandomLettersAndNumbers(8) + "S","1995","4","12","DE","Yerevan","Address","1234","8963648018","1000","5000","10000",1,true,true,false,true,true},
                        {"TestFirst","TestLast",RandomUtils.generateRandomLettersAndNumbers(8) + "S","1995","4","12","DE","Yerevan","Address","1234","8963648018","1000","5000","10000",1,true,true,true,false,true},
                        {"TestFirst","TestLast",RandomUtils.generateRandomLettersAndNumbers(8) + "S","1995","4","12","DE","Yerevan","Address","1234","8963648018","1000","5000","10000",1,true,true,true,true,false},

                };

    }

    @DataProvider(name="registerWithInvalidEmail")
    public Object[][] dataRegisterWithInvalidEmail(){
        return new Object[][]
                {       {RandomUtils.generateRandomLetters(6) + ".com"},
                        {"@" + RandomUtils.generateRandomLetters(6) + ".com"},
                        {RandomUtils.generateRandomLetters(6) + "@.com"},
                        {RandomUtils.generateRandomLetters(6) + "com"},
                };

    }

    @DataProvider(name="passwordValidation")
    public Object[][] dataPasswordValidation(){
        return new Object[][]
                {       {"testingg"},
                        {"12345678"},
                        {"test1234"},
                        {"TEST1234"},
                        {"Test123"},
                };

    }

}
