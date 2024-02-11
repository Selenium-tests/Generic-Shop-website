package qa.dataproviders;

import org.testng.annotations.DataProvider;
import qa.jsonreader.ModelsBuilder;
import qa.support.dataprovidernames.DataProviderNames;

public class CountriesDataProviders {

    @DataProvider(name = DataProviderNames.CORRECT)
    public Object[] correct() {

        return ModelsBuilder.getStrings(DataProviderNames.CORRECT);
    }

    @DataProvider(name = DataProviderNames.PARTIAL)
    public Object[] partial() {

        return ModelsBuilder.getStrings(DataProviderNames.PARTIAL);
    }

    @DataProvider(name = DataProviderNames.INCORRECT)
    public Object[] incorrect() {

        return ModelsBuilder.getStrings(DataProviderNames.INCORRECT);
    }
}
