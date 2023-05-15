package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.BlogPage;
import pages.ProductPage;
import pages.components.BlogThumbnail;
import pages.components.ProductThumbnail;

public class LinksTest extends BaseTest {

    @Test
    public void linksToProductPages() {

        ProductThumbnail productThumbnail = new ProductThumbnail(getDriver());
        ProductPage productPage = new ProductPage(getDriver());

        for (int i = 0; i < productThumbnail.getSize(); i++) {

            productThumbnail.setProduct(i);

            if (!productThumbnail.getName().isEmpty()) {

                productThumbnail.clickToLink(i);
                getSoftAssert().assertEquals(productThumbnail.getName(), productPage.getProductTitle());

                back();
            }
        }

        getSoftAssert().assertAll();
    }

    @Test
    void linksToBlogPage() {

        BlogThumbnail blogThumbnail = new BlogThumbnail(getDriver());
        BlogPage blogPage = new BlogPage(getDriver());

        for (int i = 0; i < blogThumbnail.getSize(); i++) {

            blogThumbnail.setBlog(i);
            blogThumbnail.clickToLink();

            getSoftAssert().assertTrue(blogPage.getBlogTitle().contains(blogThumbnail.getName()
                    .substring(0, blogThumbnail.getName().length() - 1)));

            back();
        }

        getSoftAssert().assertAll();
    }
}
