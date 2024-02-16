package qa.dataproviders;

import org.testng.annotations.DataProvider;
import qa.jsonreader.ModelsBuilder;
import qa.support.dataprovidernames.DataProviderNames;

public class ThumbnailsDataProviders {

    @DataProvider(name = DataProviderNames.THUMBNAILS)
    public Object[] thumbnails() {

        return ModelsBuilder.getThumbnailsData();
    }
}
