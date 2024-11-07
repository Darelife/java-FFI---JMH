import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;

@State(org.openjdk.jmh.annotations.Scope.Thread)
public class TestBM {

  private final InteropTest interopTest = new InteropTest();

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @OutputTimeUnit(TimeUnit.NANOSECONDS)
  @Fork(value = 1)
  @Warmup(iterations = 2)
  @Measurement(iterations = 1)
  public void benchmarkNativeAdd() {
    interopTest.nativeAdd(5, 10);
  }

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @OutputTimeUnit(TimeUnit.NANOSECONDS)
  @Fork(value = 1)
  @Warmup(iterations = 2)
  @Measurement(iterations = 1)
  public void benchmarkJavaAdd() {
    interopTest.javaAdd(5, 10);
  }
}