package io.github.camillesan.hedera.restcontrollers.users;

import io.github.camillesan.hedera.entities.users.User;
import io.github.camillesan.hedera.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@Slf4j
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addNewUser(@RequestBody User user) {
        log.info("[REST] Adding new user: {}", user);
        user.setId(null);
        return userService.addNewUser(user);
    }

}
