package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;

import java.util.Map;

public class Formatter {
    public static String format(DifferContent result) throws Exception {
        String formatName = result.getFormatName();
        Map<String, String> diffMap = result.getDifferMap();
        Map<String, Object> map1 = result.getMap1();
        Map<String, Object> map2 = result.getMap2();

        switch (formatName) {
            case "stylish":

                return Stylish.format(diffMap, map1, map2);
            case "plain":

                return Plain.format(diffMap, map1, map2);
            case "json":

                return Json.format(diffMap, map1, map2);

            default:
                throw new Exception("Unknown format: '" + formatName + "'");

        }
    }
}
