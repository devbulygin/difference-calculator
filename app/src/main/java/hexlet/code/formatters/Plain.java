package hexlet.code.formatters;



import hexlet.code.Status;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;




public class Plain {
    public static String render(Map<String, Status> diff) {
        String result = new String();


        for (Map.Entry<String, Status> element : diff.entrySet()) {
            String key = element.getKey();
            Status value = element.getValue();
            switch (value.getStatusName()) {
                case "added":
                    result += "Property " + "\'" + key + "\'" + " was added with value: "
                            + toPlain(value.getNewValue()) + "\n";
                    break;
                case "deleted":
                    result += "Property " + "\'" + key + "\'" + " was removed" + "\n";
                    break;
                case "changed":
                    result += "Property " + "\'" + key + "\'" + " was updated. From "
                            + toPlain(value.getOldValue()) + " to " + toPlain(value.getNewValue()) + "\n";
                    break;
                case "unchanged":
                    break;
                default:
                    throw new RuntimeException("operation not found");
            }

        }

        return (result == null || result.length() == 0) ? null : (result.substring(0, result.length() - 1));

    }
    public static Object toPlain(Object value) {
        Object result = new Object();
        if (value instanceof String
                || value instanceof Character) {
            result = "\'" + value + "\'";
        } else if (value == null) {
            result = null;
        } else if (value instanceof ArrayList || value instanceof LinkedHashMap) {
            result = "[complex value]";
        } else {
            result = value;
        }
        return result;
    }




}




