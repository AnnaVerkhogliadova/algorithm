package Anya_programist.allSortingAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements ISort{


    @Override
    public void sort(List<Integer> list) {
        List<Integer> temp = mergeSort(list);
        list.clear();
        list.addAll(temp);
    }

    private List<Integer> mergeSort(List<Integer> a) {
        if(a.size() <= 1){
            return a;
        }
        ArrayList<Integer> left = new ArrayList<>(); // левая половина
        ArrayList<Integer> right = new ArrayList<>(); // правая половина

        for (int i = 0; i < a.size(); ++i) {
            if (i < a.size() / 2) {  // если элемент лежит в левой половине
                left.add(a.get(i));
            } else {
                right.add(a.get(i));
            }
        }
        // возвращаем результат слияния
        // отсортированной левой половины
        // и отсортированной правой половины
        return merge(mergeSort(left), mergeSort(right));
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0; // i - первый элемент left, j - первый элемент right

        while (i < left.size() || j < right.size()) {
            // пока хотя бы в одном массиве есть элемент
            if (i < left.size() && (j == right.size() || left.get(i) < right.get(i))) {
                // левый элемент оказался лучше, если он:
                // во-первых, существует
                // во-вторых, правого либо не существует, либо он не меньше
                result.add(left.get(i));
                i++;
            } else {
                // иначе правый оказался лучше
                result.add(right.get(j));
                j++;
            }
        }
        return result;
    }
}
