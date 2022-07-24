package io.github.camillesan.hedera.restcontrollers.users;

import io.github.camillesan.hedera.entities.users.User;
import io.github.camillesan.hedera.repositories.users.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@Slf4j
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/")
    @CrossOrigin(origins = "*")
    public User addNewUser(@RequestBody User user) {
        log.info("[REST] Adding new user: {}", user);
        return userRepository.save(user);
    }

}
