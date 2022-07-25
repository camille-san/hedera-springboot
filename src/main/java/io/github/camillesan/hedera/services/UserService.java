package io.github.camillesan.hedera.services;

import io.github.camillesan.hedera.entities.users.User;
import io.github.camillesan.hedera.errors.ErrorCode;
import io.github.camillesan.hedera.exceptions.HederaException;
import io.github.camillesan.hedera.repositories.users.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User checkLogin(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent() && userOptional.get().getPassword().equals(password)) {
            return userOptional.get();
        } else {
            throw new HederaException(ErrorCode.BAD_LOGIN);
        }
    }

    public User addNewUser(User user) {
        try {
            if (userRepository.findByEmail(user.getEmail()).isPresent()) {
                throw new HederaException(ErrorCode.NEW_USER_EMAIL_TAKEN);
            } else {
                return userRepository.save(user);
            }
        } catch (DataIntegrityViolationException ex) {
            throw new HederaException(ErrorCode.NEW_USER_FIELD_MISSING);
        }
    }

}
