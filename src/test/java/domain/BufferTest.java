package domain;

import infrastructure.FileRepositoryClassloader;
import infrastructure.TextFileReader;
import org.junit.Test;

import java.io.File;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BufferTest {

    @Test
    public void should_tick_properly() {
       Particule particule1 = new Particule(
               new Point3D(new Coordinate(3), new Coordinate(0), new Coordinate(0)),
               new Point3D(new Coordinate(2), new Coordinate(0), new Coordinate(0)),
               new Point3D(new Coordinate(-1), new Coordinate(0), new Coordinate(0))
       );

        Particule particule2 = new Particule(
                new Point3D(new Coordinate(4), new Coordinate(0), new Coordinate(0)),
                new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0)),
                new Point3D(new Coordinate(-2), new Coordinate(0), new Coordinate(0))
        );

        Particule particule1TickedOnce = new Particule(
                new Point3D(new Coordinate(4), new Coordinate(0), new Coordinate(0)),
                new Point3D(new Coordinate(1), new Coordinate(0), new Coordinate(0)),
                new Point3D(new Coordinate(-1), new Coordinate(0), new Coordinate(0))
        );

        Particule particule2TickedOnce = new Particule(
                new Point3D(new Coordinate(2), new Coordinate(0), new Coordinate(0)),
                new Point3D(new Coordinate(-2), new Coordinate(0), new Coordinate(0)),
                new Point3D(new Coordinate(-2), new Coordinate(0), new Coordinate(0))
        );

        particule1TickedOnce.setManathanDistance(new ManathanDistance(4));

        List<Particule> particules = new ArrayList<>();
        particules.add(particule1);
        particules.add(particule2);

        Buffer buffer = new Buffer(particules);

        buffer.tick();

        assertThat(particules.get(0), is(particule1TickedOnce));

        buffer.tick();

        assertThat(buffer.getClosestParticuleToZERO(), is(particules.get(1)));
    }

    @Test
    public void part1() {
        FileRepository fileRepository = new FileRepositoryClassloader();
        File file = fileRepository.loadFile("input.txt");

        TextReader textReader = new TextFileReader(file);

        List<String> lines = textReader.readLines();

        List<Particule> particules = new ArrayList<>();

        for (String line : lines) {
            ParticuleParser particuleParser = new ParticuleParser();
            Particule particule = particuleParser.parse(line);
            particules.add(particule);
        }

        Buffer buffer = new Buffer(particules);

        for (int i = 0; i < 1500; i++) {
            buffer.tick();
            System.out.print(i + " ");
            System.out.println(particules.size());
        }

    }
}