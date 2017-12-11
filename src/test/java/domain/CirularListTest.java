package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CirularListTest {

    @Test
    public void should_substring_circular() {
        CirularList circular = new CirularList(null, Arrays.asList(0, 1, 2, 3, 4));

        assertThat(circular.subList(3, 7), is(Arrays.asList(3, 4, 0, 1)));
    }

    @Test
    public void should_replace_circular() {
        CirularList circular = new CirularList(Arrays.asList(6, 7, 8, 9), Arrays.asList(0, 1, 2, 3, 4));

        circular.replace(3, Arrays.asList(6, 7, 8, 9));

        assertThat(circular.getValues(), is(Arrays.asList(8, 9, 2, 6, 7)));
    }

    @Test
    public void should_return_hash() {
        List<Integer> values = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> sequence = Arrays.asList(3, 4, 1, 5);

        CirularList cirularList = new CirularList(sequence, values);

        assertThat(cirularList.getHash(), is(12));
   }

   @Test
    public void part_1() {
       List<Integer> values = new ArrayList<>();
       for (int i = 0; i < 256; i++) {
           values.add(i);
       }
       List<Integer> sequence = Arrays.asList(192,69,168,160,78,1,166,28,0,83,198,2,254,255,41,12);

       CirularList cirularList = new CirularList(sequence, values);

       assertThat(cirularList.getHash(), is(12));
   }
}