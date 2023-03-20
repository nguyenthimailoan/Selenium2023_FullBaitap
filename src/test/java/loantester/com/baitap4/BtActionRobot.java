package loantester.com.baitap4;

import loantester.com.keywords.WebUI;
import loantester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

    @Test(priority = 4)
    public void AddProductShipConf() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        Boolean stockText = driver.findElement(By.xpath("//label[normalize-space()='Flat Rate']//following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0']")).isSelected();
        if (stockText == false) {
            softAssert.assertTrue(stockText, "Flat Rate option is inactive");
            driver.findElement(By.xpath("//label[normalize-space()='Flat Rate']/following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0']")).click();
            Thread.sleep(1000);

            Boolean shipCost = driver.findElement(By.xpath("//input[@placeholder='Shipping cost']")).isEnabled();
            softAssert.assertTrue(shipCost, "Shipping cost field is inactive");
            driver.findElement(By.xpath("//input[@placeholder='Shipping cost']")).clear();
            driver.findElement(By.xpath("//input[@placeholder='Shipping cost']")).sendKeys("$60");
            Thread.sleep(1000);
        }

        Boolean quantityMul = driver.findElement(By.xpath("//label[normalize-space()='Is Product Quantity Mulitiply']/following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0']")).isSelected();
        if (quantityMul == false) {
            softAssert.assertTrue(quantityMul, "Status of Today Deal option is inactive");
            driver.findElement(By.xpath("//label[normalize-space()='Is Product Quantity Mulitiply']/following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0']")).click();
            Thread.sleep(2000);
        }

        driver.findElement(By.xpath("//input[@name='low_stock_quantity']")).clear();
        driver.findElement(By.xpath("//input[@name='low_stock_quantity']")).sendKeys("200");
        Thread.sleep(1000);

    }
    @Test(priority = 5)
    public void AddProductImages(){
        driver.findElement(By.xpath("//label[contains(normalize-space(),'(600x600)')]/following-sibling::div/div[contains(.,'Choose File')]")).click();
        WebUI.sleep(10);
        driver.findElement(By.xpath("//input[@class='form-control form-control-xs']")).sendKeys("Trathainguyen",Keys.ENTER);
        WebUI.sleep(10);
        driver.findElement(By.xpath("//div[@class='card-file-thumb']/img")).click();
        WebUI.sleep(10);
        driver.findElement(By.xpath("//button[.='Add Files']")).click();
        WebUI.sleep(10);

    }
    @Test(priority = 6)
    public void AddProductVisiState() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        Boolean stockText = driver.findElement(By.xpath("//label[normalize-space()='Show Stock With Text Only']//following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0']")).isSelected();
        if (stockText == true) {
            softAssert.assertFalse(stockText, "Stock Text option is inactive");
            driver.findElement(By.xpath("//label[normalize-space()='Show Stock With Text Only']//following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0']")).click();
            Thread.sleep(1000);
        }

        Boolean stockHide = driver.findElement(By.xpath("//label[normalize-space()='Hide Stock']//following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0']")).isSelected();
        if (stockHide == false) {
            softAssert.assertTrue(stockHide, "Hide stock option is inactive");
            driver.findElement(By.xpath("//label[normalize-space()='Hide Stock']//following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0']")).click();
            Thread.sleep(1000);
        }

    }
    @Test(priority = 7)
    public void AddProductVideos(){
        SoftAssert softAssert = new SoftAssert();
        driver.findElement(By.xpath("//label[normalize-space()='Video Provider']/following-sibling::div/div")).click();
        driver.findElement(By.xpath("//span[.='Youtube']")).click();
        // trường videolink
        driver.findElement(By.xpath("//label[normalize-space()='Video Link']/following-sibling::div/input")).sendKeys("https://www.youtube.com/watch?v=h34f_3-kC6U&t=7226s",Keys.ENTER);

        boolean statusOption = driver.findElement(By.xpath("//label[normalize-space()='Status']/following-sibling::div/label[@class='aiz-switch aiz-switch-success mb-0']")).isSelected();
        if(statusOption==false){
            softAssert.assertTrue(statusOption,"Status ioption is inactive");
            driver.findElement(By.xpath("//label[normalize-space()='Status']/following-sibling::div/label[@class='aiz-switch aiz-switch-success mb-0']")).click();
            WebUI.sleep(10);
    }
    }
    @Test(priority = 8)
    public void AddProductVariation(){
        WebUI.sleep(10);
        SoftAssert softAssert = new SoftAssert();
        boolean ColorCheckbox = driver.findElement(By.xpath("//div[@class='col-md-1']")).isSelected();
        if(ColorCheckbox == true){
            Assert.assertTrue(ColorCheckbox,"Color option is inactive");
            driver.findElement(By.xpath("//div[@class='col-md-1']")).click();
            WebUI.sleep(10);
        }
        WebUI.sleep(10);
        driver.findElement(By.xpath("//button[@data-id='colors']")).click();
        WebUI.sleep(1000);
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("red");
        WebUI.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'DarkRed')]")).click();
        WebUI.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'OrangeRed')]")).click();
        WebUI.sleep(1000);

        //verify select color
        String SelectedColor = driver.findElement(By.xpath("//div[contains(text(),'3 items selected')]")).getText();
        softAssert.assertEquals(SelectedColor,"3 items selected","selected color are incorrect");

    }





}
