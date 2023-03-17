package loantester.com.baitap4;

import loantester.com.keywords.WebUI;
import loantester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class BtActionRobot extends BaseTest {
    private String ProductName = "Loantester";

    @Test(priority = 1)
    public void loginCMS () {
        System.out.println("Login");
        driver.get("https://cms.anhtester.com/login");
        WebUI.sleep(1);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        WebUI.sleep(1);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        WebUI.sleep(1);


    }
    @Test(priority = 2)
    public void ClickProductsMenu(){
     //   WebUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        WebUI.sleep(1);
        driver.findElement(By.xpath("//span[normalize-space()='Add New Product']")).click();
        WebUI.sleep(1);


    }
    @Test(priority = 3)
    public void AddNewProductInformation (){
     //   WebUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath("//input[@placeholder='Product Name']")).sendKeys(ProductName);
        WebUI.sleep(5);
        driver.findElement(By.xpath("//label[.='Category *']/following-sibling::div/div")).click();
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']/div/input[@class='form-control']")).sendKeys("PROTEL", Keys.ENTER);
        WebUI.sleep(5);
        //trường Brand
        driver.findElement(By.xpath("//label[normalize-space()='Brand']/following-sibling::div/div")).click();
        WebUI.sleep(5);
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']/div/input")).sendKeys("Pie",Keys.ENTER);
        WebUI.sleep(5);
        //trường Unit
        driver.findElement(By.xpath("//input[@placeholder='Unit (e.g. KG, Pc etc)']")).sendKeys("KG");
        WebUI.sleep(5);
        //trường Weight
        driver.findElement(By.xpath("//input[@placeholder='0.00']")).clear();
        WebUI.sleep(5);
        driver.findElement(By.xpath("//input[@placeholder='0.00']")).sendKeys("100");
        WebUI.sleep(10);
        //trường Minium
        driver.findElement(By.xpath("//input[@name='min_qty']")).clear();
        WebUI.sleep(10);
        driver.findElement(By.xpath("//input[@name='min_qty']")).sendKeys("200");
        WebUI.sleep(10);
        //trường Tags
        driver.findElement(By.xpath("//label[contains(text(),'Tags')]/following-sibling::div//tags")).sendKeys("TagsTest",Keys.ENTER);
        WebUI.sleep(10);

    }

}
