package demo.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationModuleTest
class HelloModuleTest {

    @Autowired
    HelloService service;

    @Test
    void greetWorks() {
        assertThat(service.greet(null)).isEqualTo("Hello there");
        assertThat(service.greet("Alice")).isEqualTo("Hello Alice");
    }
}
