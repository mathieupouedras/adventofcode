package domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RowTest {

    @Test
    public void should_return_division_of_the_two_evenly_divisible_values() {
        String data = "5 9 2 8";

        Row row = new Row(data);

        assertThat(row.divideTheTwoEvenlyDivisibleValues(), is(4));
    }

    @Test(expected = MissingTwoEvenlyValuesDivisibleExeption.class)
    public void should_throw_exception_when_no_values_are_evenly_divisible(){
        String data = "9 5 4 13";

        Row row = new Row(data);

        row.divideTheTwoEvenlyDivisibleValues();
    }

    @Test
    public void should_create_row_1_2_3_4() {
        String data = "1 2 3 4";
        Row row = new Row(data);

        assertThat(row.toString(), is("Row{numbers=[1, 2, 3, 4]}"));

    }

    @Test
    public void should_return_smallest_value() {
        String data = "3 8 33 2 666 76";
        Row row = new Row(data);

        assertThat(row.getSmallestValue(), is(2));
    }

    @Test
    public void should_return_largest_value() {
        String data = "3 8 33 2 669 76";
        Row row = new Row(data);

        assertThat(row.getLargestValue(), is(669));
    }

    @Test
    public void should_return_checksum() {
        String data = "3 8 33 2 669 76";
        Row row = new Row(data);

        assertThat(row.checksum(), is(667));
    }

}