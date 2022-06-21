package dev.mira.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
// import java.util.logging.Level;
// import java.util.logging.Logger;

import dev.mira.Inputs;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Utils {

    public static int[] pickArr()
    {
        boolean useDefault = confirm("Use one of the default arrays?");

        if (useDefault) {
            List<int[]> defaults = Inputs.getDefaults();
            int idx = showAndSelectIndex(defaults, "Choose a default array", false);

            return defaults.get(idx);
        } else {
            String line = readLineFromConsole("Type your array, comma separated:");

            return Arrays.asList(line.replaceAll(" ", "").split(",")).stream().mapToInt(Integer::parseInt).toArray();
        }
    }

    public static void printArr(int[] arr)
    {
        System.out.println(Arrays.toString(arr));
    }

    public static int sumArr(int[] arr)
    {
        return Arrays.stream(arr).sum();
    }

    static public String readLineFromConsole(String prompt)
    {
        try {
            System.out.printf("%s ", prompt);

            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);

            String line = in.readLine();

            System.out.println();

            return line;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static public String readPassword(String prompt)
    {
        char[] pwd;

        try {
            pwd = System.console().readPassword("%s (%s): ", prompt, "password hidden");
            return new String(pwd);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static public int readIntegerFromConsole(String prompt)
    {
        do {
            try {
                String input = readLineFromConsole(prompt);

                int value = Integer.parseInt(input);

                return value;
            } catch (NumberFormatException ex) {
                System.err.println("Invalid number; try again.");
            }
        } while (true);
    }


    static public long readLongArgument(String prompt) {
        do {
            try {
                String input = readLineFromConsole(prompt);

                long value = Long.parseLong(input);

                return value;
            } catch (Exception e) {
                System.err.println("Invalid number; try again.");
            }
        } while (true);
    }

    static public double readDoubleFromConsole(String prompt)
    {
        do {
            try {
                String input = readLineFromConsole(prompt);

                double value = Double.parseDouble(input);

                return value;
            } catch (NumberFormatException ex) {
                System.err.println("Invalid number; try again.");
            }
        } while (true);
    }

    static public Date readDateFromConsole(String prompt, SimpleDateFormat format)
    {
        do {
            try {
                String strDate = readLineFromConsole(prompt);

                Date date = format.parse(strDate);

                return date;
            } catch (ParseException ex) {
                System.err.printf("Date is invalid. Try the following format: %s\n",
                                  format.toPattern());
            }
        } while (true);
    }

    static public boolean confirm(String message) {
        return readLineFromConsole(message + " [y/N]").matches("[yY].*");
    }

    static public Object showAndSelectOne(List<?> list, String header, boolean cancel)
    {
        showList(list,header);
        return selectsObject(list, cancel);
    }

    static public int showAndSelectIndex(List<?> list, String header, boolean cancel)
    {
        showList(list,header);
        return selectsIndex(list, cancel);
    }

    static public <E> void showList(List<E> list, String header)
    {
        System.out.printf("%s\n\n", header);

        int index = 0;
        for (Object o : list) {
            index++;

            if (o instanceof int[])
                System.out.printf("%s. %s\n", index, Arrays.toString((int[]) o));
            else
                System.out.printf("%s. %s\n", index, o.toString());
        }
        System.out.println();
    }

    static public Object selectsObject(List<?> list, boolean cancel)
    {
        int value = selectsIndex(list, cancel);

        return value >= 0 ? list.get(value) : null;
    }

    static public int selectsIndex(List<?> list, boolean cancel)
    {
        int value;

        if (cancel)
            System.out.println("0 - Cancel\n");

        do {
            value = readIntegerFromConsole("Type your option:");
        } while (value < (cancel ? 0 : 1) || value > list.size());

        return value - 1;
    }

    static public Date getLocalDateTime(){
        LocalDateTime lclTime = LocalDateTime.now();

        lclTime.withSecond(0);

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date localDate;
        try {
            localDate = sdf.parse(lclTime.toString());
            return localDate;
        } catch (ParseException e) {
            System.err.println("Date format can't be parsable");
            return null;
        }
    }

    static public Date getLocalDate(){
        LocalDate date=LocalDate.now();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date localDate;
        try {
            localDate = sdf.parse(date.toString());
            return localDate;
        } catch (ParseException e) {
            System.err.println("Date format can't be parsable");
            return null;
        }
    }
    public LocalTime dateToLocalTime(Date dt)
    {
        return LocalDateTime.ofInstant(dt.toInstant(),
                ZoneId.systemDefault()).toLocalTime();
    }

    public static LocalDate dateToLocalDate(Date dt)
    {
        return LocalDateTime.ofInstant(dt.toInstant(),
                ZoneId.systemDefault()).toLocalDate();
    }


}
