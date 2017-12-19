package domain;

import infrastructure.FileRepositoryClassloader;
import infrastructure.TextFileReader;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GroupTest {
    @Test
    public void should_return_bacde() {
        List<Program> programs = Arrays.asList(new Program[]{
                new Program("b"),
                new Program("a"),
                new Program("c"),
                new Program("d"),
                new Program("e")});

        Group group = new Group(programs);

        assertThat(group.getOrderStringRepresentation(), is ("bacde"));
    }

    @Test
    public void should_get_order_string_representation() {
        List<Program> programs = new ArrayList<>();
        for (char name = 'a'; name <= 'p'; name++) {
            Program program = new Program(String.valueOf(name));
            programs.add(program);
        }

        Group group = new Group(programs);

        assertThat(group.getOrderStringRepresentation(), is("abcdefghijklmnop"));
    }

    @Test
    public void should_execute_dance() {
        List<Program> programs = new ArrayList<>();
        for (char name = 'a'; name <= 'p'; name++) {
            Program program = new Program(String.valueOf(name));
            programs.add(program);
        }

        Group group = new Group(programs);

        FileRepository fileRepository = new FileRepositoryClassloader();
        File file = fileRepository.loadFile("input.txt");



        TextReader textReader = new TextFileReader(file);

        List<String> lines = textReader.readLines();

        DanceParser danceParser = new DanceParser();

        List<Dance> dances = danceParser.parse(lines.get(0));

        group.execute(dances);

        assertThat(group.getOrderStringRepresentation(), is("abcd"));

    }

}