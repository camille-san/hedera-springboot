package io.github.camillesan.hedera.restcontrollers.users;

import io.github.camillesan.hedera.entities.users.User;
import io.github.camillesan.hedera.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@Slf4j
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/")
    @CrossOrigin(origins = "*")
    public User addNewUser(@RequestBody User user) {
        log.info("[REST] Adding new user: {}", user);
        return userService.addNewUser(user);
    }

}
