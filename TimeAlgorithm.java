package Anya_programist.allSortingAlgorithm;

import Anya_programist.functionInterface.Function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TimeAlgorithm {
    private static final Random RANDOM = new Random();

    private List<Integer> list = new ArrayList<>();

    private final ISort sortAlgorithm;
    private final int retryCount;
    private final int elementsSize;

    public TimeAlgorithm(ISort sortAlgorithm, int retryCount, int elementsSize) {
        this.sortAlgorithm = sortAlgorithm;
        this.retryCount = retryCount;
        this.elementsSize = elementsSize;
    }

    public double countingTheTimeSort() {
        long sum = 0;
        for (int i = 0; i < retryCount; i++) {
            build();
            long startTime = System.currentTimeMillis();
            sortAlgorithm.sort(list);
            long endTime = System.currentTimeMillis();
            sum += endTime - startTime;
        }
        return (double) sum / retryCount;
    }

    private void build(){
        list = new ArrayList<>();
        for (int i = 0; i < elementsSize; i++) {
            list.add(RANDOM.nextInt());
        }
    }

    public static void main(String[] args) {
        int retryCount = 3;
        int elementsSize = 10000;
        TimeAlgorithm bubble = new TimeAlgorithm(new Bubble(), retryCount, elementsSize);
        TimeAlgorithm insertion = new TimeAlgorithm(new InsertionSort(), retryCount, elementsSize);
        TimeAlgorithm merge = new TimeAlgorithm(new MergeSort(), retryCount, elementsSize);
        TimeAlgorithm quick = new TimeAlgorithm(new QuickSort(), retryCount, elementsSize);

        System.out.printf("Bobble : %s, Insertion: %s, Merge: %s, Quick: %s",
                bubble.countingTheTimeSort(),
                insertion.countingTheTimeSort(),
                merge.countingTheTimeSort(),
                quick.countingTheTimeSort());
    }

}
