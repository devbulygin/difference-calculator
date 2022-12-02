package hexlet.code;



import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;


class DifferTest {

    private static String resultJson;
    private static String resultPlain;
    private static String resultStylish;

    // Построение путей до фикстур не дублируется
    // Сами данные хранятся в текстовых файлах (фикстурах), а не в самих тестах.
    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", "test", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }

    // Побочные эффекты правильно делать не на уровне класса, а внутри хуков
    @BeforeAll
    public static void beforeAll() throws Exception {
        resultJson = readFixture("result_json.json");
        resultPlain = readFixture("result_plain.txt");
        resultStylish = readFixture("result_stylish.txt");
    }

    @Test
    void differTest() throws Exception {
        String json1 = getFixturePath("file1.json").toString();
        String json2 = getFixturePath("file2.json").toString();
        String yml1 = getFixturePath("file1.yml").toString();
        String yml2 = getFixturePath("file2.yml").toString();

        String actualJson = Differ.generate(json1, json2);
        String actualJsonStylish = Differ.generate(json1, json2, "stylish");
        String actualJsonPlain = Differ.generate(json1, json2, "plain");
        String actualJsonJson = Differ.generate(json1, json2, "json");

        String actualYml = Differ.generate(yml1, yml2);
        String actualYmlStylish = Differ.generate(yml1, yml2, "stylish");
        String actualYmlPlain = Differ.generate(yml1, yml2, "plain");
        String actualYmlJson = Differ.generate(yml1, yml2, "json");

        assertThat(actualJson).isEqualTo(resultStylish);
        assertThat(actualJsonStylish).isEqualTo(resultStylish);
        assertThat(actualJsonPlain).isEqualTo(resultPlain);
        assertThat(actualJsonJson).isEqualTo(resultJson);

        assertThat(actualYml).isEqualTo(resultStylish);
        assertThat(actualYmlStylish).isEqualTo(resultStylish);
        assertThat(actualYmlPlain).isEqualTo(resultPlain);
        assertThat(actualYmlJson).isEqualTo(resultJson);


    }



}
