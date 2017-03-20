package fr.xebia.xke.junit5;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AssertionsDemoTests {

  @Test
  void standardAssertions() {
    assertEquals(2, 2);
    assertEquals(4, 4, "The optional assertion message is now the last parameter.");
    assertTrue(true, () -> "Assertion messages can be lazily evaluated -- "
        + "to avoid constructing complex messages unnecessarily.");
  }

  @Test
  void exceptionTesting() {
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
      throw new IllegalArgumentException("a message");
    });
    assertEquals("a message", exception.getMessage());
  }

  @Test
  void timeoutNotExceeded() {
    // The following assertion succeeds.
    assertTimeout(ofMinutes(2), () -> {
      // Perform task that takes less than 2 minutes.
    });
  }

  @Test
  void timeoutExceeded() {
    // The following assertion fails with an error message similar to:
    // execution exceeded timeout of 10 ms by 91 ms
    assertTimeout(ofMillis(10), () -> {
      // Simulate task that takes more than 10 ms.
      Thread.sleep(100);
    });
  }

  @Test
  void timeoutExceededWithPreemptiveTermination() {
    // The following assertion fails with an error message similar to:
    // execution timed out after 10 ms
    assertTimeoutPreemptively(ofMillis(10), () -> {
      // Simulate task that takes more than 10 ms.
      Thread.sleep(100);
    });
  }

}
