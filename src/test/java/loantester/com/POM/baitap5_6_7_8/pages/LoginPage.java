package loantester.com.POM.baitap5_6_7_8.pages;

import loantester.com.keywords.WebUI;
import static loantester.com.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    private String URL = "https://cms.anhtester.com/login";
    private String PAGETEXT = "Login";

    // Lưu Object của trang login
    // Dùng đối tượng By trong selenium để khai báo tên Object cùng giá trị Locator tương ứng

    By headerPage = By.xpath("//h1");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By ClickbuttonLogin = By.xpath("//button[@class='btn btn-primary btn-lg btn-block']");


    //Hàm xây dựng để truyền vào driver
    private WebDriver driver;

    public LoginPage(WebDriver _driver){
        driver = _driver;
        new WebUI(driver);
    }
    //Viết các hàm xử lý cho trang Login

    public void verifyHeaderPage(){
        Assert.assertEquals(getTextElement(headerPage),"Welcome to Active eCommerce CMS","FAIL.Header not match.");
    }
    public void enterEmail (String email){
        setText(inputEmail,email);
    }
    public void enterpassword(String password){
        setText(inputPassword,password);
    }
    public void clickOnbuttonLogin(){
        clickElement(ClickbuttonLogin);
    }

    public DashboardPage login(String email,String password){
        openURL(URL);
        verifyHeaderPage();
        enterEmail(email);
        enterpassword(password);
        clickOnbuttonLogin();
        return new DashboardPage(); //
    }
}
