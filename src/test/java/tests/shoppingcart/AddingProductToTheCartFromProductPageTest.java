package tests.shoppingcart;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.ProductCategory;
import qa.pageobject.SiteContentSection;
import qa.pageobject.header.Header;
import qa.pageobject.productpage.ProductPage;
import qa.pageobject.shoppingcart.Row;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.provider.MyDataProvider;
import qa.extentreports.ExtentReportsManager;
import qa.records.Link;


public class AddingProductToTheCartFromProductPageTest extends BaseTest {

    private ProductPage productPage;
    private ShoppingCart shoppingCart;
    private Header header;

    @BeforeMethod
    public void create() {

        productPage = new ProductPage(getDriver());
        shoppingCart = new ShoppingCart(getDriver());
        header = new Header(getDriver());
    }

    private void check(String productName, ProductCategory category) {

        SiteContentSection section = new SiteContentSection(getDriver());
        section.clickLink(productName, category);

        final String price = productPage.getPrice();

        productPage.getQuantityField().setQuantity("1");
        productPage.clickAddToCart();
        header.clickCartButton();

        Assert.assertFalse(shoppingCart.getContentsLocator().isEmpty(), "The shopping cart is empty");

        Row row = shoppingCart.getTable().getRow(0);

        Assert.assertEquals(row.getName(), productName, "Incorrect product name in the shopping cart");
        Assert.assertEquals(row.getPrice(), price, "Incorrect price in the shopping cart");
    }

    @Test(dataProvider = "allBlackTops", dataProviderClass = MyDataProvider.class)
    public void fromAllBlackTops(Link link) {

        ExtentReportsManager.setName("Adding the \"" + link.linkText() + "\" product from the \"ALL BLACK TOPS\" category");

        check(link.linkText(), ProductCategory.ALL_BLACK_TOPS);
    }

    @Test(dataProvider = "highHeelShoesProducts", dataProviderClass = MyDataProvider.class)
    public void fromHighHeelShoes(Link link) {

        ExtentReportsManager.setName("Adding the \"" + link.linkText() + "\" product from the \"HIGH HEEL SHOES\" category");

        check(link.linkText(), ProductCategory.HIGH_HEEL_SHOES);
    }

    @Test(dataProvider = "mostWantedProducts", dataProviderClass = MyDataProvider.class)
    public void fromMostWanted(Link link) {

        ExtentReportsManager.setName("Adding the \"" + link.linkText() + "\" product from the \"MOST WANTED\" category");

        check(link.linkText(), ProductCategory.MOST_WANTED);
    }

    @Test(dataProvider = "featuredProducts", dataProviderClass = MyDataProvider.class)
    public void fromFeatured(Link link) {

        ExtentReportsManager.setName("Adding the \"" + link.linkText() + "\" product from the \"FEATURED\" category");

        check(link.linkText(), ProductCategory.FEATURED);
    }

    @Test(dataProvider = "trendsProducts", dataProviderClass = MyDataProvider.class)
    public void fromTrends(Link link) {

        ExtentReportsManager.setName("Adding the \"" + link.linkText() + "\" product from the \"TRENDS\" category");

        check(link.linkText(), ProductCategory.TRENDS);
    }
}
