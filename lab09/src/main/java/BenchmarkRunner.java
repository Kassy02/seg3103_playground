package org.example;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkRunner {
    static JMHSample demo2 = new JMHSample();
    public static void main(String[] args) throws Exception {

        Options opt = new OptionsBuilder()
                .include(".*" + JMHSample.class.getSimpleName() + ".*")
                .warmupIterations(2)
                .measurementIterations(2)
                .forks(1)
                .build();

        new Runner(opt).run();

    }
}
