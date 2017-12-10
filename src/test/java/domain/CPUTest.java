package domain;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.assertThat;

public class CPUTest {

    @Test
    public void should_parse() {
        CPU cpu = new CPU();

        List<String> lines = cpu.parse("input_short.txt");

        assertThat(lines.toString(), is("[b inc 5 if a > 1, a inc 1 if b < 5, c dec -10 if a >= 1, c inc -20 if c == 10]"));
    }

    @Test
    public void submit() {
        CPU cpu = new CPU();

        cpu.execute("input.txt");

        assertThat(cpu.getLargestRegisterValue(), is(1));
    }

    @Test
    public void should_return_highest_value() {

        CPU cpu = new CPU();

        cpu.execute("input.txt");

        assertThat(cpu.getHighestValue(), is(5391));
    }


}