package infrastructure;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TextFileReaderTest {

    @Test
    public void should_read_lines() {
        FileRepository fileRepositiry = new FileRepository();
        File file = fileRepositiry.loadFile("input_test.txt");
        TextFileReader textFileReader = new TextFileReader(file);

        List<String> lines = textFileReader.readLines();

        assertThat(lines.size(), is(7));
    }
}
