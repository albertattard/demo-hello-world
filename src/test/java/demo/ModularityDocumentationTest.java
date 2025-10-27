package demo;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class ModularityDocumentationTest {

    @Test
    void writeDocs() {
        final ApplicationModules modules = ApplicationModules.of(Main.class);
        new Documenter(modules)
                .writeDocumentation();
    }
}
