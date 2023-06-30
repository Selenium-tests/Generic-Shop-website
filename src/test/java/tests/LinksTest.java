package tests;

import base.BaseTest;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.components.thumbnails.BlogThumbnail;
import pages.components.thumbnails.ProductThumbnail;
import utils.ExtentReportsManager;
import utils.JSONReader;

public class LinksTest extends BaseTest {

    @Test
    public void linksToProductPages() throws JSONException {

        ExtentReportsManager.setName("Links to product pages");
        ProductThumbnail productThumbnail = new ProductThumbnail(getDriver());

        String[] expectedURLs = JSONReader.get("URLs", "products");
        //String[] URLs = JSONReader.get("products");

        for (int i = 0, j = 0; i < productThumbnail.getSize(); i++) {

            productThumbnail.setProduct(i);

            if (!productThumbnail.getName().isEmpty()) {

                productThumbnail.clickToLink(i);

                Assert.assertEquals(expectedURLs[j], getDriver().getCurrentUrl());
                j++;

                back();
            }
        }
    }

    @Test
    void linksToBlogPages() throws JSONException {

        ExtentReportsManager.setName("Links to blog pages");
        BlogThumbnail blogThumbnail = new BlogThumbnail(getDriver());

        String[] expectedURLs = JSONReader.get("URLs", "blogs");

        for (int i = 0; i < blogThumbnail.getSize(); i++) {

            blogThumbnail.setBlog(i);
            blogThumbnail.clickToLink();

            Assert.assertEquals(expectedURLs[i], getDriver().getCurrentUrl());

            back();
        }
    }
}
