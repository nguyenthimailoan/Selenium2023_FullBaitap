package loantester.com.POM.baitap5_6_7_8.pages;

import loantester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static loantester.com.keywords.WebUI.getAttributeElement;

public class ProfileDanshboardDetailPage {

    By Name = By.xpath("//input[@value='Admin Example']");
    By Email = By.xpath("//input[@name='email']");
    By Newpassword = By.xpath("//input[@name='new_password']");
    By Confirmpassword = By.xpath("//input[@name='confirm_password']");

    By Avatarinput = By.xpath("//div[normalize-space()='1 File selected']");
    By AvatarSearch = By.xpath("//input[@name='aiz-uploader-search']");
    By Selectimg = By.xpath("(//img[@class='img-fit'][1])[2]");

    // Hàm xây dựng
    private WebDriver driver;

    public ProfileDanshboardDetailPage(WebDriver _driver) {
        driver = _driver;
        new WebUI(driver);
    }

    public void checkProfileDetail (){
        WebUI.waitForPageLoaded();
        System.out.println(getAttributeElement(Name,"value"));
        System.out.println(getAttributeElement(Email,"value"));
//        System.out.println(getAttributeElement(Newpassword,"placeholder"));
//        System.out.println(getAttributeElement(Confirmpassword,"placeholder"));

        //Kiểm tra thì phải dùng Assert
        //phải dùng Equals chứ không nên dùng Contains vì giá trị phải đúng chính xác
        Assert.assertEquals(getAttributeElement(Name,"value"),"Admin Example","Name not match.");
        Assert.assertEquals(getAttributeElement(Email,"value"),"admin@example.com","Email not match.");
//        Assert.assertEquals(getAttributeElement(Newpassword,"placeholder"),"confirm password","New password not match.");
//       Assert.assertEquals(getAttributeElement(Confirmpassword,"placeholder"),"Confirmpassword","Confirmpassword not match.");

    }

}
