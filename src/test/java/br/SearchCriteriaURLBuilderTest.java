package br;

import bo.CountryEnum;
import bo.RangeFromLocationEnum;
import bo.SearchCriteria;
import bo.SearchTypeEnum;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class SearchCriteriaURLBuilderTest {

    @Test
    public void fullKoopSearchTest(){
        SearchCriteria search = new SearchCriteria();
        search.setSearchType(SearchTypeEnum.KOOP);
        search.setLocation("Gemeente Amsterdam");
        search.setMinimumPrice(50000);
        search.setMaximumPrice(250000);
        search.setRangeFromLocation(RangeFromLocationEnum.FIVE_KM);

        String result = SearchCriteriaURLBuilder.build(search);

        Assert.assertTrue(StringUtils.equals(result, "/koop/gemeente-amsterdam/50000-250000/+5km/"));
    }

    @Test
    public void locationAndRangeKoopSearchTest(){
        SearchCriteria search = new SearchCriteria();
        search.setSearchType(SearchTypeEnum.KOOP);
        search.setLocation("Gemeente Amsterdam");
        search.setRangeFromLocation(RangeFromLocationEnum.FIVE_KM);

        String result = SearchCriteriaURLBuilder.build(search);

        Assert.assertTrue(StringUtils.equals(result, "/koop/gemeente-amsterdam/+5km/"));
    }

    @Test
    public void locationAndPriceKoopSearchTest(){
        SearchCriteria search = new SearchCriteria();
        search.setSearchType(SearchTypeEnum.KOOP);
        search.setLocation("Gemeente Amsterdam");
        search.setMinimumPrice(50000);
        search.setMaximumPrice(250000);

        String result = SearchCriteriaURLBuilder.build(search);

        Assert.assertTrue(StringUtils.equals(result, "/koop/gemeente-amsterdam/50000-250000/"));
    }

    @Test
    public void fullHuurSearchTest(){
        SearchCriteria search = new SearchCriteria();
        search.setSearchType(SearchTypeEnum.HUUR);
        search.setLocation("Gemeente Eindhoven");
        search.setMinimumPrice(800);
        search.setMaximumPrice(6000);
        search.setRangeFromLocation(RangeFromLocationEnum.TWO_KM);

        String result = SearchCriteriaURLBuilder.build(search);

        Assert.assertTrue(StringUtils.equals(result, "/huur/gemeente-eindhoven/800-6000/+2km/"));
    }

    @Test
    public void fullNieuwbouwSearchTest(){
        SearchCriteria search = new SearchCriteria();
        search.setSearchType(SearchTypeEnum.NIEUWBOUW);
        search.setLocation("Gemeente Utrecht");
        search.setRangeFromLocation(RangeFromLocationEnum.ONE_KM);

        String result = SearchCriteriaURLBuilder.build(search);

        Assert.assertTrue(StringUtils.equals(result, "/nieuwbouw/gemeente-utrecht/+1km/"));
    }

    @Test
    public void fullRecreatieSearchTest(){
        SearchCriteria search = new SearchCriteria();
        search.setSearchType(SearchTypeEnum.RECREATIE);
        search.setLocation("Gemeente Veldhoven");
        search.setRangeFromLocation(RangeFromLocationEnum.TEN_KM);

        String result = SearchCriteriaURLBuilder.build(search);

        Assert.assertTrue(StringUtils.equals(result, "/recreatie/gemeente-veldhoven/+10km/"));
    }

    @Test
    public void fullEuropeSearchTest(){
        SearchCriteria search = new SearchCriteria();
        search.setSearchType(SearchTypeEnum.EUROPE);
        search.setCountry(CountryEnum.België);

        String result = SearchCriteriaURLBuilder.build(search);

        Assert.assertTrue(StringUtils.equals(result, "/europe/belgie/"));
    }
}
