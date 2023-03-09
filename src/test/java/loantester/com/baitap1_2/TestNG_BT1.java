package loantester.com.baitap1_2;

import KeyWords.WebUI;
import loantester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_BT1 extends BaseTest {

    @Test(priority=1)
    public void loginCMS (){
        System.out.println("Login");
        driver.get("https://demo.activeitzone.com/ecommerce/login");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        WebUI.sleep(2);
    }

    @Test(priority=2)
    public void addNewCategory() {
        System.out.println("Add Category");
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();
        WebUI.sleep(2);

        //trường name
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Category_2811A1");
        WebUI.sleep(1);

        //trường Parent
        driver.findElement(By.xpath("//label[normalize-space()='Parent Category']/following-sibling::div/div")).click();
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Computer", Keys.ENTER);
        WebUI.sleep(1);

        //trường ordering
        driver.findElement(By.xpath("//input[@id='order_level']")).sendKeys("88833");
        WebUI.sleep(1);
        //trường type
        driver.findElement(By.xpath("//button[@title='Physical']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Digital']")).click();
        WebUI.sleep(1);

        //trường Banner
        driver.findElement(By.xpath("//label[normalize-space()='Banner (200x200)']/following-sibling::div")).click();
        WebUI.sleep(4);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("Selenium", Keys.ENTER);
        WebUI.sleep(2);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("4");

        WebUI.sleep(2);
        driver.findElement(By.xpath("//img[@class='img-fit']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        WebUI.sleep(1);

        //Srcoll về cuối trang
        Actions action = new Actions(driver);

        WebUI.sleep(1);
        action.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
        WebUI.sleep(1);


        //trường icon
//        driver.findElement(By.xpath("(//div[@class='form-control file-amount'])[2]")).click();
//        driver.findElement(By.xpath("//input[@name='aiz-uploader-search']")).sendKeys("car",Keys.ENTER);
//        WebUI.sleep(5);
//        driver.findElement(By.xpath("(//div[@class='card-file-thumb']//img)[1]")).click();
//        WebUI.sleep(5);
//        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
//        WebUI.sleep(5);

         //trường Meta title
        driver.findElement(By.xpath("//input[@placeholder='Meta Title']")).sendKeys("Category_2811A1");
        //trường Meta description
        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys("Category_2811A1");
        //trường filtering Attributes
        driver.findElement(By.xpath("//div[contains(text(),'Nothing selected')]")).click();
        WebUI.sleep(1);
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Size", Keys.ENTER);
        WebUI.sleep(1);
        //Button Lưu
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        WebUI.sleep(2);

        // tìm kiếm name đã add
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Category_2811A1", Keys.ENTER);
        WebUI.sleep(2);

        String categoryItem = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
        System.out.println("Get Category Item: " + categoryItem);
        Assert.assertEquals(categoryItem, "Category_2811A2");

        WebUI.sleep(1);



    }

}

