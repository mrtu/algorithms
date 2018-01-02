package guru.mrtu.algorithms.sorting;

import java.util.Arrays;
import java.util.Collection;

public class QuickSort<T extends Comparable<T>> implements Sorter<T> {

    @SuppressWarnings("unchecked")
    public Collection<T> sort(Collection<T> collection) {
        T[] array = collection.toArray((T[]) new Comparable[collection.size()]);
        quickSort(array, 0, collection.size() - 1);
        return Arrays.asList(array);
    }

    private void quickSort(T[] collection, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(collection, lo, hi);
            quickSort(collection, lo, pivot - 1);
            quickSort(collection, pivot + 1, hi);
        }
    }

    private int partition(T[] collection, int lo, int hi) {
        T pivot = collection[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (collection[j].compareTo(pivot) < 0) {
                i++;
                swap(collection, i, j);
            }
        }
        if (collection[hi].compareTo(collection[i + 1]) < 0) {
            swap(collection, i + 1, hi);
        }
        return i + 1;
    }

    private void swap(T[] collection, int i, int j) {
        T aux = collection[i];
        collection[i] = collection[j];
        collection[j] = aux;
    }
}
