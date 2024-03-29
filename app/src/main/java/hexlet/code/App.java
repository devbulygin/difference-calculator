package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(
        name = "App",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.",
        version = "gendiff 1.0"
)
//
final class App implements Runnable {

    @Option(names = { "-f", "--format" }, defaultValue = "stylish",
            description = "output format - stylish, plain, json [default: stylish]")
    private String formatName;

    @Parameters(index = "0", description = "path to first file")
    private static String filePath1;

    @Parameters(index = "1", description = "path to second file")
    private static String filePath2;

    public static String getFilepath1() {
        return filePath1;
    }

    public static String getFilepath2() {
        return filePath2;
    }

    public String getFormatName() {
        return formatName;
    }

    public static void main(String[] args) {
        CommandLine.run(new App(), args);
    }


    @Override
    public void run() {
        String formattedDiff = "";
        try {
            formattedDiff = Differ.generate(filePath1, filePath2, formatName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(formattedDiff);

    }
}
