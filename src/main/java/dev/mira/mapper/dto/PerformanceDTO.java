package dev.mira.mapper.dto;

import java.time.LocalTime;
import java.util.Arrays;

/**
 * PerformanceDTO
 */
public class PerformanceDTO {

    private int[] diffList;

    private int[] goalSublist;

    private int[] range;

    private int sum;

    private LocalTime startTime;

    private LocalTime endTime;

    /**
     * Instantiates a new Performance dto.
     *
     * @param listOfDifferences the list of differences
     * @param intervalRange     the interval range
     * @param sum               the sum
     */
    public PerformanceDTO(int[] listOfDifferences, int[] intervalRange, int sum)
    {
        this.diffList = listOfDifferences;
        this.range    = intervalRange;
        this.sum      = sum;

        this.goalSublist = Arrays.copyOfRange(listOfDifferences, this.range[0], this.range[1]);
    }

    /**
     * Instantiates a new Performance dto.
     *
     * @param listOfDifferences the list of differences
     * @param sum               the sum
     * @param subList           the sub list
     */
    public PerformanceDTO(int[] listOfDifferences, int sum, int[] subList)
    {
        this.diffList    = listOfDifferences;
        this.sum         = sum;
        this.goalSublist = subList;

        this.range = null;
    }

    /**
     * Sets center hours.
     *
     * @param op           the op
     * @param cl           the cl
     * @param timeInterval the time interval
     */
    public void setCenterHours(LocalTime op, LocalTime cl, int timeInterval)
    {
        this.startTime = op.plusMinutes(this.range[0] * timeInterval);
        this.endTime   = op.plusMinutes(this.range[1] * timeInterval);
    }

    /**
     * Get center hours local time [ ].
     *
     * @return the local time [ ]
     */
    @Deprecated
    public LocalTime[] getCenterHours()
    {
        return new LocalTime[] { this.startTime, this.endTime };
    }

    /**
     * Get list of differences int [ ].
     *
     * @return the int [ ]
     */
    public int[] getListOfDifferences()
    {
        return this.diffList.clone();
    }

    /**
     * Get goal sublist int [ ].
     *
     * @return the int [ ]
     */
    public int[] getGoalSublist()
    {
        return this.goalSublist.clone();
    }

    /**
     * Get time range int [ ].
     *
     * @return the int [ ]
     * @throws NullPointerException the null pointer exception
     */
    @Deprecated
    public int[] getTimeRange()
    throws NullPointerException
    {
        return this.range.clone();
    }

    /**
     * Gets max sum.
     *
     * @return the max sum
     */
    public int getMaxSum()
    {
        return this.sum;
    }

    @Override
    public String toString() {
        return String.format("List with differences between arriving/leaving clients:\n%s\nContiguous sublist with max Sum:\n%s\nTotal sum: %d\tTime period: %s - %s",
                Arrays.toString(this.diffList),
                Arrays.toString(this.goalSublist),
                this.sum, this.startTime.toString(), this.endTime.toString());
    }
}
