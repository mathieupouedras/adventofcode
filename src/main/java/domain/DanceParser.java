package domain;

import java.util.ArrayList;
import java.util.List;

class DanceParser {
    Dance parseDance(String line) {

        String danceType = line.substring(0, 1);

        switch (danceType) {
            case "x": return createExchange(line);
            case "s": return createSpin(line);
            case "p": return createPartner(line);
            default: throw new IllegalArgumentException(String.format("Cannot create dance from %s", line));
        }

    }

    private Dance createPartner(String line) {
        String partners = line.substring(1, line.length());
        String[] tokens = partners.split("/");

        return new Partner(tokens[0], tokens[1]);
    }

    private Dance createSpin(String line) {
        return new Spin(Integer.valueOf(line.substring(1, line.length())));
    }

    private Dance createExchange(String line) {
        String positions = line.substring(1, line.length());
        String[] tokens = positions.split("/");
        return new Exchange(Integer.valueOf(tokens[0]), Integer.valueOf(tokens[1]));
    }

    List<Dance> parse(String s) {
        List<Dance> dances = new ArrayList<>();

        String[] tokens = s.split(",");
        for (String token : tokens) {
            dances.add(parseDance(token));
        }

       return dances;
    }
}
