package loantester.com.POM.baitap5_6_7_8.pages.Category;

import loantester.com.keywords.WebUI;
import  loantester.com.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static loantester.com.keywords.WebUI.*;

public class ViewCategoryPage {

    private String URL ="https://cms.anhtester.com/admin/categories";
    private String PAGE_TEXT = "All categories";

    //Object thuộc Category page
    private By headerPageCategory = By.xpath("//h1");
//    public By ProductMenu = By.xpath("//span[.='Products']");
//    public By CategoryMenu = By.xpath("//span[.='Category']");
    public By addNewCategoryButton = By.xpath("//span[.='Add New category']");
    public By inputSearch = By.xpath("//input[@class='form-control']");
    public By tdCategory = By.xpath("//tbody/tr[1]/td[2]");

    // hàm xây dựng
    private WebDriver driver;

    public ViewCategoryPage(WebDriver _driver) {
        driver = _driver;
        new WebUI(driver);
    }
    //các hàm xử lý cho chức năng thuộc Category page
    public void verifyCategoryPage(){
        Assert.assertEquals(getCurrentUrl(),URL,"URL chưa đúng trang customer");
        Assert.assertTrue(checkElementExist(headerPageCategory),"Header Page Category not existing");
        Assert.assertEquals(getTextElement(headerPageCategory),PAGE_TEXT,"Header Page of category pate not match");
    }
//    public CategoryPage clickmenuCategory(){
//        clickElement(ProductMenu);
//        clickElement(CategoryMenu);
//    //    clickElement(addNewCategoryButton);
//        return new CategoryPage(driver);
//    }
    public CategoryPage clickAddNewCategoryButton(){
        clickElement(addNewCategoryButton);
        return new CategoryPage(driver);
    }

    public void searchCategory(String CATEGORY_NAME){
        waitForPageLoaded();
    //    setText(inputSearch,CATEGORY_NAME);
        getWebElement(inputSearch).sendKeys(CATEGORY_NAME,Keys.ENTER);

        sleep(10);

    }

    public CategoryDetailPage clickOnFirstRowCategoryName(){
        waitForPageLoaded();
        sleep(10);
        clickElement(tdCategory);
        return new CategoryDetailPage(driver);
    }
}
