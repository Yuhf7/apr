package dev.mira.adapter;


import dev.mira.algorithms.BubbleSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BubbleSortAdapter implements SortingAlgorithm {


    @Override
    public <E> List<E> getList(List<E> list, Comparator<? extends E> comparator) {
        BubbleSort<E> mergeSort = new BubbleSort<E>();
        return null;
    }

    @Override
    public List<Integer> getList(int[] list, Comparator<Integer> comparator) {
        BubbleSort<Integer> bubbleSort = new BubbleSort<>(Integer.class);
        var ret = bubbleSort.bubbleSort(Arrays.stream(list).boxed().toArray(Integer[]::new), comparator);

        return Arrays.stream(ret).collect(Collectors.toList());
    }

}
