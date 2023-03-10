package loantester.com.baitap3;

import KeyWords.WebUI;
import loantester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BTAssert extends BaseTest {
    private String CUSTOMER_NAME ="COMPANY_ABC11";
    private String EDITCUSTOMER_NAME = "VNTPT11";
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
        String product = driver.findElement(By.xpath("//span[normalize-space()='Products']")).getText();
        Assert.assertEquals(product,"Products","It is not Product menu");
        WebUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(1);

//        String category = driver.findElement(By.xpath("//span[normalize-space()='Category']")).getText();
//        WebUI.waitForPageLoaded(driver);
//        Assert.assertEquals(category,"Category","It is not Category menu");
//        WebUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        WebUI.sleep(1);

        String addCategory = driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).getText();
        Assert.assertEquals(addCategory,"Add New category","It is not Add Category");
        WebUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();

        WebUI.waitForPageLoaded(driver);
    }



    @Test (priority = 3)
    public void addCategory(){
        WebUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(CUSTOMER_NAME);
        WebUI.waitForPageLoaded(driver);

        driver.findElement(By.xpath("//label[normalize-space()='Parent Category']/following-sibling::div/div")).click();
        driver.findElement(By.xpath("//label[normalize-space()='Parent Category']/following-sibling::div/div//input")).sendKeys("Demo category 1",Keys.ENTER);
     //   driver.findElement(By.xpath("//label[normalize-space()='Parent Category']/following-sibling::div/div")).click();
        WebUI.sleep(1);

        //tr?????ng Ordering Number
        driver.findElement(By.xpath("//input[@id='order_level']")).sendKeys("012345");
        WebUI.sleep(1);
        //tr?????ng type
        driver.findElement(By.xpath("//button[@title='Physical']")).click();
        driver.findElement(By.xpath("//span[.='Digital']")).click();
        WebUI.sleep(1);

    // Tr?????ng Banner
       driver.findElement(By.xpath("//label[.='Banner (200x200)']/following-sibling::div/div[contains(.,'Choose File')]")).click();
        WebUI.sleep(1);
        driver.findElement(By.xpath("//input[@name='aiz-uploader-search']")).sendKeys("Trathainguyen",Keys.ENTER);
        WebUI.sleep(1);
        driver.findElement(By.xpath("//img[@class='img-fit']")).click();
        WebUI.sleep(1);
        driver.findElement(By.xpath("//button[.='Add Files']")).click();
        WebUI.sleep(1);


        //Srcoll v??? cu???i trang
        Actions action = new Actions(driver);

        WebUI.sleep(1);
        action.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
        WebUI.sleep(1);

    //Tr?????ng icon
//        driver.findElement(By.xpath("//label[.='Icon (32x32)']/following-sibling::div")).click();
//        WebUI.sleep(1);
//        driver.findElement(By.xpath("//input[@name='aiz-uploader-search']")).sendKeys("Trathainguyen",Keys.ENTER);
//        WebUI.sleep(1);
//        driver.findElement(By.xpath("//img[@class='img-fit']")).click();
//        WebUI.sleep(1);
//        driver.findElement(By.xpath("//button[.='Add Files']")).click();
//        WebUI.sleep(1);

        //tr?????ng Meta Title
        driver.findElement(By.xpath("//input[@name='meta_title']")).sendKeys("01920121");
        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys("test abc12345667gggvvvvddd");
        WebUI.sleep(1);
        driver.findElement(By.xpath("//label[normalize-space()='Filtering Attributes']/following-sibling::div/div")).click();
        driver.findElement(By.xpath("//label[normalize-space()='Filtering Attributes']/following-sibling::div//input")).sendKeys("Size", Keys.ENTER);
        driver.findElement(By.xpath("//label[normalize-space()='Filtering Attributes']/following-sibling::div/div")).click();
        WebUI.sleep(1);

        driver.findElement(By.xpath("//button[.='Save']")).click();




    }
    @Test(priority = 4)
    public void ktCategory (){
        //T??m ki???m ???? add
        WebUI.sleep(1);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(CUSTOMER_NAME,Keys.ENTER);
        WebUI.sleep(1);

        String categoryItem = driver.findElement(By.xpath("//tbody/tr[2]/td[2]")).getText();
        System.out.println("Get category item:" +categoryItem);
        Assert.assertEquals(categoryItem,CUSTOMER_NAME, "Name kh??ng ????ng");

        WebUI.sleep(1);
        driver.findElement(By.xpath("//tbody/tr[2]/td[10]/a[1]")).click();

        String getCategoryInDetail = driver.findElement(By.xpath("//input[@id='name']")).getAttribute("value");
        System.out.println("Categoryname detail:" +getCategoryInDetail);
        Assert.assertEquals(getCategoryInDetail,CUSTOMER_NAME,"FAILED. Category not match.");
        WebUI.sleep(1);

        //edit
        driver.findElement(By.xpath("//input[@id='name']")).clear();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(EDITCUSTOMER_NAME);
        driver.findElement(By.xpath("//button[.='Save']")).click();
        // ki???m tra l???i ph???n ???? edit
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        WebUI.sleep(1);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(EDITCUSTOMER_NAME,Keys.ENTER);
        WebUI.sleep(1);


    }

}
