package domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class SpreadsheetParser {
    private final File data;

    SpreadsheetParser(File data) {
        if (!data.exists()) {
            throw new InputFileNotFoundException();
        }
        this.data = data;
    }

    List<Row> parse() {
        List<Row> rows = new ArrayList<>();

        try (Scanner scanner = new Scanner(data)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Row row = new Row(line);
                rows.add(row);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return rows;
    }

    List<String> parseLines() {
        List<String> lines = new ArrayList<>();

        try (Scanner scanner = new Scanner(data)) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return lines;
    }

    Integer[] parseInt() {
        List<Integer> values = new ArrayList<>();
        try (Scanner scanner = new Scanner(data)) {
            while (scanner.hasNextInt()) {
                values.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return values.toArray(new Integer[values.size()]);
    }
}
