package dev.mira.ui;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import dev.mira.adapter.SortingAlgorithm;
import dev.mira.utils.Utils;

/**
 * US17
 */
public class US17 implements UserStory {

    private Comparator<Integer> reversed = new Comparator<Integer>() {
        public int compare(Integer x, Integer y)
        {
            return -Integer.compare(x, y);
        }
    };

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

                var cmp = pickOrder();

                var list = alg.getList(target, cmp);

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

    public Comparator<Integer> pickOrder()
    {
        HashMap<String, Comparator<Integer>> opts = new HashMap<>(2);
        opts.put("Smallest to Largest", Integer::compare);
        opts.put("Largest to Smallest", this.reversed);

        String key = (String)
            Utils.showAndSelectOne(new ArrayList<>(opts.keySet()), "Choose the sorting order:", false);

        return opts.get(key);
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
