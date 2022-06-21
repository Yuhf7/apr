package dev.mira.ui;

public enum US17Adapters {

    BUBBLE("dev.mira.adapter.BubbleSortAdapter") {
        @Override
        public String toString() {
            return "Bubble Sort Algorithm";
        }
    },
    MERGE("dev.mira.adapter.MergeSortAdapter") {
        @Override
        public String toString() {
            return "Merge Sort Algorithm";
        }
    };

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
