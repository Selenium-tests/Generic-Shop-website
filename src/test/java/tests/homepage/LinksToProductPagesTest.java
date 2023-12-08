package tests.homepage;

import qa.enums.ThumbnailType;
import qa.pageobject.thumbnails.Thumbnail;
import qa.base.BaseTest;
import qa.enums.ThumbnailCategory;
import org.testng.Assert;
import org.testng.annotations.Test;
import qa.provider.MyDataProvider;
import qa.extentreports.ExtentReportsManager;
import qa.records.Link;
import qa.thumbnailgenerators.ThumbnailProvider;


public class LinksToProductPagesTest extends BaseTest {

    private void check(ThumbnailCategory category, Link link) {

        Thumbnail thumbnail = ThumbnailProvider
                .getFactory(ThumbnailType.PRODUCT)
                .createThumbnail(getDriver(), category, link.linkText());

        thumbnail.clickLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), link.pageURL(),
                "The page with the address \"" + link.pageURL() + "\" has not been found");
    }

    @Test(dataProvider = "allBlackTops", dataProviderClass = MyDataProvider.class)
    public void allBlackTops(Link link) {

        ExtentReportsManager.setName("Clicking the \"" + link.linkText() + "\" link in the \"ALL BLACK TOP\" section");

        check(ThumbnailCategory.ALL_BLACK_TOPS, link);
    }

    @Test(dataProvider = "highHeelShoesProducts", dataProviderClass = MyDataProvider.class)
    public void highHeelShoes(Link link) {

        ExtentReportsManager.setName("Clicking the \"" + link.linkText() + "\" link in the \"HIGH HEEL SHOES\" section");

        check(ThumbnailCategory.HIGH_HEEL_SHOES, link);
    }

    @Test(dataProvider = "mostWantedProducts", dataProviderClass = MyDataProvider.class)
    public void mostWanted(Link link) {

        ExtentReportsManager.setName("Clicking the \"" + link.linkText() + "\" link in the \"MOST WANTED\" section");

        check(ThumbnailCategory.MOST_WANTED, link);
    }

    @Test(dataProvider = "scarfsProducts", dataProviderClass = MyDataProvider.class)
    public void scarfs(Link link) {

        ExtentReportsManager.setName("Clicking the \"" + link.linkText() + "\" link in the \"SCARFS\" section");

        check(ThumbnailCategory.SCARFS, link);
    }

    @Test(dataProvider = "onSaleProducts", dataProviderClass = MyDataProvider.class)
    public void onSale(Link link) {

        ExtentReportsManager.setName("Clicking the \"" + link.linkText() + "\" link in the \"ON SALE\" section");

        check(ThumbnailCategory.ON_SALE, link);
    }

    @Test(dataProvider = "featuredProducts", dataProviderClass = MyDataProvider.class)
    public void featured(Link link) {

        ExtentReportsManager.setName("Clicking the \"" + link.linkText() + "\" link in the \"FEATURED\" section");

        check(ThumbnailCategory.FEATURED, link);
    }

    @Test(dataProvider = "trendsProducts", dataProviderClass = MyDataProvider.class)
    public void trends(Link link) {

        ExtentReportsManager.setName("Clicking the \"" + link.linkText() + "\" link in the \"TRENDS\" section");

        check(ThumbnailCategory.TRENDS, link);
    }
}