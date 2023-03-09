package loantester.com.baitap3;

import KeyWords.WebUI;
import loantester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BTAssert extends BaseTest {
    @Test(priority = 1)
    public void loginCMS () {
        System.out.println("Login");
        driver.get("https://cms.anhtester.com/login");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();


    }

    @Test (priority = 2)
    public void oppenCategory()  {
        WebUI.waitForPageLoaded(driver);
//        String product = driver.findElement(By.xpath("//span[normalize-space()='Products']")).getText();
//        Assert.assertEquals(product,"Products","It is not Product menu");
//        WebUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        WebUI.waitForPageLoaded(driver);
       // Thread.sleep(100);

//        String category = driver.findElement(By.xpath("//span[normalize-space()='Category']")).getText();
//        WebUI.waitForPageLoaded(driver);
//        Assert.assertEquals(category,"Category","It is not Category menu");
//        WebUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
      //  Thread.sleep(100);

//        String addCategory = driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).getText();
//        Assert.assertEquals(addCategory,"Add New category","It is not Add Category");
        WebUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();

        WebUI.waitForPageLoaded(driver);
    }

    @Test (priority = 3)
    public void addCategory(){
        WebUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Hoai nhi");
        WebUI.waitForPageLoaded(driver);

        driver.findElement(By.xpath("//label[normalize-space()='Parent Category']/following-sibling::div/div")).click();
        driver.findElement(By.xpath("//label[normalize-space()='Parent Category']/following-sibling::div/div//input")).sendKeys("Demo category 1",Keys.ENTER);
        driver.findElement(By.xpath("//label[normalize-space()='Parent Category']/following-sibling::div/div")).click();

//        driver.findElement(By.xpath("//label[normalize-space()='Type']/following-sibling::div/div")).click();
//        driver.findElement(By.xpath("//label[normalize-space()='Type']/following-sibling::div/div//span[.='Digital']")).click();

       driver.findElement(By.xpath("//label[.='Banner (200x200)']/following-sibling::div/div/div[.='Choose File']")).click();
        driver.findElement(By.xpath("//input[@class='form-control form-control-xs']")).sendKeys("Trathainguyen",Keys.ENTER);
        driver.findElement(By.xpath("//div[@title='Trathainguyen.jpg']/div[1]")).click();
        driver.findElement(By.xpath("//button[.='Add Files']")).click();
//        driver.findElement(By.xpath(""));
//        driver.findElement(By.xpath(""));



    }

}
