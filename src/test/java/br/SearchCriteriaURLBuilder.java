package br;

import bo.SearchCriteria;
import bo.SearchTypeEnum;

public class SearchCriteriaURLBuilder {

    public static String build(SearchCriteria search){
        String url = "";

        if(search.getCountry() != null && search.getSearchType() == SearchTypeEnum.EUROPE){
            return "/" + SearchTypeEnum.EUROPE.getValue().toLowerCase() + "/" + search.getCountry().getValue() + "/";
        }

        //SearchType
        url = url.concat("/" + search.getSearchType().getValue().toLowerCase() + "/");

        //Location
        String location = search.getLocation().toLowerCase();
        location = location.replaceAll(" ", "-");
        url = url.concat(location + "/");

        //Price
        String priceFilter = "";
        if(search.getMinimumPrice() > 0 && search.getMaximumPrice() == 0) {
            priceFilter = search.getMinimumPrice() + "+/";
            url = url.concat(priceFilter);
        }else if(search.getMinimumPrice() != 0 && search.getMaximumPrice() != 0){
            priceFilter = search.getMinimumPrice() + "-" + search.getMaximumPrice() + "/";
            url = url.concat(priceFilter);
        }

        //SearchCriteria Range
        String rangeFilter = "";
        if(search.getRangeFromLocation() != null){
            rangeFilter = "+" + search.getRangeFromLocation().getValue() + "km/";
            url = url.concat(rangeFilter);
        }

        return url;
    }
}
