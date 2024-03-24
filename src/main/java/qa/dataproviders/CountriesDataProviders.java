package qa.dataproviders;

import org.testng.annotations.DataProvider;
import qa.support.modelsbuilder.ModelsBuilder;
import qa.support.constans.DataProviderNames;

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
