package loantester.com.baitap3;

import KeyWords.WebUI;
import loantester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BTAssert extends BaseTest {
    @Test
    public void loginCMS () {
        System.out.println("Login");
        driver.get("https://cms.anhtester.com/login");

        String tittle = driver.getTitle();
        Assert.assertEquals(tittle,"Active eCommerce CMS | Anh Tester Demo","Không phải trang login");

       String titleLogin = driver.findElement(By.xpath("//p[.='Login to your account.']")).getText();
       Assert.assertEquals(titleLogin,"Login to your account.","Không phải trang login");

       boolean pass = driver.findElement(By.id("email")).isEnabled();
        Assert.assertTrue(pass,"Không nhập được password");
        driver.findElement(By.name("password")).sendKeys("123456");

        boolean loginButton = driver.findElement(By.id("email")).isEnabled();
        Assert.assertTrue(loginButton,"Login button is inactive");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();


    }

    @Test
    public void oppenCategory()  {
        WebUI.waitForPageLoaded(driver);
        String product = driver.findElement(By.xpath("//span[normalize-space()='Products']")).getText();
        Assert.assertEquals(product,"Products","It is not Product menu");
        WebUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        WebUI.waitForPageLoaded(driver);
       // Thread.sleep(100);

        String category = driver.findElement(By.xpath("//span[normalize-space()='Category']")).getText();
        WebUI.waitForPageLoaded(driver);
        Assert.assertEquals(category,"Category","It is not Category menu");
        WebUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
      //  Thread.sleep(100);

        String addCategory = driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).getText();
        Assert.assertEquals(addCategory,"Add New category","It is not Add Category");
        WebUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();

        WebUI.waitForPageLoaded(driver);
    }

    @Test
    public void addCategory(){
        WebUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Hoai nhi");
        driver.findElement(By.xpath("//label[normalize-space()='Parent Category']/following-sibling::div//button"));
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input")).sendKeys("Pie");
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input")).sendKeys(Keys.ENTER);
//        driver.findElement(By.xpath(""));
//        driver.findElement(By.xpath(""));
//        driver.findElement(By.xpath(""));
//        driver.findElement(By.xpath(""));
//        driver.findElement(By.xpath(""));
//        driver.findElement(By.xpath(""));
//        driver.findElement(By.xpath(""));
//        driver.findElement(By.xpath(""));



    }

}
