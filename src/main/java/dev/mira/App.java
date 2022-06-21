package dev.mira;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dev.mira.ui.US16;
import dev.mira.ui.US17;
import dev.mira.ui.UserStory;
import dev.mira.utils.Utils;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] argv)
    {
        int i;
        int argc = argv.length;

        UserStory us = null;

        for (i = 0; i < argc; ++i) {
            if (argv[i].equals("--"))
                break;
            else if (argv[i].equals("--us17"))
                us = new US17();
            else if (argv[i].equals("--us16"))
                us = new US16();
            else if (argv[i].equals("--default"))
                Inputs.DEFAULT = Inputs.ex1;
        }

        if (us == null)
            pickUS().run();
        else
            us.run();
    }

    private static UserStory pickUS()
    {
        var lst = new ArrayList<UserStory>();

        lst.add(new US16());
        lst.add(new US17());

        int idx = Utils.showAndSelectIndex(lst, "Choose a US", false);

        return lst.get(idx);
    }
}
