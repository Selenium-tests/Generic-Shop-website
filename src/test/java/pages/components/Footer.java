package pages.components;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public class Footer extends BasePage {

    private final TagsSection tagsSection;
    private final RecentPostsSection recentPostsSection;
    private final NewsletterSection newsletterSection;
    public Footer(WebDriver driver) {

        super(driver);

        tagsSection = new TagsSection(driver);
        recentPostsSection = new RecentPostsSection(driver);
        newsletterSection = new NewsletterSection(driver);
    }

    public TagsSection getTagsSection() {

        return tagsSection;
    }

    public RecentPostsSection getRecentPostsSection() {

        return recentPostsSection;
    }

    public NewsletterSection getNewsletterSection() {

        return newsletterSection;
    }
}
