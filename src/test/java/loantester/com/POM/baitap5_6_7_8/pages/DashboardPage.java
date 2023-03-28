package loantester.com.POM.baitap5_6_7_8.pages;

import loantester.com.POM.baitap5_6_7_8.pages.Category.CategoryPage;
import loantester.com.POM.baitap5_6_7_8.pages.Category.ViewCategoryPage;
import loantester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static loantester.com.keywords.WebUI.*;

public class DashboardPage {
    // datat trong nội bộ trang Dashboard
    private String PAGE_URL ="https://cms.anhtester.com/admin";

    //Các Object

    public By ProductMenu = By.xpath("//span[.='Products']");
    public By CategoryMenu = By.xpath("//span[.='Category']");
    By titlleLogo = By.xpath("//span[normalize-space()='Admin Example']");
    By Profile = By.xpath("//span[normalize-space()='Profile']");
    By detailProfile = By.xpath("//h5");
    By Logout = By.xpath("//span[normalize-space()='Logout']");
    By Clicklogout = By.xpath("//h1[.='Welcome to Active eCommerce CMS']");

    // Hàm xây dựng
    private WebDriver driver;

    public DashboardPage(WebDriver _driver) {
        driver = _driver;
        new WebUI(driver);
    }
    public void verifyDashboardPage(){
        //kiểm tra URL chứa phần thuộc trang DB
        Assert.assertEquals(getCurrentUrl(),PAGE_URL,"URL chưa đúng trang Dashboard");
        Assert.assertTrue(checkElementExist(titlleLogo),"Dashboard option not existing");
        clickElement(titlleLogo);

    }

    public ViewCategoryPage openCategoryPage(){
        waitForPageLoaded();
        clickElement(ProductMenu);
        clickElement(CategoryMenu);
 //       clickElement(addNewCategoryButton);
        return new ViewCategoryPage(driver);

    }

  public void Verifyprofile(){
        clickElement(Profile);
        Assert.assertEquals(getTextElement(detailProfile),"Profile","Header profile not match");
  }
//    public void verifyLogout(){
//        clickElement(Logout);
//        Assert.assertEquals(getTextElement(Clicklogout),"Welcome to Active eCommerce CMS","title logout is not match");
//
//    }
}
