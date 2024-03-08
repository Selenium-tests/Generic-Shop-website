package qa.dataproviders;

import org.json.JSONException;
import org.testng.annotations.DataProvider;
import qa.jsonreader.ModelsBuilder;
import qa.support.constans.DataProviderNames;

public class PhrasesDataProviders {

    @DataProvider(name = DataProviderNames.CORRECT)
    public Object[] correct() throws JSONException {

        return ModelsBuilder.getStrings(DataProviderNames.CORRECT);
    }

    @DataProvider(name = DataProviderNames.PARTIAL)
    public Object[] partial() throws JSONException {

        return ModelsBuilder.getStrings(DataProviderNames.PARTIAL);
    }

    @DataProvider(name = DataProviderNames.INCORRECT)
    public Object[] incorrect() throws JSONException {

        return ModelsBuilder.getStrings(DataProviderNames.INCORRECT);
    }

    @DataProvider(name = DataProviderNames.NAUGHTY_STRINGS)
    public Object[] naughtyStrings() throws JSONException {

        return ModelsBuilder.getStrings(DataProviderNames.NAUGHTY_STRINGS);
    }
}
