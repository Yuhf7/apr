package dev.mira.adapter;

import dev.mira.mapper.dto.PerformanceDTO;

/**
 * SubsequenceAlgorithm
 * In order to provide a uniform access to
 * the available algorithms, this interface and some adapters
 * were implemented
 *
 * If a new algorithm is to be added to the system, an Adapter class
 * must be created (see existing adapters) and it shall implement this
 * interface
 *
 * Additionally, an entry to the Adapters enum shall be added, with the
 * adapter's class path as the attribute of the enum type, in order for
 * the default algorithm to be defined in the configuration file
 *
 * @see app.domain.shared.AlgorithmAdapters
 *
 * @see BruteForceAdapter
 * @see BenchmarkAdapter
 *
 * @see app.domain.shared.Constants#PARAMS_FILENAME
 * @see app.domain.shared.Constants#PARAMS_SUBSEQUENCE_ALGORITHM
 */
public interface SubsequenceAlgorithm extends Reflectable {

    /**
     * Obtain a DTO with the information obtained via the algorithm ran
     * @param listOfDifferences the initial list to feed the algorithm
     * @return dto representative of the algorithm's output(s)
     *
     * @see PerformanceDTO
    */
    public PerformanceDTO getSublistInfo(int[] listOfDifferences);

}
