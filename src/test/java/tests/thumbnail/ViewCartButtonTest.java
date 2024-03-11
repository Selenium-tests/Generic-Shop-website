package tests.thumbnail;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataproviders.ThumbnailsDataProviders;
import qa.enums.URLs;
import qa.models.ThumbnailData;
import qa.pageobject.thumbnails.ProductThumbnail;
import qa.support.constans.DataProviderNames;
import qa.thumbnailgenerators.ProductThumbnailProvider;
import tests.base.BaseTest;

public class ViewCartButtonTest extends BaseTest {

    @BeforeMethod
    public void create() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
    }

    @Test(priority = 1, dataProvider = DataProviderNames.THUMBNAILS, dataProviderClass = ThumbnailsDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(31)
    @QaseTitle("The \"View Cart\" button visibility")
    @Description("The \"View Cart\" button visibility")
    public void viewCartButtonVisibility(ThumbnailData thumbnailData) {

        ProductThumbnail productThumbnail = ProductThumbnailProvider.create(getDriver(), thumbnailData.getTycheProduct(), thumbnailData.getLink());
        productThumbnail.clickAddToCartButton();

        try {
            productThumbnail.waitForViewCartButton();
        } catch (Exception e) {
            Assert.fail("The \"View Cart\" button is not visible");
        }
    }

    @Test(priority = 2, dataProvider = DataProviderNames.THUMBNAILS, dataProviderClass = ThumbnailsDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(32)
    @QaseTitle("Clicking the \"View Cart\" button")
    @Description("Clicking the \"View Cart\" button")
    public void clickingViewCartButton(ThumbnailData thumbnailData) {

        ProductThumbnail productThumbnail = ProductThumbnailProvider.create(getDriver(), thumbnailData.getTycheProduct(), thumbnailData.getLink());
        productThumbnail.clickAddToCartButton();
        productThumbnail.waitForViewCartButton();
        productThumbnail.clickViewCartButton();

        try {
            getWebDriverWait().until(ExpectedConditions.urlToBe(URLs.SHOPPING_CART.name()));
        } catch (Exception e) {
            Assert.fail("The page \"" + URLs.SHOPPING_CART.getName() + "\" has not been opened");
        }
    }
}
