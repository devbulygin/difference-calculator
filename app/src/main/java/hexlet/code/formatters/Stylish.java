package hexlet.code.formatters;

import hexlet.code.Status;

import java.util.Map;


public class Stylish {
    public static String render(Map<String, Status> diff) {
        String result = "{\n";

        for (Map.Entry<String, Status> element : diff.entrySet()) {
            String key = element.getKey();
            Status value = element.getValue();
            String type = value.getStatusName();
            switch (type) {
                case Status.ADDED:
                    result += "  " + "+ " + key + ": " + value.getNewValue() + "\n";
                    break;
                case Status.DELETED:
                    result += "  " + "- " + key + ": " + value.getOldValue() + "\n";
                    break;
                case Status.CHANGED:
                    result += "  " + "- " + key + ": " + value.getOldValue() + "\n";
                    result += "  " + "+ " + key + ": " + value.getNewValue() + "\n";
                    break;
                case Status.UNCHANGED:
                    result += "  " + "  " + key + ": " + value.getNewValue() + "\n";
                    break;
                default:
                    throw new RuntimeException("Unknown node type: '" + type + "'");
            }
        }
        result += "}";
        return result;


    }

}
