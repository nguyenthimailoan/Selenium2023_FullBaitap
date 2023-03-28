package loantester.com.POM.baitap5_6_7_8.pages.Category;
import static loantester.com.keywords.WebUI.*;

import loantester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CategoryPage {

    //Data trong nội bộ
    private String URL ="https://cms.anhtester.com/admin/categories";
   // private String PAGE_TEXT = "Category";


    public By Name = By.xpath("//input[@id='name']");
    public By ParentCategoryField =  By.xpath("//label[normalize-space()='Parent Category']/following-sibling::div/div");
    public By ParentCategoryFieldSeacrh = By.xpath("//div[@class='dropdown-menu show']//input");
    public By OrderingNumber = By.xpath("//label[normalize-space()='Ordering Number']/following-sibling::div/input");
    public By Type = By.xpath("//label[normalize-space()='Type']/following-sibling::div/div");

    public By BannerField = By.xpath("//label[.='Banner (200x200)']/following-sibling::div");
    public By BannerSearch = By.xpath("//input[@class='form-control form-control-xs']");
    public By BannerClick = By.xpath("//img[@class='img-fit']");
    public By BannerClickAddFiles = By.xpath("//button[normalize-space()='Add Files']");


    public void Banner(String banner){
        clickElement(BannerField);
        getWebElement(BannerSearch).sendKeys(banner,Keys.ENTER);
        clickElement(BannerClick);
        clickElement(BannerClickAddFiles);
    }

    public By MetaTitle = By.xpath("//input[@name='meta_title']");
    public By MetaDescription = By.xpath("//textarea[@class='form-control']");

    public By FilteringAttributesFiles = By.xpath("//label[.='Filtering Attributes']/following-sibling::div/div");
    public By FilteringAttributesSearch = By.xpath("//div[@class='dropdown-menu show']//input");
    public By FilteringAttributesClick = By.xpath("//label[.='Filtering Attributes']/following-sibling::div/div");


    public void FilteringAttributes(String filtering){
        clickElement(FilteringAttributesFiles);
        getWebElement(FilteringAttributesSearch).sendKeys(filtering, Keys.ENTER);
        clickElement(FilteringAttributesClick);
    }

    public By Savebutton = By.xpath("//button[.='Save']");


    private WebDriver driver;

    public CategoryPage(WebDriver _driver) {
        driver = _driver;
        new WebUI(driver); //Khởi tạo class WebUI để truyền giá trị driver từ bên ngoài vào WebUI
    }

    public void AddNewCategory (String CATEGORY_NAME){
        waitForPageLoaded();
//        clickElement(CategoryMenu);
//        clickElement(addNewCategoryButton);

        setText(Name,CATEGORY_NAME);
        clickElement(ParentCategoryField);
        getWebElement(ParentCategoryFieldSeacrh).sendKeys("ĐỒNG HỒ",Keys.ENTER);
        setText(OrderingNumber,"01920121");

        clickElement(BannerField);
        sleep(10);
        getWebElement(BannerSearch).sendKeys("TraThaiNguyen",Keys.ENTER);
        sleep(10);
        clickElement(BannerClick);
        sleep(10);
        clickElement(BannerClickAddFiles);

        setText(MetaTitle,"Parfum");
        setText(MetaDescription,"Description test");

        clickElement(FilteringAttributesFiles);
        getWebElement(FilteringAttributesSearch).sendKeys("Size", Keys.ENTER);
        clickElement(FilteringAttributesClick);
        clickElement(Savebutton);
        waitForPageLoaded();

    }


}
