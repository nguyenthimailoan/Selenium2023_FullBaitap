package loantester.com.POM.baitap5_6_7_8.pages.Category;

import loantester.com.keywords.WebUI;

import static loantester.com.keywords.WebUI.*;
import static loantester.com.keywords.WebUI.getAttributeElement;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CategoryDetailPage extends CategoryPage {

    private WebDriver driver;

    public CategoryDetailPage(WebDriver _driver) {
        super(_driver);
        driver = _driver;
        new WebUI(driver);
    }

    public void checkCategoryDetail(String CATEGORY_NAME) {
        WebUI.waitForPageLoaded();
        System.out.println(getAttributeElement(Name, "value"));
        System.out.println(getAttributeElement(ParentCategoryField,"value"));
        System.out.println(getAttributeElement(OrderingNumber,"value"));
        System.out.println(getAttributeElement(MetaTitle,"value"));

        Assert.assertEquals(getAttributeElement(Name, "value"),CATEGORY_NAME,"Category not match");
        Assert.assertEquals(getAttributeElement(ParentCategoryField,"value"),"ĐỒNG HỒ","parent not match");
        Assert.assertEquals(getAttributeElement(OrderingNumber,"value"),"01920121","OrderingNumber not match");

    }

}
