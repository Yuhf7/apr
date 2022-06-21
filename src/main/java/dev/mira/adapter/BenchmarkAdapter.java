package dev.mira.adapter;

import com.isep.mdis.Sum;

import dev.mira.mapper.PerformanceMapper;
import dev.mira.mapper.dto.PerformanceDTO;

/**
 * BenchmarkAdapter
 */
public class BenchmarkAdapter implements SubsequenceAlgorithm {

    public BenchmarkAdapter()
    {
    }

    /**
     * Calculates the sum of the entries of an array
     * @param arr the array to calculate the sum of
     * @return the sum of the elements of the array
    */
    private int getSum(int[] arr)
    {
        int i;
        int sum = 0;

        for (i = 0; i < arr.length; ++i)
            sum += arr[i];

        return sum;
    }

    public int[] computeSublist(int[] list)
    {
        return Sum.Max(list);
    }

    private int[] locateSublist(int[] original, int[] subList)
    {
        int i, j, n, m, c;

        int[] indexes = new int[2];

        c = 0;
        n = original.length;
        m = subList.length;

        for (i = 0; i < n && c < m; i++)
            if (subList[i] == original[i]) {
                c = 1;
                indexes[0] = i;

                for (j = i + 1; j < i + m; j++)
                    if (subList[j] == original[j])
                        c++;

                indexes[1] = j;
            }

        return indexes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PerformanceDTO getSublistInfo(int[] listOfDifferences)
    {
        int sum;
        int[] subList, indexes;

        var mapper = new PerformanceMapper();

        subList = computeSublist(listOfDifferences);

        sum = getSum(subList);

        indexes = locateSublist(listOfDifferences, subList);

        return mapper.toDTO(listOfDifferences, indexes, sum);
    }
}
