package infrastructure;

import domain.Program;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class FileParser {
    private static final String MAIN_SEPARATOR = " -> ";
    private static final String WEIGHT_SEPARATOR = " ";
    private static final String PROGRAMS_ABOVE_SEPARATOR = ", ";
    private final File file;

    FileParser(File file) {
        this.file = file;
    }

    Program parseLine(String line) {
        String[] tokens = line.split(MAIN_SEPARATOR);

        String[] tokensProgram = tokens[0].split(WEIGHT_SEPARATOR);
        String programName = tokensProgram[0];
        int programWeight = Integer.parseInt(tokensProgram[1].substring(1, tokensProgram[1].length() - 1));
        List<String> aboveProgramsName = new ArrayList<>();
        if (tokens.length == 2) {
            String[] tokensAboveProgram = tokens[1].split(PROGRAMS_ABOVE_SEPARATOR);
            aboveProgramsName.addAll(Arrays.asList(tokensAboveProgram));
        }
        return new Program(programName, programWeight, aboveProgramsName);
    }

    List<Program> parse() {
        List<Program> programs = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()) {
                programs.add(parseLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return programs;
    }
}
