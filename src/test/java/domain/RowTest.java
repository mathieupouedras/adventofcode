package domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RowTest {

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