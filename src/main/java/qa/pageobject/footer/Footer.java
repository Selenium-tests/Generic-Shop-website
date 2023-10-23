package qa.pageobject.footer;

import qa.base.BasePage;
import org.openqa.selenium.WebDriver;

public class Footer extends BasePage {

    private final TagsSection tagsSection;
    private final RecentPostsSection recentPostsSection;
    private final NewsletterForm newsletterForm;
    public Footer(WebDriver driver) {

        super(driver);

        tagsSection = new TagsSection(driver);
        recentPostsSection = new RecentPostsSection(driver);
        newsletterForm = new NewsletterForm(driver);
    }

    public TagsSection getTagsSection() {

        return tagsSection;
    }

    public RecentPostsSection getRecentPostsSection() {

        return recentPostsSection;
    }

    public NewsletterForm getNewsletterForm() {

        return newsletterForm;
    }
}
