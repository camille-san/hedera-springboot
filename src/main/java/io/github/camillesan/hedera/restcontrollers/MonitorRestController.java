package io.github.camillesan.hedera.restcontrollers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MonitorRestController {

    @Autowired
    Environment env;

    @GetMapping(value = "/isalive")
    public String isAlive() {
        return "Yes I'm alive <3";
    }

    @GetMapping(value = "/profiles")
    public String getProfiles() {
        StringBuilder profiles = new StringBuilder();
        for (String profile : env.getActiveProfiles()) {
            profiles.append(profile).append(',');
        }
        return profiles.deleteCharAt(profiles.length() - 1).toString();
    }

}
