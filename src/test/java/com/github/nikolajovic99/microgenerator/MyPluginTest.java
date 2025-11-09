package com.github.nikolajovic99.microgenerator;

import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import org.jetbrains.annotations.NotNull;

/**
 * Basic plugin test stub.
 * This test only ensures that the test environment is properly set up.
 */
public final class MyPluginTest extends BasePlatformTestCase {

    public void testPluginLoads() {
        // Basic sanity check: project and fixture should not be null
        assertNotNull(getProject());
        assertNotNull(myFixture);
    }

    @Override
    protected @NotNull String getTestDataPath() {
        // Default empty path – you can add test data later if needed
        return "src/test/testData";
    }
}
