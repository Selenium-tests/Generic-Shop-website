package qa.dataproviders;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.DataProvider;
import qa.support.modelsbuilder.ModelsBuilder;
import qa.support.constans.DataProviderNames;

public class ThumbnailsDataProviders {

    @DataProvider(name = DataProviderNames.THUMBNAILS)
    public Object[] thumbnails() throws JsonProcessingException {

        return ModelsBuilder.getThumbnailsData();
    }
}
