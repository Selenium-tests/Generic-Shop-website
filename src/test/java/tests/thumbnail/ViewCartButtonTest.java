package tests.thumbnail;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataproviders.ThumbnailsDataProviders;
import qa.support.constans.URLs;
import qa.models.ThumbnailData;
import qa.pageobject.thumbnails.ProductThumbnail;
import qa.support.constans.DataProviderNames;
import qa.support.thumbnailprovider.ProductThumbnailProvider;
import tests.base.BaseTest;

public class ViewCartButtonTest extends BaseTest {

    @BeforeMethod
    public void prepare() {

        goToPage(URLs.HOME_PAGE);
    }

    private void setAllureParameters(ThumbnailData thumbnailData) {

        Allure.parameter("Thumbnail link", thumbnailData.getLink());
        Allure.parameter("Tyche product", thumbnailData.getTycheProduct());
    }

    @Test(priority = 1, dataProvider = DataProviderNames.THUMBNAILS, dataProviderClass = ThumbnailsDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Thumbnails")
    @Tag("Buttons")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(31)
    @QaseTitle("The \"View Cart\" button visibility")
    @Description("The \"View Cart\" button visibility")
    public void viewCartButtonVisibility(ThumbnailData thumbnailData) {

        setAllureParameters(thumbnailData);
        ProductThumbnail productThumbnail = ProductThumbnailProvider.create(getDriver(), thumbnailData.getTycheProduct(), thumbnailData.getLink());
        productThumbnail.clickAddToCartButton();

        try {
            productThumbnail.waitForViewCartButton();
        } catch (Exception e) {
            Assert.fail("The \"View Cart\" button is not visible");
        }
    }

    @Test(priority = 2, dataProvider = DataProviderNames.THUMBNAILS, dataProviderClass = ThumbnailsDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Thumbnails")
    @Tag("Buttons")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(32)
    @QaseTitle("Clicking the \"View Cart\" button")
    @Description("Clicking the \"View Cart\" button")
    public void clickingViewCartButton(ThumbnailData thumbnailData) {

        setAllureParameters(thumbnailData);
        ProductThumbnail productThumbnail = ProductThumbnailProvider.create(getDriver(), thumbnailData.getTycheProduct(), thumbnailData.getLink());
        productThumbnail.clickAddToCartButton();
        productThumbnail.waitForViewCartButton();
        productThumbnail.clickViewCartButton();

        try {
            getWebDriverWait().until(ExpectedConditions.urlToBe(URLs.SHOPPING_CART_PAGE));
        } catch (Exception e) {
            Assert.fail("The page \"" + URLs.SHOPPING_CART_PAGE + "\" has not been opened");
        }
    }
}
