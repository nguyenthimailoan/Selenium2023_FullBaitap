package loantester.com.POM.baitap5_6_7_8.testcases;

import loantester.com.POM.baitap5_6_7_8.pages.DashboardPage;
import loantester.com.POM.baitap5_6_7_8.pages.LoginPage;
import loantester.com.POM.baitap5_6_7_8.pages.ProfileDanshboardDetailPage;
import loantester.com.common.BaseTest;
import org.testng.annotations.Test;

public class ProfileDashboardDetailTest extends BaseTest {
    LoginPage loginpage;
    DashboardPage dashboardpage;
    ProfileDanshboardDetailPage profiledashboarddetailpage;


    @Test
    public void VerifyProfileDetail(){
        loginpage = new LoginPage(driver);
        loginpage.login("admin@example.com","123456");

        dashboardpage = new DashboardPage(driver);
        dashboardpage.verifyDashboardPage();
        dashboardpage.Verifyprofile();

        profiledashboarddetailpage = new ProfileDanshboardDetailPage(driver);
        profiledashboarddetailpage.checkProfileDetail();



    }

}
