package io.github.camillesan.hederabudget.restcontrollers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MonitorRestController {

    @GetMapping(value = "/")
    public String isAlive() {
        return "Yes I'm alive";
    }

}
