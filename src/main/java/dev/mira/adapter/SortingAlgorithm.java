package dev.mira.adapter;

import java.util.Comparator;
import java.util.List;

public interface SortingAlgorithm extends Reflectable {

    public <E> List<E> getList(List<E> list, Comparator<? extends E> comparator);
}
