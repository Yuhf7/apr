package dev.mira.adapter;

import dev.mira.algorithms.MergeSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSortAdapter implements SortingAlgorithm{
    @Override
    public <E> List<E> getList(List<E> list, Comparator<? extends E> comparator) {
        MergeSort<E> mergeSort = new MergeSort<E>();
        return null;
    }

    @Override
    public List<Integer> getList(int[] list, Comparator<Integer> comparator) {
        MergeSort<Integer> mergeSort = new MergeSort<>(Integer.class);
        var ret = mergeSort.mergeSort(Arrays.stream(list).boxed().toArray(Integer[]::new), comparator);

        return Arrays.stream(ret).collect(Collectors.toList());
    }
}
