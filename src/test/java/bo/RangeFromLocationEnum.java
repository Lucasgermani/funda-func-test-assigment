package bo;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public enum RangeFromLocationEnum {
    ZERO_KM("0"),
    ONE_KM("1"),
    TWO_KM("2"),
    FIVE_KM("5"),
    TEN_KM("10"),
    FIFTEEN_KM("15");

    private String value;

    RangeFromLocationEnum(String value){
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
