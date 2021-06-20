package Anya_programist.allSortingAlgorithm;

import java.util.List;

public class Bubble implements ISort {

    @Override
    public void sort(List<Integer> a) {
        while (true) {
            boolean wasSwap = false;
            for (int i = 0; i < a.size() - 1; ++i) {
                if (a.get(i + 1) < a.get(i)) {
                    // меняем элементы местами
                    int temp = a.get(i);
                    a.set(i, a.get(i + 1));
                    a.set(i + 1, temp);

                    wasSwap = true;
                }
            }
            if (!wasSwap) break;
        }
    }
}
