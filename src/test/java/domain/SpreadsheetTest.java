package domain;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SpreadsheetTest {
    @Test(expected= InputFileNotFoundException.class)
    public void should_throw_exception_when_file_does_not_exist() {
        File file = new File("UNKNOWN_PATH");
        new Spreadsheet(file);
    }

    @Test
    public void should_compute_checksum() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("input.txt").getFile());

        Spreadsheet spreadsheet = new Spreadsheet(file);

        System.out.println(String.format("My result part 1 is : %s", spreadsheet.checksum()));

        assertThat(spreadsheet.checksum(), is(42299));
    }

    @Test
    public void should_compute_evenlyDivisibleChecksum() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("input.txt").getFile());

        Spreadsheet spreadsheet = new Spreadsheet(file);

        System.out.println(String.format("My result part 2  is : %s", spreadsheet.evenlyDivisibleChecksum()));

        assertThat(spreadsheet.evenlyDivisibleChecksum(), is(277));
    }

}
