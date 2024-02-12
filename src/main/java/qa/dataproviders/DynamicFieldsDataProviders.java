package qa.dataproviders;

import org.testng.annotations.DataProvider;
import qa.jsonreader.ModelsBuilder;
import qa.support.dataprovidernames.DataProviderNames;

public class DynamicFieldsDataProviders {

    @DataProvider(name = DataProviderNames.STATE_COUNTY_FIELD)
    public Object[] stateCountyField() {

        return ModelsBuilder.getStrings(DataProviderNames.STATE_COUNTY_FIELD);
    }

    @DataProvider(name = DataProviderNames.STATE_COUNTY_DROPDOWN_LIST)
    public Object[] stateCountyDropdownList() {

        return ModelsBuilder.getStrings(DataProviderNames.STATE_COUNTY_DROPDOWN_LIST);
    }

    @DataProvider(name = DataProviderNames.COUNTY_DROPDOWN_LIST)
    public Object[] countyDropdownList() {

        return ModelsBuilder.getStrings(DataProviderNames.COUNTY_DROPDOWN_LIST);
    }

    @DataProvider(name = DataProviderNames.STATE_DROPDOWN_LIST)
    public Object[] stateDropdownList() {

        return ModelsBuilder.getStrings(DataProviderNames.STATE_DROPDOWN_LIST);
    }

    @DataProvider(name = DataProviderNames.DISTRICT_DROPDOWN_LIST)
    public Object[] districtDropdownList() {

        return ModelsBuilder.getStrings(DataProviderNames.DISTRICT_DROPDOWN_LIST);
    }

    @DataProvider(name = DataProviderNames.PROVINCE_DROPDOWN_LIST)
    public Object[] provinceDropdownList() {

        return ModelsBuilder.getStrings(DataProviderNames.PROVINCE_DROPDOWN_LIST);
    }

    @DataProvider(name = DataProviderNames.REGION_FIELD)
    public Object[] regionField() {

        return ModelsBuilder.getStrings(DataProviderNames.REGION_FIELD);
    }

    @DataProvider(name = DataProviderNames.REGION_DROPDOWN_LIST)
    public Object[] regionDropdownList() {

        return ModelsBuilder.getStrings(DataProviderNames.REGION_DROPDOWN_LIST);
    }

    @DataProvider(name = DataProviderNames.PREFECTURE_DROPDOWN_LIST)
    public Object[] prefectureDropdownList() {

        return ModelsBuilder.getStrings(DataProviderNames.PREFECTURE_DROPDOWN_LIST);
    }

    @DataProvider(name = DataProviderNames.MUNICIPALITY_FIELD)
    public Object[] municipalityField() {

        return ModelsBuilder.getStrings(DataProviderNames.MUNICIPALITY_FIELD);
    }

    @DataProvider(name = DataProviderNames.STATE_ZONE_DROPDOWN_LIST)
    public Object[] stateZoneDropdownList() {

        return ModelsBuilder.getStrings(DataProviderNames.STATE_ZONE_DROPDOWN_LIST);
    }

}
