package tests.homepage;

import org.testng.annotations.Test;
import qa.base.ThumbnailTest;
import qa.enums.ThumbnailCategory;
import qa.enums.ThumbnailType;
import qa.dataproviders.DataProviders;
import qa.data.Link;

public class LinksToBlogPagesTest extends ThumbnailTest {

    @Test(dataProvider = "blogs1", dataProviderClass = DataProviders.class)
    public void group1(Link link) throws IllegalAccessException {

        check(ThumbnailType.BLOG, ThumbnailCategory.RECENT_1, link);
    }

    @Test(dataProvider = "blogs2", dataProviderClass = DataProviders.class)
    public void group2(Link link) throws IllegalAccessException {

        check(ThumbnailType.BLOG, ThumbnailCategory.RECENT_2, link);
    }
}
