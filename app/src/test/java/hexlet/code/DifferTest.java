package hexlet.code;



import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class DifferTest {


    @Test
    void generateStylish() throws Exception {


        String filePath1 = "./src/test/resources/fixtures/file1.json";
        String filePath2 = "./src/test/resources/fixtures/file2.json";
        String filePath3 = "./src/test/resources/fixtures/filepath1.yml";
        String filePath4 = "./src/test/resources/fixtures/filepath2.yml";

        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";

        String expected2 = "Property 'follow' was removed\n"
                + "Property 'proxy' was removed\n"
                + "Property 'timeout' was updated. From 50 to 20\n"
                + "Property 'verbose' was added with value: true";




        String actual1 = Differ.generate(filePath1, filePath2);
        String actual2 = Differ.generate(filePath3, filePath4);
        String actual3 = Differ.generate(filePath1, filePath2, "plain");
        String actual4 = Differ.generate(filePath3, filePath4, "plain");



        assertThat(actual1).isEqualTo(expected);
        assertThat(actual2).isEqualTo(expected);
        assertThat(actual3).isEqualTo(expected2);
        assertThat(actual4).isEqualTo(expected2);
    }


}
