package qa.thumbnailgenerators;

import org.openqa.selenium.WebDriver;
import qa.enums.ThumbnailCategory;
import qa.pageobject.thumbnails.Thumbnail;

public interface ThumbnailFactory {

    Thumbnail createThumbnail(WebDriver driver, ThumbnailCategory category, String name);
}
