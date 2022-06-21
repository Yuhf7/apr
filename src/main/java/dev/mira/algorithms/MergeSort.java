package dev.mira.algorithms;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.util.Comparator;


public class MergeSort<E> {
    private Class<E> type;
    private Comparator<? super E> comparator;

    @SuppressWarnings("unchecked")
    public MergeSort(){
        this.type = (Class<E>)
                ((ParameterizedType)getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];
    }

    public MergeSort(Class<E> clazz)
    {
        this.type = clazz;
    }


    /**
     *
     * @param list list
     * @param comparator comparator
     * @return a merge sorted array
     */
    public E[] mergeSort( E[] list, Comparator<? super E> comparator) {
        this.comparator = comparator;
        E[] copy = copyArray(list, 0, list.length);
        sort(copy, 0, list.length - 1);
        return copy;
    }

    /**
     *
     * @param original original
     * @param start first entrance of the array
     * @param end last entrance of the array
     * @return an array, copy of the list
     */
    @SuppressWarnings("unchecked")
    private E[] copyArray(E[] original, int start, int end) {
        E[] ret = (E[]) Array.newInstance(type, end);
        for (int i=0; i<end; ++i)
            ret[i] = original[start + i];

        return ret;
    }

    /**
     * Divides the beginning array until it becomes N 1-lengthed arrays
     * Merge all the N 1-lengthed arrays,ordering them into the initial length array
     * @param arr array
     * @param start first entrance of the working subarray
     * @param end last entrance of the working subarray
     */
    private void sort(E[] arr, int start, int end) {
        if (start < end) {
            // Find the middle point
            int middle = (start+end)/2;

            // Sort first and second halves
            sort(arr, start, middle);
            sort(arr,middle+1, end);

            // Merge the sorted halves
            merge(arr, start, middle, end);
        }
    }

    /**
     *
     * @param arr array
     * @param start first entrance of the array
     * @param middle middle entrance of the array
     * @param end last entrance of the array
     */
    private void merge(E[] arr, int start, int middle, int end)
    {
        // Find sizes of two subarrays to be merged
        int sizeLeft = middle - start + 1;
        int sizeRight = end - middle;

        /*Copy data to temp arrays*/
        E[] LeftPartArr = copyArray(arr, 0, sizeLeft);
        E[] RightPartArr = copyArray(arr, middle + 1, sizeRight);

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = start;
        while (i < sizeLeft && j < sizeRight) {
            if (this.comparator.compare(LeftPartArr[i], RightPartArr[j]) < 0) {
                arr[k] = LeftPartArr[i];
                i++;
            } else {
                arr[k] = RightPartArr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of LeftPartArr[] if any
        while (i < sizeLeft) {
            arr[k] = LeftPartArr[i];
            i++;
            k++;
        }

        // Copy remaining elements of RightPartArr[] if any
        while (j < sizeRight) {
            arr[k] = RightPartArr[j];
            j++;
            k++;
        }
    }
}
