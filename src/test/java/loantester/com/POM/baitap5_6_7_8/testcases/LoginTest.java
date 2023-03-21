package loantester.com.POM.baitap5_6_7_8.testcases;

import loantester.com.POM.baitap5_6_7_8.pages.LoginPage;
import loantester.com.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginpage;

    @Test
    public void loginTestSuccess(){
        loginpage = new LoginPage(driver);
        loginpage.login("admin@example.com","123456");

    }

}
