package hexlet.code;


import hexlet.code.formatters.Parser;

import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2, String formatName) throws Exception {
//        читаем входные файлы и расширение (json, yml)
//        на основе формата данных(получили из расширения фалйла) парсим данные в мапу, получается 2 мапы

        DifferContent result = new DifferContent();
        Map<String, String> filetypeAndFile1 = Parser.readFileAndFormat(filePath1);
        Map<String, String> filetypeAndFile2 = Parser.readFileAndFormat(filePath2);
        Map<String, Object> map1 = Parser.parse(filetypeAndFile1);
        Map<String, Object> map2 = Parser.parse(filetypeAndFile2);

        result.setMap1(map1);
        result.setMap2(map2);

        result.setDifferMap(Comparing.differTwoMap(map1, map2));

        result.setFormatName(formatName);

        return Formatter.format(result);




    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }





}
