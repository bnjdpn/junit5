package fr.xebia.xke.junit5.testinterfaces;

import fr.xebia.xke.junit5.factory.Factory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public interface FactoryComparableTest<T extends Comparable<T>> extends Factory<T> {

  T createSmallerValue();

  @Test
  default void returnsZeroWhenComparedToItself() {
    T value = createValue();
    assertEquals(0, value.compareTo(value));
  }

  @Test
  default void returnsPositiveNumberComparedToSmallerValue() {
    T value = createValue();
    T smallerValue = createSmallerValue();
    assertTrue(value.compareTo(smallerValue) > 0);
  }

  @Test
  default void returnsNegativeNumberComparedToSmallerValue() {
    T value = createValue();
    T smallerValue = createSmallerValue();
    assertTrue(smallerValue.compareTo(value) < 0);
  }

}
