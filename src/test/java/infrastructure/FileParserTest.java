package infrastructure;

import domain.Program;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FileParserTest {

    private static final File DUMP_FILE = null;
    private static final List<String> EMPTY_LIST = new ArrayList<>();

    @Test
    public void should_parse_program_without_above_programs() {
        FileParser fileParser = new FileParser(DUMP_FILE);

        Program expectedProgram = new Program("pbga", 66, EMPTY_LIST);

        Program program = fileParser.parseLine("pbga (66)");

        assertThat(program, is(expectedProgram));
    }

    @Test
    public void should_parse_program_with_above_programs() {
        FileParser fileParser = new FileParser(DUMP_FILE);
        Program expectedProgram = new Program("padx", 45, Arrays.asList("pbga", "havc", "qoyq"));

        Program program = fileParser.parseLine("padx (45) -> pbga, havc, qoyq");

        assertThat(program, is(expectedProgram));
    }

}