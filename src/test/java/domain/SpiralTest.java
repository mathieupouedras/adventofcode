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

        assertThat(spiral.getSteps(), is(31));
    }

}
