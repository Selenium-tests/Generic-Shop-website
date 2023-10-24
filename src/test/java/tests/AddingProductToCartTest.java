package tests;

import qa.base.BaseTest;
import qa.enums.SiteContentSections;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.CartPage;
import qa.pageobject.SiteContentSection;
import qa.pageobject.header.Header;
import qa.pageobject.thumbnails.ProductThumbnail;
import qa.utils.ExtentReportsManager;

public class AddingProductToCartTest extends BaseTest {

    private Header header;
    private SiteContentSection section;
    private ProductThumbnail productThumbnail;
    private CartPage cartPage;

    @BeforeMethod
    private void create() {

        header = new Header(getDriver());
        section = new SiteContentSection(getDriver());
        cartPage = new CartPage(getDriver());
    }

    @Test(priority = 1)
    public void addingProductFromHomePage() {

        //ExtentReportsManager.setName("Adding product from the home page");

        productThumbnail = new ProductThumbnail(getDriver(), section.getSection("Blue Sweater", SiteContentSections.HIGH_HEEL_SHOES));
        productThumbnail.clickButton();
    }

    @Test(priority = 2)
    public void addingProductFromProductPage() {

        ExtentReportsManager.setName("Adding product from a product page");
    }
}
