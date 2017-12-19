package domain;

import java.math.BigInteger;

class Judge {

    private Match matches;

    private final Generator generatorA;
    private final Generator generatorB;

    Judge(Generator generatorA, Generator generatorB) {
        this.generatorA = generatorA;
        this.generatorB = generatorB;
    }

    void consider(Pair pairs) {
        int count = 0;
        for (int i = 0; i < pairs.getValue(); i++) {
            if (generatorA.generate().getValue().and(BigInteger.valueOf(0xFFFF)).equals(generatorB.generate().getValue().and(BigInteger.valueOf(0xFFFF)))) {
                count++;
            }
        }
        this.matches =  new Match(count);
    }

    Match getMatches() {
        return matches;
    }
}
