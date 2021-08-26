package dataproviders;

import org.testng.annotations.DataProvider;

public class LogInNetDataProvider {


        @DataProvider(name="loginWithInvalidCredentials")
        public Object[][] dataForLoginWithInvalidCredentials(){
            return new Object[][]
                    {       {"invalidEmail@yopmail.com","InvalidPassword1111"},
                            {"testing789@yopmail.com","InvalidPassword1111"},
                            {"invalidEmail@yopmail.com","Test1111"},
                    };

        }

        @DataProvider(name="validationForErrorMessages")
        public Object[][] dataForVsalidationForErrorMessages(){
            return new Object[][]
                    {       {"","",2},
                            {"testing789@yopmail.com","",1},
                            {"","Test1111",1},
                    };

        }

        @DataProvider(name="signInCloseTest")
        public Object[][] dataForSignInCloseTest(){
            return new Object[][]
                    {       {"testing789@yopmail.com","Test1111"},
                            {"testing789@yopmail.com",""},
                            {"","Test1111"},
                    };

        }

}
