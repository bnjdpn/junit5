package fr.xebia.xke.runner.parameterized;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FibonacciTest_Constructor {

  private int fInput;
  private int fExpected;

  public FibonacciTest_Constructor(int input, int expected) {
    fInput = input;
    fExpected = expected;
  }

  @Parameters(name = "{index}: fib[{0}]={1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{{0, 0}, {1, 1}, {2, 1}, {3, 2}, {4, 3}, {5, 5}, {6, 8}});
  }

  @Test
  public void test() {
    assertEquals(fExpected, Fibonacci.compute(fInput));
  }
}
