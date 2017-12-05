package domain;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class InstructionsMazeTest {

    @Test
    public void should_count_steps_to_exit() {
        Integer[] instructions =  {0, 3,  0, 1,  -3};

        InstructionsMaze instructionsMaze = new InstructionsMaze(instructions);

        assertThat(instructionsMaze.stepsToExit(), is(5));
    }

    @Test
    public void submit() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("input_day5.txt").getFile());

        SpreadsheetParser parser = new SpreadsheetParser(file);

        Integer[] instructions = parser.parseInt();
        InstructionsMaze instructionsMaze = new InstructionsMaze(instructions);

        assertThat(instructionsMaze.stepsToExit(), is(374269));
    }

    @Test
    public void should_count_steps_to_exit_strange_jumps() {
        Integer[] instructions =  {0, 3,  0, 1,  -3};

        InstructionsMaze instructionsMaze = new InstructionsMaze(instructions);

        assertThat(instructionsMaze.stepsToExitStrangeJumps(), is(10));
    }

    @Test
    public void submit_part2() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("input_day5.txt").getFile());

        SpreadsheetParser parser = new SpreadsheetParser(file);

        Integer[] instructions = parser.parseInt();
        InstructionsMaze instructionsMaze = new InstructionsMaze(instructions);

        assertThat(instructionsMaze.stepsToExitStrangeJumps(), is(27720699));
    }

}
