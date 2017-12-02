package domain;


import java.io.File;
import java.util.List;

public class Spreadsheet {
    private final List<Row> rows;

    public Spreadsheet(File input) {
        SpreadsheetParser spreadsheetParser = new SpreadsheetParser(input);
        this.rows = spreadsheetParser.parse();
    }

    public int checksum() {
        return rows.stream().mapToInt(Row::checksum).sum();
    }


    public int evenlyDivisibleChecksum() {
        return rows.stream().mapToInt(Row::divideTheTwoEvenlyDivisibleValues).sum();
    }
}
