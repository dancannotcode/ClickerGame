package com.example.testing;

import static org.junit.Assert.assertEquals;

import android.content.Context;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * This class performs instrumented unit tests, which execute on an actual Android device or emulator.
 * These tests are able to utilize the Android framework APIs and can interact with the application's context as it would appear on a device.
 *
 * The tests ensure that the application behaves as expected with real device configurations and user interactions. It's essential for testing
 * integration and functional aspects of Android applications.
 *
 * @see <a href="http://d.android.com/tools/testing">Android Testing Documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    /**
     * Tests the correctness of the application's context.
     * This method retrieves the context of the app under test and asserts that the package name is correct.
     * It's a basic check to confirm that the application under test is installed and set up correctly on the test environment
     * and the context being used within the test is indeed the application's context.
     *
     * This test will fail if the actual package name of the app does not match the expected package name,
     * indicating potential issues with the app's configuration or deployment.
     */
    @Test
    public void useAppContext() {
        // Retrieve the Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        // Assert that the retrieved package name matches the expected package name.
        assertEquals("Package name does not match", "com.example.messedup", appContext.getPackageName());
    }
}
