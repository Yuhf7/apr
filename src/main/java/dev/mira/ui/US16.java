package dev.mira.ui;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import dev.mira.adapter.SubsequenceAlgorithm;
import dev.mira.utils.Utils;

/**
 * US16
 */
public class US16 implements UserStory {

    private LocalTime op;
    private LocalTime cl;

    public void setHours()
    {
        String op = "08:00";
        String cl = "20:00";

        var fmt = DateTimeFormatter.ofPattern("HH:mm");

        this.op = LocalTime.from(fmt.parse(op));
        this.cl = LocalTime.from(fmt.parse(cl));
    }

    @Override
    public void run()
    {
        boolean again;
        boolean newArray = true;

        int[] target = null;
        int interval = 0;

        setHours();

        do {
            try {
                if (newArray) {
                    target = Utils.pickArr();
                    interval = (int) Duration.between(this.op, this.cl).toMinutes() / target.length;
                }

                SubsequenceAlgorithm alg = pickAlg();

                var dto = alg.getSublistInfo(target);

                dto.setCenterHours(this.op, this.cl, interval);

                System.out.println(dto.toString());

                System.out.println(Arrays.toString(dto.getCenterHours()));

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

    public SubsequenceAlgorithm pickAlg()
    {
        Class<?> alg;

        var adp = (US16Adapters)
            Utils.showAndSelectOne(List.of(US16Adapters.values()),
                    "Pick an algorithm:", true);

        if (adp == null)
            throw new IllegalArgumentException();

        try {
            alg = Class.forName(adp.getClassPath());

            return (SubsequenceAlgorithm) alg.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InvocationTargetException |
                 InstantiationException | IllegalAccessException |
                 NoSuchMethodException e)
        {
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        return "US16 --- Analyze Performance of a Center";
    }
}
