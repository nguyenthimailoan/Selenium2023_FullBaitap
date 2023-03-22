package loantester.com.POM.baitap5_6_7_8.testcases;

import loantester.com.POM.baitap5_6_7_8.pages.DashboardPage;
import loantester.com.POM.baitap5_6_7_8.pages.LoginPage;
import loantester.com.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    LoginPage loginpage;
    DashboardPage dashboardpage;

    @Test
    public void testOpenMenuOnDashboard(){
        loginpage = new LoginPage(driver);

       loginpage.login("admin@example.com","123456");

        dashboardpage = new DashboardPage(driver);
        dashboardpage.verifyDashboardPage();
        dashboardpage.Verifyprofile();
     //   dashboardpage.verifyLogout();



    }

}
