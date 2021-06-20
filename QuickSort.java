package Anya_programist.allSortingAlgorithm;

import java.util.List;

public class QuickSort implements ISort {

    @Override
    public void sort(List<Integer> list) {
        quickSort(list, 0, list.size() - 1);
    }

    private void quickSort(List<Integer> a, int l, int r) {
        if (l >= r - 1) { // пустой отрезок или состоящий из одного элемента
            return;
        }
        int mid = partition(a, l, r); // опорный элемент
        quickSort(a, l, mid);
        quickSort(a, mid + 1, r);
    }

    private int partition(List<Integer> a, int l, int r) {
        int pivot = a.get((l + r) / 2); // выбрали опорный элемент
        int i = l, j = r - 1;

        while (true) {
            while (a.get(i) < pivot) { // пока текущий элемент соответствует левой части
                i++; // двигаем указатель влево
            }

            while (a.get(j) > pivot) { // пока текущий элемент соответствует правой части
                j--; // двигаем указатель вправо
            }

            if (i < j) { // если столкнулись с инверсией
                int temp = a.get(i);
                a.set(i, a.get(j)); // решаем ее
                a.set(j, temp);
            } else {
                break; // иначе выходим из цикла
            }
        }
        return j;
    }

}
