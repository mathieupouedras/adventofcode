package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Bank {
    private int[] blocks;
    private final int size;
    private final List<int[]> previsiousDistributions;

    public Bank(int size) {
        this.size = size;
        previsiousDistributions = new ArrayList<>();
    }

    Bank(int size, String input) {
        this.size = size;
        blocks = new int[size];
        String[] tokens = input.split("\\s");
        for (int i = 0; i < tokens.length; i++) {
            blocks[i] = Integer.parseInt(tokens[i]);
        }
        previsiousDistributions = new ArrayList<>();
    }

    public Bank(int[] blocks) {
        this.size = blocks.length;
        this.blocks = blocks;
        previsiousDistributions = new ArrayList<>();
    }

    int[] getBlocks() {
        return blocks;
    }

    int getIndexWithMostBlocs() {
        int maxIndex = 0;
        for (int i = 1; i < blocks.length; i++) {
            if (blocks[i] > blocks[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    void redistributeBlocks() {
        int indexMaxBlocks = getIndexWithMostBlocs();
        int maxBlock = blocks[indexMaxBlocks];
        blocks[indexMaxBlocks] = 0;
        int updateIndex = indexMaxBlocks;
        for (int i = 1; i <= maxBlock; i++) {
            updateIndex = updateIndex + 1;
            if (updateIndex > blocks.length - 1) {
                updateIndex = 0;
            }
            blocks[updateIndex] = blocks[updateIndex] + 1;
        }

    }

    int curiosity() {
        detectInfiniteLoop();
        previsiousDistributions.clear();
        int result = detectInfiniteLoop();
        return result;
    }

    int detectInfiniteLoop() {
        int cyles = 0;
        while (true) {
            int[] previousDistribution = blocks.clone();
            previsiousDistributions.add(previousDistribution);
            redistributeBlocks();
            cyles++;
            if (isEqualToPreviousDistribution(blocks)) {
                break;
            };
        }

        return cyles;
    }

    boolean isEqualToPreviousDistribution(int[] currentDistribution) {
        for (int[] distribution: previsiousDistributions) {
            if (Arrays.equals(distribution, currentDistribution)) {
                return true;
            }
        }
        return false;
    }
}
