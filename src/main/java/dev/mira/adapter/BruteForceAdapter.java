package dev.mira.adapter;

import dev.mira.algorithms.BruteForceAlgorithm;

import dev.mira.mapper.PerformanceMapper;
import dev.mira.mapper.dto.PerformanceDTO;

/**
 * BruteForceAdapter
 */
public class BruteForceAdapter implements SubsequenceAlgorithm {

    private BruteForceAlgorithm bfa;

    public BruteForceAdapter()
    {
        this.bfa = new BruteForceAlgorithm();
    }

    /**
     * Computes the sublist
     * this method only exists so that the algorithms can
     * be fairly comparated
     * @param sequence the original sublist
     */
    public void computeSubList(int[] sequence)
    {
        this.bfa.compute(sequence);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PerformanceDTO getSublistInfo(int[] listOfDifferences)
    {
        int sum;
        int[] range;

        var mapper = new PerformanceMapper();

        computeSubList(listOfDifferences);

        range = bfa.getSequenceRange();
        sum   = bfa.getMaxSum();

        return mapper.toDTO(listOfDifferences, range, sum);
    }
}
