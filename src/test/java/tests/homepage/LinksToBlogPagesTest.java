package tests.homepage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import qa.models.LinkData;
import qa.dataproviders.LinksDataProviders;
import qa.enums.TycheProduct;
import qa.enums.URLs;
import qa.support.dataprovidernames.DataProviderNames;
import qa.thumbnailgenerators.BlogThumbnailProvider;


public class LinksToBlogPagesTest extends BaseTest {

    @BeforeMethod
    public void create() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
    }

    private void actions(LinkData linkData, TycheProduct tycheProduct) {

        BlogThumbnailProvider.create(getDriver(), tycheProduct, linkData.getLink());
    }

    @Test(dataProvider = DataProviderNames.BLOGS_1, dataProviderClass = LinksDataProviders.class)
    public void group1(LinkData linkData) {

        actions(linkData, TycheProduct.RECENT_1);
    }

    @Test(dataProvider = DataProviderNames.BLOGS_2, dataProviderClass = LinksDataProviders.class)
    public void group2(LinkData linkData) {

        actions(linkData, TycheProduct.RECENT_2);
    }
}
