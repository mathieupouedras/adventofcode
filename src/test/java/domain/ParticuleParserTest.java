package domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParticuleParserTest {

    @Test
    public void test() {
        Particule expectedParticule = new Particule(
                new Point3D(new Coordinate(-951), new Coordinate(-1228), new Coordinate(3140)),
                new Point3D(new Coordinate(-10), new Coordinate(94), new Coordinate(-118)),
                new Point3D(new Coordinate(5), new Coordinate(-3), new Coordinate(-3))
        );

        ParticuleParser particuleParser = new ParticuleParser();
        Particule particule = particuleParser.parse("p=<-951,-1228,3140>, v=<-10,94,-118>, a=<5,-3,-3>");

        assertThat(particule, is(expectedParticule));
    }

}