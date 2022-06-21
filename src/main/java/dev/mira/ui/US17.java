package dev.mira.ui;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import dev.mira.adapter.SortingAlgorithm;
import dev.mira.utils.Utils;

/**
 * US17
 */
public class US17 implements UserStory {


    @Override
    public void run()
    {
        boolean again;
        boolean newArray = true;
        int[] target = null;

        do {
            try {
                if (newArray) {
                    target = Utils.pickArr();
                }

                SortingAlgorithm alg = pickAlg();

                var list = alg.getList(target);

                Utils.showList(list, "Sorted list:");

                System.out.println();
                again = Utils.confirm("Again?");

                if (again)
                    newArray = Utils.confirm("Want to choose a different array?");
            } catch (IllegalArgumentException e) {
                System.err.println("Exiting...");
                return;
            }
        } while (again);
    }

    public SortingAlgorithm pickAlg()
    {
        Class<?> alg;

        var adp = (US17Adapters)
            Utils.showAndSelectOne(List.of(US17Adapters.values()),
                    "Pick an algorithm:", true);

        if (adp == null)
            throw new IllegalArgumentException();

        try {
            alg = Class.forName(adp.getClassPath());

            return (SortingAlgorithm) alg.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InvocationTargetException |
                InstantiationException | IllegalAccessException |
                NoSuchMethodException e)
        {
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        return "US17 --- Import and Sort data from a legacy system";
    }
}
