package demo.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private final HelloService service;

    public HelloController(final HelloService service) {
        this.service = service;
    }

    @GetMapping
    public String sayHello(final @RequestParam(value = "name", required = false) String name) {
        return service.greet(name);
    }
}
