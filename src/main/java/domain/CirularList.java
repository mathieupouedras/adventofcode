package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CirularList {

    private final List<Integer> values;
    private int currentPositon;
    private int skip;

    private final List<Integer> sequence;

    public CirularList(List<Integer> sequence, List<Integer> values) {
        this.sequence = sequence;
        this.values = values;
        currentPositon = 0;
        skip = 0;
    }

    public List subList(int fromIndex, int toIndex) {
        List sublist = new ArrayList();
        if (toIndex > values.size()) {
            for (int i = fromIndex; i < values.size(); i++) {
                sublist.add(values.get(i));
            }
            for (int i = 0; i < toIndex - values.size(); i++) {
                sublist.add(values.get(i));
            }
            return sublist;
        }

        return new ArrayList(values.subList(fromIndex, toIndex));
    }

    public boolean addAll(int index, Collection c) {
        return values.addAll(index, c);
    }

    public boolean addAll(Collection collection) {
        return values.addAll(collection);
    }

    public void replace(int fromIndex, List<Integer> replacement) {
        for (int i = 0; i < replacement.size(); i++) {
            if (i + fromIndex < values.size()) {
                values.set(i + fromIndex, replacement.get(i));
            }
            else {
                values.set(i + fromIndex - values.size(), replacement.get(i));
            }
        }
    }

    public List<Integer> getValues() {
        return values;
    }


    public int getHash() {
        for (int i = 0; i < sequence.size(); i++) {
            List<Integer> replacement = this.subList(currentPositon, currentPositon + sequence.get(i));
            Collections.reverse(replacement);
            this.replace(currentPositon, replacement);
            moveCurrentPosition(i);
            skip++;
        }

        return values.get(0) * values.get(1);
    }

    private void moveCurrentPosition(int i) {
        System.out.println(currentPositon);
        if (currentPositon + sequence.get(i) + skip > values.size()) {
            currentPositon = currentPositon + sequence.get(i) + skip - values.size();
        }
        else {
            currentPositon += sequence.get(i) + skip;
        }
        System.out.println(currentPositon);
    }

    public int part2() {
        for (int i = 0; i < 64; i++) {
            getHash();
        }

        return 0;
    }
}
