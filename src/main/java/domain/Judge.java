package domain;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class Judge {

    private Match matches;

    private final Generator generatorA;
    private final Generator generatorB;

    Judge(Generator generatorA, Generator generatorB) {
        this.generatorA = generatorA;
        this.generatorB = generatorB;
    }

    void consider(Pair pairs) {
        Queue<SequenceOfNumber> queueA = new LinkedList<>();
        Queue<SequenceOfNumber> queueB = new LinkedList<>();
        int count = 0;
        int iterations = 0;
        while (iterations < pairs.getValue()) {
            SequenceOfNumber sequenceOfNumberA = generatorA.generate();
            SequenceOfNumber sequenceOfNumberB = generatorB.generate();

            if (generatorA.isValueAvailable()) {
                queueA.add(sequenceOfNumberA);
            }

            if (generatorB.isValueAvailable()) {
                queueB.add(sequenceOfNumberB);
            }

            if (!queueA.isEmpty() && !queueB.isEmpty()) {
                iterations++;
                if (queueA.poll().getValue().and(BigInteger.valueOf(0xFFFF)).equals(queueB.poll().getValue().and(BigInteger.valueOf(0xFFFF)))) {
                    count++;
                }
            }
        }
        this.matches =  new Match(count);
    }

    Match getMatches() {
        return matches;
    }
}
