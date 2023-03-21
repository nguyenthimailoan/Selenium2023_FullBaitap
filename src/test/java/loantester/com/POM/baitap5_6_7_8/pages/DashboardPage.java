package loantester.com.POM.baitap5_6_7_8.pages;

import loantester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage {
    // datat trong nội bộ trang Dashboard
    private String PAGE_URL ="https://cms.anhtester.com/admin";

    //Các Object
    By titlleLogo = By.xpath("//span[normalize-space()='Admin Example']");
    By Profile = By.xpath("//span[normalize-space()='Profile']");
    By Logout = By.xpath("//span[normalize-space()='Logout']");

    // Hàm xây dựng
    private WebDriver driver;

    public DashboardPage(WebDriver _driver) {
        driver = _driver;
        new WebUI(driver);
    }
    public void verifyDashboardPage(){
        //kiểm tra URL chứa phần thuộc trang DB
        Assert.assertEquals(getCurrentUrl(),PAGE_URL,"URL chưa đúng trang Dashboard");
    }

    public void verifytitlelogo(){
        Assert.assertEquals(getTextElement(titlleLogo));

    }
}
