package hexlet.code;

import java.util.HashMap;
import java.util.Map;

final class DifferContent {

    private Map<String, Object> map1 = new HashMap<>();
    private Map<String, Object> map2 = new HashMap<>();
    private Map<String, String> differMap = new HashMap<>();

    private String formatName = new String();


    public Map<String, Object> getMap1() {
        return map1;
    }

    public void setMap1(Map<String, Object> newMap1) {
        this.map1 = newMap1;
    }

    public Map<String, Object> getMap2() {
        return map2;
    }

    public void setMap2(Map<String, Object> newMap2) {
        this.map2 = newMap2;
    }

    public Map<String, String> getDifferMap() {
        return differMap;
    }

    public void setDifferMap(Map<String, String> newDifferMap) {
        this.differMap = newDifferMap;
    }

    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String newFormatName) {
        this.formatName = newFormatName;
    }
}
