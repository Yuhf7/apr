package dev.mira.algorithms;

/**
 * BruteForceAlgorithm to find the contiguous subsequence
 * with the largest sum of its elements
 *
 * This algorithm has a time complexity of O(n^2)
 */
public class BruteForceAlgorithm {

    /** Value used to check if the algorithm was ran at least once */
    private boolean ran;

    /** The sum of the elements of the goal subsequence */
    private int maxSum;

    /**
     * Start and end indexes of the goal subsequence
     *
     * First index is the starting point (INCLUSIVE)
     * Second index is the ending point (EXCLUSIVE)
     */
    private int[] indexes;

    /**
     * Creates and instance of the BruteForceAlgorithm
     */
    public BruteForceAlgorithm()
    {
        this.ran = false;
    }

    /**
     * Returns an array subsequence of the one provided,
     * whose sum of elements is the largest
     *
     * @param sequence the sequence to find the subsequence of
     */
    public void compute(int[] sequence)
    {
        int i, j, n, sum;

        this.maxSum = 0;
        this.indexes = new int[2];

        n = sequence.length;
        for (i = 0; i < n; i++) {
            sum = 0;

            for (j = i; j < n; j++) {
                sum += sequence[j];

                if (sum > this.maxSum) {
                    this.maxSum = sum;
                    this.indexes[0] = i;
                    this.indexes[1] = j+1;
                }
            }
        }

        this.ran = true;
    }

    /**
     * Returns the sum of the elements of the goal subsequence
     *
     * @return sum of the elements of the goal subsequence
     *
     * @throws IllegalStateException if attempted to invoke this method before the algorithm was ran at least once
     */
    public int getMaxSum()
    {
        if (!ran)
            throw new IllegalStateException("The algorithm has to be ran at least ONCE before attempting to get the maximum sum!");
        else
            return this.maxSum;
    }

    /**
     * Returns the range of the goal subsequence
     *
     * @return array where the first entry is the starting index of the goal sequence in the original one (inclusive)
     * and the second entry is the ending point of the goal subsequence (exclusive)
     *
     * @throws IllegalStateException if attempted to invoke this method before the algorithm was ran at least once
     */
    public int[] getSequenceRange()
    {
        if (!ran)
            throw new IllegalStateException("The algorithm has to be ran at least ONCE before attempting to get the sequence range!");
        else
            return this.indexes.clone();
    }
}
