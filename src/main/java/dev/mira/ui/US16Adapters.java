package dev.mira.ui;

public enum US16Adapters {

    BRUTEFORCE("dev.mira.adapter.BruteForceAdapter"),
    BENCHMARK("dev.mira.adapter.BenchmarkAdapter");

    private final String classPath;

    public String getClassPath()
    {
        return this.classPath;
    }

    US16Adapters(String str)
    {
        this.classPath = str;
    }
}
