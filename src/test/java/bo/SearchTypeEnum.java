package bo;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public enum SearchTypeEnum {
    KOOP("Koop"),
    HUUR("Huur"),
    NIEUWBOUW("Nieuwbouw"),
    RECREATIE("Recreatie"),
    EUROPE("Europe");

    private String value;

    SearchTypeEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public RangeFromLocationEnum findCountryByValue(String valueSearch){
        List<RangeFromLocationEnum> list = Arrays.asList(RangeFromLocationEnum.values());
        for (RangeFromLocationEnum enumEntry : list){
            if(StringUtils.equals(enumEntry.getValue(), valueSearch)){
                return enumEntry;
            }
        }
        return null;
    }
}
