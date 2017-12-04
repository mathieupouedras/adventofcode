package domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SpiralTest {

    @Test
    public void should_return_manathan_distance() {
        int location = 265149;
        double spiralSize = Math.sqrt(265149) + 1;
        Spiral spiral = new Spiral((int) spiralSize);

        spiral.grow(location);

        assertThat(spiral.getSteps(), is(438));
    }

    @Test
    public void should_return_manathan_distance_part2() {
        int location = 265149;
        double spiralSize = Math.sqrt(265149) + 20;
        Spiral spiral = new Spiral((int) spiralSize);

        spiral.growPart2(location);

        assertThat(spiral.getFirstLargerVayleThanInput(), is(266330));

    }


}
