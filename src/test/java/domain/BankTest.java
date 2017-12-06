package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class BankTest {

    @Test
    public void curiosity() {
        Bank bank = new Bank(new int[]{0, 2, 7, 0});

        assertThat(bank.curiosity(), is(4));

    }

    @Test
    public void submit_part2() {
        String input = "0\t5\t10\t0\t11\t14\t13\t4\t11\t8\t8\t7\t1\t4\t12\t11";

        Bank bank = new Bank(16, input);

        assertThat(bank.curiosity(), is(1695));
    }


    @Test
    public void submit_part1() {
        String input = "0\t5\t10\t0\t11\t14\t13\t4\t11\t8\t8\t7\t1\t4\t12\t11";

        Bank bank = new Bank(16, input);

        assertThat(bank.detectInfiniteLoop(), is(7864));
    }

    @Test
    public void detectInfiniteLoop() {
        Bank bank = new Bank(new int[]{0, 2, 7, 0});

        assertThat(bank.detectInfiniteLoop(), is(5));
    }

    @Test
    public void should_redistribute_blocks() {
        Bank bank = new Bank(new int[]{0, 2, 7, 0});
        bank.redistributeBlocks();

        assertThat(bank.getBlocks(), is(new int[]{2, 4, 1, 2}));
    }

    @Test
    public void should_instantiate_bank_from_string() {
        String input = "0\t5\t10\t0\t11\t14\t13\t4\t11\t8\t8\t7\t1\t4\t12\t11";

        Bank bank = new Bank(16, input);

        int[] expectedBlocks = {0,5,10,0,11,14,13,4,11,8,8,7,1,4,12,11};

        assertThat(bank.getBlocks(), is(expectedBlocks));
    }

    @Test
    public void should_return_index_with_most_blocks() {
        String input = "0\t5\t10\t0\t11\t14\t13\t4\t11\t8\t8\t7\t1\t4\t12\t11";

        Bank bank = new Bank(16, input);

        assertThat(bank.getIndexWithMostBlocs(), is(5));
    }


}