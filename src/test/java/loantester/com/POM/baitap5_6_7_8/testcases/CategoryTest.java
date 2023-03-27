package loantester.com.POM.baitap5_6_7_8.testcases;

import loantester.com.POM.baitap5_6_7_8.pages.CategoryPage;
import loantester.com.POM.baitap5_6_7_8.pages.DashboardPage;
import loantester.com.POM.baitap5_6_7_8.pages.LoginPage;
import loantester.com.common.BaseTest;
import org.testng.annotations.Test;

public class CategoryTest extends BaseTest {
    LoginPage loginpage;
    DashboardPage dashboardpage;
    CategoryPage categoryPage;


    @Test
    public void testAddCategory (){
        loginpage = new LoginPage(driver);

        loginpage.login("admin@example.com","123456");

        dashboardpage = new DashboardPage(driver);
        dashboardpage.verifyDashboardPage();
        dashboardpage.Verifyprofile();


        categoryPage = new CategoryPage();
        dashboardpage.openCategoryPage();

        categoryPage.AddCategory("AUTOTESST");

    }

}
