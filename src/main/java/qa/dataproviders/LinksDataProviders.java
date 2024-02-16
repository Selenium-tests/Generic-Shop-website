package qa.dataproviders;

import org.testng.annotations.DataProvider;
import qa.jsonreader.ModelsBuilder;
import qa.support.dataprovidernames.DataProviderNames;

public class LinksDataProviders {

    @DataProvider(name = DataProviderNames.MAIN_MENU)
    public Object[] mainMenu() {

        return ModelsBuilder.getLinkData(DataProviderNames.MAIN_MENU);
    }

    @DataProvider(name = DataProviderNames.MAIN_MENU_DROPDOWN_LIST)
    public Object[] mainMenuDropdownList() {

        return ModelsBuilder.getLinkData(DataProviderNames.MAIN_MENU_DROPDOWN_LIST);
    }

    @DataProvider(name = DataProviderNames.ALL_BLACK_TOPS)
    public Object[] allBlackTops() {

        return ModelsBuilder.getLinkData(DataProviderNames.ALL_BLACK_TOPS);
    }

    @DataProvider(name = DataProviderNames.HIGH_HEEL_SHOES)
    public Object[] highHeelShoes() {

        return ModelsBuilder.getLinkData(DataProviderNames.HIGH_HEEL_SHOES);
    }

    @DataProvider(name = DataProviderNames.MOST_WANTED)
    public Object[] mostWanted() {

        return ModelsBuilder.getLinkData(DataProviderNames.MOST_WANTED);
    }

    @DataProvider(name = DataProviderNames.SCARFS)
    public Object[] scarfsProducts() {

        return ModelsBuilder.getLinkData(DataProviderNames.SCARFS);
    }

    @DataProvider(name = DataProviderNames.ON_SALE)
    public Object[] onSaleProducts() {

        return ModelsBuilder.getLinkData(DataProviderNames.ON_SALE);
    }

    @DataProvider(name = DataProviderNames.FEATURED)
    public Object[] featured() {

        return ModelsBuilder.getLinkData(DataProviderNames.FEATURED);
    }

    @DataProvider(name = DataProviderNames.TRENDS)
    public Object[] trends() {

        return ModelsBuilder.getLinkData(DataProviderNames.TRENDS);
    }

    @DataProvider(name = DataProviderNames.ACCOUNT_NAVIGATION)
    public Object[] accountNavigation() {

        return ModelsBuilder.getLinkData(DataProviderNames.ACCOUNT_NAVIGATION);
    }

    @DataProvider(name = DataProviderNames.BLOGS_1)
    public Object[] blogs_1() {

        return ModelsBuilder.getLinkData(DataProviderNames.BLOGS_1);
    }

    @DataProvider(name = DataProviderNames.BLOGS_2)
    public Object[] blogs_2() {

        return ModelsBuilder.getLinkData(DataProviderNames.BLOGS_2);
    }
}
