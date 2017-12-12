package domain;

import infrastructure.FileRepositoryClassloader;
import infrastructure.TextFileReader;
import org.junit.Test;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class VillageTest {

    @Test
    public void should_crate_village_with_create_nice_village() {
        FileRepository fileRepository = new FileRepositoryClassloader();
        File file = fileRepository.loadFile("input_short.txt");

        TextReader textReader = new TextFileReader(file);
        Set<Pipe> pipes = new HashSet();

        for(String line : textReader.readLines()) {
            pipes.addAll(PipeFactory.create(line));
        }

        System.out.println(pipes);
        assertThat(pipes.size(), is(7));
    }


}