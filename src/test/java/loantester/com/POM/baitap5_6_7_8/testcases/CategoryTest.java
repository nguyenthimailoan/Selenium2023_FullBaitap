package loantester.com.POM.baitap5_6_7_8.testcases;

import loantester.com.POM.baitap5_6_7_8.pages.Category.CategoryDetailPage;
import loantester.com.POM.baitap5_6_7_8.pages.Category.CategoryPage;
import loantester.com.POM.baitap5_6_7_8.pages.Category.ViewCategoryPage;
import loantester.com.POM.baitap5_6_7_8.pages.DashboardPage;
import loantester.com.POM.baitap5_6_7_8.pages.LoginPage;
import loantester.com.common.BaseTest;
import loantester.com.keywords.WebUI;
import org.testng.annotations.Test;

public class CategoryTest extends BaseTest {
    LoginPage loginpage;
    DashboardPage dashboardpage;
    CategoryPage categoryPage;
    ViewCategoryPage viewcategorypage;
    CategoryDetailPage categorydetailpage;


    @Test
    public void testAddCategory() {
        loginpage = new LoginPage(driver);
        categoryPage = new CategoryPage(driver);

        dashboardpage = loginpage.login("admin@example.com", "123456");
        viewcategorypage = dashboardpage.openCategoryPage();
        viewcategorypage.verifyCategoryPage();

        viewcategorypage.clickAddNewCategoryButton();
        WebUI.sleep(10);

        String CATEGORY_NAME = "AUTOTEST1";
        categoryPage.AddNewCategory(CATEGORY_NAME);
        WebUI.sleep(10);
        // mở lại trang category
        //search giá trị category mới add
        viewcategorypage.searchCategory(CATEGORY_NAME);
        WebUI.sleep(10);
        //click giá trị category đầu tiên
        viewcategorypage.clickOnFirstRowCategoryName();
        WebUI.sleep(10);

        categorydetailpage = new CategoryDetailPage(driver);

       categorydetailpage.checkCategoryDetail("AUTOTEST1");



    }

}
