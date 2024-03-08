package qa.dataproviders;

import org.testng.annotations.DataProvider;
import qa.jsonreader.ModelsBuilder;
import qa.support.constans.DataProviderNames;

public class SpecialCharactersDataProvider {

    @DataProvider(name = DataProviderNames.SPECIAL_CHARACTERS)
    public Object[] specialCharacters() {

        return ModelsBuilder.getStrings(DataProviderNames.SPECIAL_CHARACTERS);
    }
}
