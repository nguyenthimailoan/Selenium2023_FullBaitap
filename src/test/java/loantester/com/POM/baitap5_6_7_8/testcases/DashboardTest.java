package loantester.com.POM.baitap5_6_7_8.testcases;

import loantester.com.POM.baitap5_6_7_8.pages.Category.CategoryPage;
import loantester.com.POM.baitap5_6_7_8.pages.Category.ViewCategoryPage;
import loantester.com.POM.baitap5_6_7_8.pages.DashboardPage;
import loantester.com.POM.baitap5_6_7_8.pages.LoginPage;
import loantester.com.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    LoginPage loginpage;
    DashboardPage dashboardpage;

    ViewCategoryPage viewCategoryPage;

    @Test
    public void testOpenMenuOnDashboard(){
        loginpage = new LoginPage(driver);

      dashboardpage= loginpage.login("admin@example.com","123456");


        dashboardpage.verifyDashboardPage();
        dashboardpage.Verifyprofile();
        viewCategoryPage=dashboardpage.openCategoryPage();
        viewCategoryPage.verifyCategoryPage();


     //   dashboardpage.verifyLogout();



    }

}
