package domain;

import infrastructure.ProgramRepositoryFile;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TowerTest {

    private static final List<String> EMPTY_LIST = new ArrayList<>();

    @Test
    public void should_return_bottom_program() {
        ProgramRepository programRepository = new ProgramRepositoryFile("input_day7.txt");

        Tower tower = new Tower(programRepository.getAllPrograms());

        Program expectedBottomProgram = new Program("fbgguv", 57, Arrays.asList("bkomu", "tynxlau", "sfruur", "zxvbb", "khupkt", "xkntkvz"));

        assertThat(tower.getBottomProgram(), is(expectedBottomProgram));
    }

    @Test
    public void shoul_balanced_weight() {
        ProgramRepository programRepository = new ProgramRepositoryFile("input_day7.txt");
        Tower tower = new Tower(programRepository.getAllPrograms());
        Program bottomProgram = tower.getBottomProgram();


    }
}
