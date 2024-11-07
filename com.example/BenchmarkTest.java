
package com.example;

// "C:\Users\asus\Downloads\jmh-core-1.37.jar"
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@State(Scope.Thread)
public class BenchmarkTest {
  private static final InteropTest interopTest = new InteropTest();
  private static final int a = 5;
  private static final int b = 10;

  @Benchmark
  public int benchmarkNativeAdd() {
    return interopTest.nativeAdd(a, b);
  }

  @Benchmark
  public int benchmarkJavaAdd() {
    return interopTest.javaAdd(a, b);
  }

  public static void main(String[] args) throws RunnerException {
    Options options = new OptionsBuilder()
        .include(BenchmarkTest.class.getSimpleName())
        .forks(1)
        .build();

    new Runner(options).run();
  }
}