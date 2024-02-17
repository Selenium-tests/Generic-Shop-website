package tests.homepage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import tests.base.BaseTest;
import qa.dataproviders.LinksDataProviders;
import qa.enums.TycheProduct;
import org.testng.annotations.Test;
import qa.models.LinkData;
import qa.enums.URLs;
import qa.support.dataprovidernames.DataProviderNames;
import qa.thumbnailgenerators.ProductThumbnailProvider;

public class LinksToProductPagesTest extends BaseTest {

    @BeforeMethod
    public void create() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
    }

    private void actions(LinkData linkData, TycheProduct tycheProduct) {

        ProductThumbnailProvider.create(getDriver(), tycheProduct.getName(), linkData.getLink()).clickLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), linkData.getUrl(),
                "The page with the address \"" + linkData.getUrl() + "\" has not been found");
    }
    @Test(dataProvider = DataProviderNames.ALL_BLACK_TOPS, dataProviderClass = LinksDataProviders.class)
    public void allBlackTops(LinkData linkData) {

        actions(linkData, TycheProduct.ALL_BLACK_TOPS);
    }

    @Test(dataProvider = DataProviderNames.HIGH_HEEL_SHOES, dataProviderClass = LinksDataProviders.class)
    public void highHeelShoes(LinkData linkData) {

        actions(linkData, TycheProduct.HIGH_HEEL_SHOES);
    }

    @Test(dataProvider = DataProviderNames.MOST_WANTED, dataProviderClass = LinksDataProviders.class)
    public void mostWanted(LinkData linkData) {

        actions(linkData, TycheProduct.MOST_WANTED);
    }

    @Test(dataProvider = DataProviderNames.SCARFS, dataProviderClass = LinksDataProviders.class)
    public void scarfs(LinkData linkData) {

        actions(linkData, TycheProduct.SCARFS);
    }

    @Test(dataProvider = DataProviderNames.ON_SALE, dataProviderClass = LinksDataProviders.class)
    public void onSale(LinkData linkData) {

        actions(linkData, TycheProduct.ON_SALE);
    }

    @Test(dataProvider = DataProviderNames.FEATURED, dataProviderClass = LinksDataProviders.class)
    public void featured(LinkData linkData) {

        actions(linkData, TycheProduct.FEATURED);
    }

    @Test(dataProvider = DataProviderNames.TRENDS, dataProviderClass = LinksDataProviders.class)
    public void trends(LinkData linkData) {

        actions(linkData, TycheProduct.TRENDS);
    }
}
