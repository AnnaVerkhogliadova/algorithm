package Anya_programist.allSortingAlgorithm;

import java.util.List;

public class InsertionSort implements ISort {

    @Override
    public void sort(List<Integer> a) {
        for (int i = 0; i < a.size(); ++i) {
            for (int j = i; j > 0; --j) {
                if (a.get(j) < a.get(j - 1)) {
                    // меняем элементы местами
                    int temp = a.get(j);
                    a.set(j, a.get(j - 1));
                    a.set(j - 1, temp);
                }
            }
        }
    }
}
