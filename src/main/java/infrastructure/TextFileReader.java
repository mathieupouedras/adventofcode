package infrastructure;

import domain.TextReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileReader implements TextReader {

    private final File file;

    public TextFileReader(File file) {
        this.file = file;
    }

    @Override
    public List<String> readLines() {
        List<String> lines = new ArrayList<>();
        try(Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(String.format("Cannot create scanner for file : %s", file.getName()));
        }

        return lines;
    }
}
