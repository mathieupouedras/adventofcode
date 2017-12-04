package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Passphrase {

    private final String value;

    Passphrase(String value) {
        this.value = value;
    }

    boolean isValid() {
        final String[] tokens = value.split("\\s");
        List<String> words = new ArrayList();

        for (String token : tokens) {
            if (words.contains(token)) {
                return false;
            }
            words.add(token);
        }

        return true;
    }
}
