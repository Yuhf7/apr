package dev.mira.ui;

public enum US16Adapters {

    BRUTEFORCE("dev.mira.adapter.BruteForceAdapter") {
        @Override
        public String toString() {
            return "Bruteforce Algorithm";
        }
    },
    BENCHMARK("dev.mira.adapter.BenchmarkAdapter") {
        @Override
        public String toString() {
            return "Benchmark Algorithm";
        }
    };

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
