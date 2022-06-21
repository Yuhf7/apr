package dev.mira.mapper;

import dev.mira.mapper.dto.PerformanceDTO;

/**
 * PerformanceMapper
 */
public class PerformanceMapper {

    /**
     * To dto performance dto.
     *
     * @param listOfDifferences the list of differences
     * @param intervalRange     the interval range
     * @param sum               the sum
     * @return the performance dto
     */
    public PerformanceDTO toDTO(int[] listOfDifferences, int[] intervalRange, int sum)
    {
        return new PerformanceDTO(listOfDifferences, intervalRange, sum);
    }

    /**
     * To dto performance dto.
     *
     * @param listOfDifferences the list of differences
     * @param sum               the sum
     * @param subList           the sub list
     * @return the performance dto
     */
    public PerformanceDTO toDTO(int[] listOfDifferences, int sum, int[] subList)
    {
        return new PerformanceDTO(listOfDifferences, sum, subList);
    }
}
