package bo;


public class SearchCriteria {

    private SearchTypeEnum searchType;
    private String location;
    private RangeFromLocationEnum rangeFromLocation;
    private int minimumPrice;
    private int maximumPrice;
    private CountryEnum country;

    public SearchCriteria(SearchTypeEnum searchType, String location, RangeFromLocationEnum rangeFromLocation, int minimumPrice, int maximumPrice) {
        this.searchType = searchType;
        this.location = location;
        this.rangeFromLocation = rangeFromLocation;
        this.minimumPrice = minimumPrice;
        this.maximumPrice = maximumPrice;
    }

    public SearchCriteria(SearchTypeEnum searchType, String location) {
        this.location = location;
        this.searchType = searchType;
    }

    public SearchCriteria() {
    }

    public SearchCriteria(CountryEnum country){
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public RangeFromLocationEnum getRangeFromLocation() {
        return rangeFromLocation;
    }

    public void setRangeFromLocation(RangeFromLocationEnum rangeFromLocation) {
        this.rangeFromLocation = rangeFromLocation;
    }

    public int getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(int minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public int getMaximumPrice() {
        return maximumPrice;
    }

    public void setMaximumPrice(int maximumPrice) {
        this.maximumPrice = maximumPrice;
    }

    public SearchTypeEnum getSearchType() {
        return searchType;
    }

    public void setSearchType(SearchTypeEnum searchType) {
        this.searchType = searchType;
    }

    public CountryEnum getCountry() {
        return country;
    }

    public void setCountry(CountryEnum country) {
        this.country = country;
    }
}
