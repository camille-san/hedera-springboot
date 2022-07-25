package io.github.camillesan.hedera.restcontrollers.users;

import io.github.camillesan.hedera.entities.users.User;
import io.github.camillesan.hedera.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
@Slf4j
public class LoginRestController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    @CrossOrigin(origins = "*")
    public ResponseEntity<User> login(@RequestParam String email, @RequestParam String password) {
        log.info("[REST] Attempt login user: {}", email);
        User user = userService.checkLogin(email, password);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
