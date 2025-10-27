package demo;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

class ModularityVerificationTest {

    @Test
    void verifiesModularity() {
        final ApplicationModules modules = ApplicationModules.of(Main.class);
        modules.verify();
    }
}
