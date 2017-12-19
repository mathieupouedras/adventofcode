package domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DanceParserTest {

    @Test
    public void shoud_create_exchange_1_5() {
        String line = "x15/5";
        Dance expectedDance = new Exchange(15, 5);

        DanceParser danceParser = new DanceParser();
        Dance exchange = danceParser.parseDance(line);

        assertThat(exchange, is(expectedDance));

    }

    @Test
    public void should_create_spin_13() {
        String line = "s13";
        Dance expectedDance = new Spin(13);

        DanceParser danceParser = new DanceParser();
        Dance exchange = danceParser.parseDance(line);

        assertThat(exchange, is(expectedDance));
    }

    @Test
    public void should_create_partner_j_k() {
        String line = "pj/k";
        Dance expectedDance = new Partner("j", "k");

        DanceParser danceParser = new DanceParser();
        Dance exchange = danceParser.parseDance(line);

        assertThat(exchange, is(expectedDance));
    }



}