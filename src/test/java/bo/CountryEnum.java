package bo;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public enum CountryEnum {
    Alle_landen("heel-europa"),
    Albanië("albanie"),
    Andorra("andorra"),
    België("belgie"),
    Bosnië_en_Herzegovina("bosnie-en-herzegovina"),
    Bulgarije("bulgarije"),
    Cyprus("cyprus"),
    Denemarken("denemarken"),
    Duitsland("duitsland"),
    Estland("estland"),
    Finland("finland"),
    Frankrijk("frankrijk"),
    Georgië("georgie"),
    Griekenland("griekenland"),
    Groot_Brittannië("groot-brittannie"),
    Hongarije("hongarije"),
    Ierland("ierland"),
    IJsland("ijsland"),
    Italië("italie"),
    Kroatië("kroatie"),
    Letland("letland"),
    Liechtenstein("liechtenstein"),
    Litouwen("litouwen"),
    Luxemburg("luxemburg"),
    Macedonië("macedonie"),
    Malta("malta"),
    Moldavië("moldavie"),
    Monaco("monaco"),
    Montenegro("montenegro"),
    Noorwegen("noorwegen"),
    Oostenrijk("oostenrijk"),
    Polen("polen"),
    Portugal("portugal"),
    Roemenië("roemenie"),
    Rusland("rusland"),
    San_Marino("san-marino"),
    Servië("servie"),
    Slovenië("slovenie"),
    Slowakije("slowakije"),
    Spanje("spanje"),
    Tsjechië("tsjechie"),
    Turkije("turkije"),
    Ukraïne("ukraine"),
    Wit_Rusland("wit-rusland"),
    Zweden("zweden"),
    Zwitserland("zwitserland"),;

    private String value;

    CountryEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
