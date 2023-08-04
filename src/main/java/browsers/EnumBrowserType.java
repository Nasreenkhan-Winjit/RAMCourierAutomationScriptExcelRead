package browsers;

import java.util.Objects;

public enum EnumBrowserType {
    IE("ID"),
    FIREFOX("FIREFOX"),
    CHROME("CHROME");

    EnumBrowserType(String value){
        this.value = value;
    }

    private final String value;

    public String toString(){
        return value;
    }

    public static EnumBrowserType getBrowserEnum(String args){
        EnumBrowserType enumBrowserType = null;
        for(EnumBrowserType type : EnumBrowserType.values()){
            if (Objects.equals(type.toString(),args)){
                enumBrowserType = type;
            }
        }
        return enumBrowserType;
    }
}