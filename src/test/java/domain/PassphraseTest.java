package domain;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PassphraseTest {

    @Test
    public void should_return_true_if_valid() {
        String line = "aa bb cc dd aaa";

        Passphrase passphrase = new Passphrase(line);

        assertThat(passphrase.isValid(), is(true));
    }

    @Test
    public void should_return_false_if_not_valid() {
        String line = "aa bb cc dd aa";

        Passphrase passphrase = new Passphrase(line);

        assertThat(passphrase.isValid(), is(false));
    }

    @Test
    public void should_count_valid_passphrases() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("input_day4.txt").getFile());

        SpreadsheetParser parser = new SpreadsheetParser(file);

        int valids = 0;

        for (String line : parser.parseLines()) {
            Passphrase passphrase = new Passphrase(line);
            if (passphrase.isValid()) {
                valids++;
            }
        }

        assertThat(valids, is(325));
    }

}
