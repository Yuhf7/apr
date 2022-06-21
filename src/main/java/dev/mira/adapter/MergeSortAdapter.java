package dev.mira.adapter;


import dev.mira.algorithms.MergeSort;

import java.util.Comparator;
import java.util.List;

public class MergeSortAdapter implements SortingAlgorithm{
    @Override
    public <E> List<E> getList(List<E> list, Comparator<? extends E> comparator) {
        MergeSort<E> mergeSort = new MergeSort<E>();
        return null;
    }
}
