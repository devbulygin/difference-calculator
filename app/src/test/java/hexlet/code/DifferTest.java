package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class DifferTest {

    @Test
    void generate() throws Exception {
//        String filePath1 = "./src/test/resources/fixtures/file1.json";
//        String filePath2 = "./src/test/resources/fixtures/file2.json";
//        String filePath5 = "./src/test/resources/fixtures/filepath1.yml";
//        String filePath6 = "./src/test/resources/fixtures/filepath2.yml";



        String expected1 = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";

        String expected2 = "Property 'follow' was removed\n"
                + "Property 'proxy' was removed\n"
                + "Property 'timeout' was updated. From '50' to '20'\n"
                + "Property 'verbose' was added with value: 'true'\n";

        String expected3 = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";

        String expected4 = "Property 'follow' was removed\n"
                + "Property 'proxy' was removed\n"
                + "Property 'timeout' was updated. From '50' to '20'\n"
                + "Property 'verbose' was added with value: 'true'\n";

        assertThat(Differ.generate("./src/test/resources/fixtures/file1.json",
                "./src/test/resources/fixtures/file2.json", "stylish")).isEqualTo(expected2);
        assertThat(Differ.generate("./src/test/resources/fixtures/file1.json",
                "./src/test/resources/fixtures/file2.json", "plain")).isEqualTo(expected2);
        assertThat(Differ.generate("./src/test/resources/fixtures/filepath1.yml",
                "./src/test/resources/fixtures/filepath2.yml", "stylish")).isEqualTo(expected3);
        assertThat(Differ.generate("./src/test/resources/fixtures/filepath1.yml",
                "./src/test/resources/fixtures/filepath2.yml", "plain")).isEqualTo(expected4);

    }

}
