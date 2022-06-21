package dev.mira.ui;

public enum US17Adapters {

    BUBBLE("dev.mira.adapter.BubbleSortAdapter"),
    MERGE("dev.mira.adapter.MergeSortAdapter");

    private final String classPath;

    public String getClassPath()
    {
        return this.classPath;
    }

    US17Adapters(String str)
    {
        this.classPath = str;
    }
}
