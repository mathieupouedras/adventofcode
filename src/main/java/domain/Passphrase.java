package domain;

import java.util.*;

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

    boolean isSuperValide() {
        if (!isValid()) {
            return false;
        }

        final String[] tokens = value.split("\\s");
        List<String> words = new ArrayList();

        for (String token : tokens) {
            words.add(token);
        }

        for (String token : tokens) {
            for (String anagram : tokens) {
                if (token.equals(anagram)) {
                    continue;
                }

                if (token.length() != anagram.length()) {
                    continue;
                }

                if (isAnagram(token, anagram)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isAnagram(String token, String anagram) {
        char[] tokenChar = token.toCharArray();
        char[] tokenAnagram = anagram.toCharArray();
        Arrays.sort(tokenChar);
        Arrays.sort(tokenAnagram);

        for (int i = 0; i < tokenChar.length; i++) {
            if (tokenChar[i] != tokenAnagram[i]) {
                return false;
            }
        }

        return true;
    }
}
