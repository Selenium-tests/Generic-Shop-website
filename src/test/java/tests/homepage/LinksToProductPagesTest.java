package tests.homepage;

import qa.base.ThumbnailTest;
import qa.enums.ThumbnailType;
import qa.enums.ThumbnailCategory;
import org.testng.annotations.Test;
import qa.dataproviders.DataProviders;
import qa.data.Link;

public class LinksToProductPagesTest extends ThumbnailTest {

    @Test(dataProvider = "allBlackTops", dataProviderClass = DataProviders.class)
    public void allBlackTops(Link link) throws IllegalAccessException {

        check(ThumbnailType.PRODUCT, ThumbnailCategory.ALL_BLACK_TOPS, link);
    }

    @Test(dataProvider = "highHeelShoesProducts", dataProviderClass = DataProviders.class)
    public void highHeelShoes(Link link) throws IllegalAccessException {

        check(ThumbnailType.PRODUCT, ThumbnailCategory.HIGH_HEEL_SHOES, link);
    }

    @Test(dataProvider = "mostWantedProducts", dataProviderClass = DataProviders.class)
    public void mostWanted(Link link) throws IllegalAccessException {

        check(ThumbnailType.PRODUCT, ThumbnailCategory.MOST_WANTED, link);
    }

    @Test(dataProvider = "scarfsProducts", dataProviderClass = DataProviders.class)
    public void scarfs(Link link) throws IllegalAccessException {

        check(ThumbnailType.PRODUCT, ThumbnailCategory.SCARFS, link);
    }

    @Test(dataProvider = "onSaleProducts", dataProviderClass = DataProviders.class)
    public void onSale(Link link) throws IllegalAccessException {

        check(ThumbnailType.PRODUCT, ThumbnailCategory.ON_SALE, link);
    }

    @Test(dataProvider = "featuredProducts", dataProviderClass = DataProviders.class)
    public void featured(Link link) throws IllegalAccessException {

        check(ThumbnailType.PRODUCT, ThumbnailCategory.FEATURED, link);
    }

    @Test(dataProvider = "trendsProducts", dataProviderClass = DataProviders.class)
    public void trends(Link link) throws IllegalAccessException {

        check(ThumbnailType.PRODUCT, ThumbnailCategory.TRENDS, link);
    }
}
