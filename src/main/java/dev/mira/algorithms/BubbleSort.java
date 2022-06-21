package dev.mira.algorithms;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.util.Comparator;

public class BubbleSort<E> {
    private Class<E> type;
    private Comparator<? super E> comparator;

    @SuppressWarnings("unchecked")
    public BubbleSort(){
        this.type = (Class<E>)
                ((ParameterizedType)getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];
    }

    /**
     *
     * @param classType class type
     * @param list list
     * @param comparator comparator
     * @return a bubble sorted array
     */
    public E[] bubbleSort(E[] list, Comparator<? super E> comparator) {
        this.comparator = comparator;
        E[] copy = copyArray(list, 0, list.length);
        sort(copy);
        return copy;
    }

    /**
     *
     * @param original original list
     * @param start first entrance of the list
     * @param end last entrance of the list
     * @return an array, copy of the list
     */
    @SuppressWarnings("unchecked")
    private E[] copyArray(E[] original, int start, int end) {
        E[] ret = (E[]) Array.newInstance(type, end);
        for (int i = 0; i < end; ++i)
            ret[i] = original[start + i];

        return ret;
    }

    /**
     * this method bubble sorts an array
     * @param arr array
     */
    private void sort(E[] arr) {
        E temp;
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = 1; j < (arr.length - i); j++) {
                if (comparator.compare(arr[j - 1], arr[j]) > 0) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
