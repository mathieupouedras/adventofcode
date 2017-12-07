package infrastructure;

import domain.Program;
import domain.ProgramRepository;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProgramRepositoryFileTest {
    @Ignore
    @Test
    public void should_get_all_programs() {
        ProgramRepository programRepository = new ProgramRepositoryFile("input_day7.txt");

        List<Program> programs = programRepository.getAllPrograms();

        assertThat(programs.size(), is(1420));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_file_not_found() {
        ProgramRepository programRepository = new ProgramRepositoryFile("UNKNOW_FILENAME");

        assertThat(programRepository.getFile().exists(), is(false));
    }

    @Test
    public void should_get_existing_file() {
        ProgramRepository programRepository = new ProgramRepositoryFile("input_day7.txt");

        assertThat(programRepository.getFile().exists(), is(true));
    }
}