package loantester.com.POM.baitap5_6_7_8.pages;

import org.openqa.selenium.By;

public class CategoryPage {

    //Data trong nội bộ
    private String URL ="https://cms.anhtester.com/admin/categories";
   // private String PAGE_TEXT = "Category";

    //Các Object
    public By CategoryMenu = By.xpath("//span[.='Category']");
    public By addNewCategoryButton = By.xpath("//span[.='Add New category']");

    public By Name = By.xpath("//input[@id='name']");
    public By ParentCategoryField =  By.xpath("//label[normalize-space()='Parent Category']/following-sibling::div/div");
    public By ParentCategoryFieldSeacrh = By.xpath("//div[@class='dropdown-menu show']//input");
    public By OrderingNumber = By.xpath("//label[normalize-space()='Ordering Number']/following-sibling::div/input");
    public By Type = By.xpath("//label[normalize-space()='Type']/following-sibling::div/div");

    public By BannerField = By.xpath("//label[.='Banner (200x200)']/following-sibling::div");
    public By BannerSearch = By.xpath("//input[@class='form-control form-control-xs']");
    public By BannerClick = By.xpath("//img[@class='img-fit']");
    public By BannerAddFiles = By.xpath("//button[normalize-space()='Add Files']");

    public By MetaTitle = By.xpath("//input[@name='meta_title']");
    public By MetaDescription = By.xpath("//textarea[@class='form-control']");

    public By FilteringAttributesFiles = By.xpath("//label[.='Filtering Attributes']/following-sibling::div/div");
    public By FilteringAttributesSearch = By.xpath("//div[@class='dropdown-menu show']//input");
    public By FilteringAttributesClick = By.xpath("//label[.='Filtering Attributes']/following-sibling::div/div");


    public void FilteringAttributes(){
        clickElement(FilteringAttributesFiles);
    }

    public By Savebutton = By.xpath("//button[.='Save']");


    public void AddCategory (){


    }

}
