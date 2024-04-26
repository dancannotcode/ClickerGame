package com.example.testing;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * This class provides an example of a local unit test that can be executed on the development machine (host).
 * The purpose of this test class is to demonstrate basic assertions and functionality of JUnit testing.
 *
 * The test included verifies the correctness of basic arithmetic operations, serving as a simple sanity check
 * for the testing setup. It's typically used as a template or starting point for more complex unit tests.
 *
 * @see <a href="http://d.android.com/tools/testing">Android Testing Documentation</a>
 */
public class ExampleUnitTest {

    /**
     * Tests the addition of two numbers.
     * This test method checks if the sum of two numbers matches the expected outcome.
     * It's a straightforward test to ensure that the testing framework is functioning as expected.
     *
     * The method uses {@code assertEquals} to assert that the sum of 2 and 2 is indeed 4.
     * A failure in this assertion indicates a fundamental issue with the arithmetic operation or the test setup itself.
     */
    @Test
    public void addition_isCorrect() {
        assertEquals("Addition operation failed", 4, 2 + 2);
    }
}
