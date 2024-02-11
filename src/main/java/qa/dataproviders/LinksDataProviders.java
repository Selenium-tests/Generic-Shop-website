package qa.dataproviders;

import org.testng.annotations.DataProvider;
import qa.jsonreader.ModelsBuilder;
import qa.support.dataprovidernames.DataProviderNames;

public class LinksDataProviders {

    @DataProvider(name = DataProviderNames.MAIN_MENU)
    public Object[] mainMenu() {

        return ModelsBuilder.getLink(DataProviderNames.MAIN_MENU);
    }

    @DataProvider(name = DataProviderNames.MAIN_MENU_DROPDOWN_LIST)
    public Object[] mainMenuDropdownList() {

        return ModelsBuilder.getLink(DataProviderNames.MAIN_MENU_DROPDOWN_LIST);
    }

    @DataProvider(name = DataProviderNames.ALL_BLACK_TOPS)
    public Object[] allBlackTops() {

        return ModelsBuilder.getLink(DataProviderNames.ALL_BLACK_TOPS);
    }

    @DataProvider(name = DataProviderNames.HIGH_HEEL_SHOES)
    public Object[] highHeelShoes() {

        return ModelsBuilder.getLink(DataProviderNames.HIGH_HEEL_SHOES);
    }

    @DataProvider(name = DataProviderNames.MOST_WANTED)
    public Object[] mostWanted() {

        return ModelsBuilder.getLink(DataProviderNames.MOST_WANTED);
    }

    @DataProvider(name = DataProviderNames.SCARFS)
    public Object[] scarfsProducts() {

        return ModelsBuilder.getLink(DataProviderNames.SCARFS);
    }

    @DataProvider(name = DataProviderNames.ON_SALE)
    public Object[] onSaleProducts() {

        return ModelsBuilder.getLink(DataProviderNames.ON_SALE);
    }

    @DataProvider(name = DataProviderNames.FEATURED)
    public Object[] featured() {

        return ModelsBuilder.getLink(DataProviderNames.FEATURED);
    }

    @DataProvider(name = "trendsProducts")
    public Object[] trends() {

        return ModelsBuilder.getLink("trendsProducts");
    }

}
