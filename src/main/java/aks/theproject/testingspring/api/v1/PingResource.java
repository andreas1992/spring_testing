package aks.theproject.testingspring.api.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingResource {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
    
}
