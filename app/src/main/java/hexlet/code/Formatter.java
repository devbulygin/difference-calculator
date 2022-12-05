package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    public static String format(Map<String, Status> diff, String formatName) throws Exception {



        switch (formatName) {
            case "stylish":
                return Stylish.render(diff);
            case "plain":
                return Plain.render(diff);
            case "json":

                return Json.render(diff);

            default:
                throw new Exception("Unknown format: '" + formatName + "'");

        }
    }
}
