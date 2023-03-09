package loantester.com.baitap3;

import KeyWords.WebUI;
import loantester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
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
    public void oppenCategory() {
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

        private String CUSTOMER_NAME ="VODAPLAY.COM";


    @Test (priority = 3)
    public void addCategory(){
        WebUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(CUSTOMER_NAME);
        WebUI.waitForPageLoaded(driver);

        driver.findElement(By.xpath("//label[normalize-space()='Parent Category']/following-sibling::div/div")).click();
        driver.findElement(By.xpath("//label[normalize-space()='Parent Category']/following-sibling::div/div//input")).sendKeys("Demo category 1",Keys.ENTER);
     //   driver.findElement(By.xpath("//label[normalize-space()='Parent Category']/following-sibling::div/div")).click();
        WebUI.sleep(1);

        //trường Ordering Number
        driver.findElement(By.xpath("//input[@id='order_level']")).sendKeys("012345");
        WebUI.sleep(1);
        //trường type
        driver.findElement(By.xpath("//button[@title='Physical']")).click();
        driver.findElement(By.xpath("//span[.='Digital']")).click();
        WebUI.sleep(1);

    // Trường Banner
       driver.findElement(By.xpath("//label[.='Banner (200x200)']/following-sibling::div/div[contains(.,'Choose File')]")).click();
        WebUI.sleep(1);
        driver.findElement(By.xpath("//input[@name='aiz-uploader-search']")).sendKeys("Trathainguyen",Keys.ENTER);
        WebUI.sleep(1);
        driver.findElement(By.xpath("//img[@class='img-fit']")).click();
        WebUI.sleep(1);
        driver.findElement(By.xpath("//button[.='Add Files']")).click();
        WebUI.sleep(1);


        //Srcoll về cuối trang
        Actions action = new Actions(driver);

        WebUI.sleep(1);
        action.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
        WebUI.sleep(1);

    //Trường icon
//        driver.findElement(By.xpath("//label[.='Icon (32x32)']/following-sibling::div")).click();
//        WebUI.sleep(1);
//        driver.findElement(By.xpath("//input[@name='aiz-uploader-search']")).sendKeys("Trathainguyen",Keys.ENTER);
//        WebUI.sleep(1);
//        driver.findElement(By.xpath("//img[@class='img-fit']")).click();
//        WebUI.sleep(1);
//        driver.findElement(By.xpath("//button[.='Add Files']")).click();
//        WebUI.sleep(1);

        //trường Meta Title
        driver.findElement(By.xpath("//input[@name='meta_title']")).sendKeys("01920121");
        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys("test abc12345667gggvvvvddd");
        WebUI.sleep(1);
        driver.findElement(By.xpath("//label[normalize-space()='Filtering Attributes']/following-sibling::div/div")).click();
        driver.findElement(By.xpath("//label[normalize-space()='Filtering Attributes']/following-sibling::div//input")).sendKeys("Size", Keys.ENTER);
        driver.findElement(By.xpath("//label[normalize-space()='Filtering Attributes']/following-sibling::div/div")).click();
        WebUI.sleep(1);

        driver.findElement(By.xpath("//button[.='Save']")).click();

        //Tìm kiếm đã add
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(CUSTOMER_NAME,Keys.ENTER);
        WebUI.sleep(1);

        String categoryItem = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
        System.out.println("Get category item:" +categoryItem);
        Assert.assertEquals(categoryItem,CUSTOMER_NAME);

        WebUI.sleep(1);
        driver.findElement(By.xpath("//tbody/tr[1]/td[10]/a[1]")).click();

        String getCategoryInDetail = driver.findElement(By.xpath("//input[@id='name']")).getAttribute("value");
        System.out.println("Categoryname detail:" +getCategoryInDetail);
        Assert.assertEquals(getCategoryInDetail,CUSTOMER_NAME,"FAILED. Category not match.");




    }

}
