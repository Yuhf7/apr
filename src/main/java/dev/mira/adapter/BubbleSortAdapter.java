package dev.mira.adapter;


import dev.mira.algorithms.BubbleSort;
import java.util.Comparator;
import java.util.List;

public class BubbleSortAdapter implements SortingAlgorithm {


    @Override
    public <E> List<E> getList(List<E> list, Comparator<? extends E> comparator) {
        BubbleSort<E> mergeSort = new BubbleSort<E>();
        return null;
    }
}
