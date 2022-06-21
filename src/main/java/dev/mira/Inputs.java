package dev.mira;

import java.util.ArrayList;

/**
 * Inputs
 */
public class Inputs {

    private ArrayList<int[]> defaults;

    private Inputs()
    {
        this.defaults = new ArrayList<>();
        this.defaults.add(ex1);
        this.defaults.add(ex2);
    }

    public static int[] ex1 = new int[] {
        242, 194, 241, 92, 53, 27, 74, -75,
        -357, -125, -29, 141, 269, 121, 50,
        26, -29, -118, -254, 89, 246, -20,
        -119, -322
    };

    public static int[] ex2 = new int[] {
        171, 160, 105, 190, 107, 36, 33, 0,
        47, 58, 39, -98, -278, -151, -53,
        -43, 38, 117, 204, 116, 70, 55, 11,
        10, -15, -14, -118, -244, -4, 83, 222,
        12, -8, -69, -117, -255
    };

    public static int[] DEFAULT;

    public boolean addArray(int[] array)
    {
        return this.defaults.add(array);
    }

    public ArrayList<int[]> getDefaults()
    {
        return this.defaults;
    }

    private static Inputs singleton = null;

    public static Inputs getInstance()
    {
        if (singleton == null) {
            synchronized (Inputs.class) {
                singleton = new Inputs();
            }
        }

        return singleton;
    }
}
