package hexlet.code;

import java.util.HashMap;
import java.util.Map;

public class DifferContent {

    private Map<String, Object> map1 = new HashMap<>();
    private Map<String, Object> map2 = new HashMap<>();
    private Map<String, String> differMap = new HashMap<>();

    private String formatName = new String();


    public Map<String, Object> getMap1() {
        return map1;
    }

    public void setMap1(Map<String, Object> map1) {
        this.map1 = map1;
    }

    public Map<String, Object> getMap2() {
        return map2;
    }

    public void setMap2(Map<String, Object> map2) {
        this.map2 = map2;
    }

    public Map<String, String> getDifferMap() {
        return differMap;
    }

    public void setDifferMap(Map<String, String> differMap) {
        this.differMap = differMap;
    }

    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }
}
