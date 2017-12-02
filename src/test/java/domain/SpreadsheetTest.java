package domain;

import domain.InputFileNotFoundException;
import domain.Spreadsheet;
import org.junit.Test;

import java.io.File;


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

        new Spreadsheet(file);

    }

    @Test
    public void submit() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("input.txt").getFile());

        Spreadsheet spreadsheet = new Spreadsheet(file);

        System.out.println(spreadsheet.checksum());
    }
}
