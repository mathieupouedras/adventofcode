package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DanceTest {

    @Test
    public void should_makes_3_programs_move_from_the_end_to_the_front() {
        List<Program> programs = new ArrayList<>();
        for (char name = 'a'; name <= 'e'; name++) {
            programs.add(new Program(String.valueOf(name)));
        }

        List<Program> expectedPrograms = Arrays.asList(new Program[]{
                new Program("c"),
                new Program("d"),
                new Program("e"),
                new Program("a"),
                new Program("b")
        });

        Dance spin = new Spin(3);
        spin.execute(programs);

        assertThat(programs, is(expectedPrograms));

    }

    @Test
    public void should_swap_3_and_4() {
        List<Program> programs = new ArrayList<>();
        for (char name = 'a'; name <= 'e'; name++) {
            programs.add(new Program(String.valueOf(name)));
        }

        List<Program> expectedPrograms = Arrays.asList(new Program[]{
                new Program("a"),
                new Program("b"),
                new Program("c"),
                new Program("e"),
                new Program("d")
        });

        Dance exchange = new Exchange(3, 4);
        exchange.execute(programs);

        assertThat(programs, is(expectedPrograms));
    }

    @Test
    public void should_makes_the_programs_named_a_and_b_swap_places() {
        List<Program> programs = new ArrayList<>();
        for (char name = 'a'; name <= 'e'; name++) {
            programs.add(new Program(String.valueOf(name)));
        }

        List<Program> expectedPrograms = Arrays.asList(new Program[]{
                new Program("b"),
                new Program("a"),
                new Program("c"),
                new Program("d"),
                new Program("e")
        });

        Dance partner = new Partner("a", "b");
        partner.execute(programs);

        assertThat(programs, is(expectedPrograms));
    }

}