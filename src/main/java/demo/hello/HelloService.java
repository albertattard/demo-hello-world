package demo.hello;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String greet(final String name) {
        return name == null || name.isBlank()
                ? "Hello there"
                : "Hello " + name;
    }
}