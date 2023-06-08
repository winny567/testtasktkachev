package com.company.testtasktkachev;


import com.haulmont.thesis.testsupport.ThesisTestContainer;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TesttasktkachevTestContainer extends ThesisTestContainer {

    public TesttasktkachevTestContainer() {
        super();
        // project and special properties for test environment.
        appPropertiesFiles.add("testtasktkachev-app.properties");
        appPropertiesFiles.add("testtasktkachev-test-app.properties");
        autoConfigureDataSource();
    }

    public static class Common extends TesttasktkachevTestContainer {

        // A common singleton instance of the test container which is initialized once for all tests
        public static final TesttasktkachevTestContainer.Common INSTANCE = new TesttasktkachevTestContainer.Common();

        private static volatile boolean initialized;

        private Common() {}

        @Override
        public void beforeAll(ExtensionContext extensionContext) throws Exception {
            if (!initialized) {
                super.beforeAll(extensionContext);
                initialized = true;
            }
            setupContext();
        }

        @SuppressWarnings("RedundantThrows")
        @Override
        public void afterAll(ExtensionContext extensionContext) throws Exception {
            cleanupContext();
           // never stops - do not call super
        }
    }
}