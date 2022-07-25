package io.github.camillesan.hedera.services;

import io.github.camillesan.hedera.MockTestDataService;
import io.github.camillesan.hedera.entities.users.User;
import io.github.camillesan.hedera.errors.ErrorCode;
import io.github.camillesan.hedera.exceptions.HederaException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private MockTestDataService mock;

    @PostConstruct
    public void init() {
        mock.init();
    }

    @DisplayName("Login should succeed and return full user object")
    @Test
    public void testLoginShouldSucceed() {
        User user = userService.checkLogin(mock.USER1_EMAIL, mock.USER1_PASSWORD);
        assertEquals(mock.USER1_EMAIL, user.getEmail());
        assertEquals(mock.USER1_PASSWORD, user.getPassword());
    }

    @DisplayName("Login should fail because user doesn't exist in db")
    @Test
    public void testLoginFailUnknownUser() {
        HederaException thrown = assertThrows(HederaException.class, () -> {
            userService.checkLogin("non-existing-email", "password-never-checked");
        }, "HederaException was expected");
        assertEquals(ErrorCode.BAD_LOGIN, thrown.getErrorCode());
    }

    @DisplayName("Login should fail because password doesn't match")
    @Test
    public void testLoginFailWrongPassword() {
        HederaException thrown = assertThrows(HederaException.class, () -> {
            userService.checkLogin(mock.USER1_EMAIL, "wrong-password");
        }, "HederaException was expected");
        assertEquals(ErrorCode.BAD_LOGIN, thrown.getErrorCode());
    }

    @DisplayName("Add new user should succeed, email is new in db")
    @Test
    public void testNewUserSucceed() {
        String email = "new.email";
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword("p");
        newUser.setFirstName("f");
        newUser.setLastName("l");
        User user = userService.addNewUser(newUser);
        assertEquals(email, user.getEmail());
        assertNotNull(user.getId());
    }

    @DisplayName("Add new user should fail because email already exists")
    @Test
    public void testNewUserFail() {
        User newUser = new User();
        newUser.setEmail(mock.USER1_EMAIL);
        newUser.setPassword("p");
        newUser.setFirstName("f");
        newUser.setLastName("l");
        HederaException thrown = assertThrows(HederaException.class, () -> {
            userService.addNewUser(newUser);
        }, "HederaException was expected");
        assertEquals(ErrorCode.NEW_USER_EMAIL_TAKEN, thrown.getErrorCode());
    }

    @DisplayName("Add new user should fail because one of the mandatory fields is null")
    @Test
    public void testNewUserFailFieldNull() {
        List<User> failingUsers = new ArrayList<>();
        User noEmailUser = new User();
        noEmailUser.setEmail(null);
        noEmailUser.setPassword("p");
        noEmailUser.setFirstName("f");
        noEmailUser.setLastName("l");
        failingUsers.add(noEmailUser);
        User noPwUser = new User();
        noPwUser.setEmail("e");
        noPwUser.setPassword(null);
        noPwUser.setFirstName("f");
        noPwUser.setLastName("l");
        failingUsers.add(noPwUser);
        User noFirstNameUser = new User();
        noFirstNameUser.setEmail("e");
        noFirstNameUser.setPassword("p");
        noFirstNameUser.setFirstName(null);
        noFirstNameUser.setLastName("l");
        failingUsers.add(noFirstNameUser);
        User noLastNameUser = new User();
        noLastNameUser.setEmail("e");
        noLastNameUser.setPassword("p");
        noLastNameUser.setFirstName("f");
        noLastNameUser.setLastName(null);
        failingUsers.add(noLastNameUser);

        failingUsers.forEach(user -> {
            HederaException thrown = assertThrows(HederaException.class, () -> {
                userService.addNewUser(user);
            }, "HederaException was expected");
            assertEquals(ErrorCode.NEW_USER_FIELD_MISSING, thrown.getErrorCode());
        });
    }

    @DisplayName("Add new user should fail because one of the mandatory fields is empty")
    @Test
    public void testNewUserFailFieldStringEmpty() {
        List<User> failingUsers = new ArrayList<>();
        User noEmailUser = new User();
        noEmailUser.setEmail("");
        noEmailUser.setPassword("p");
        noEmailUser.setFirstName("f");
        noEmailUser.setLastName("l");
        failingUsers.add(noEmailUser);
        User noPwUser = new User();
        noPwUser.setEmail("e");
        noPwUser.setPassword("");
        noPwUser.setFirstName("f");
        noPwUser.setLastName("l");
        failingUsers.add(noPwUser);
        User noFirstNameUser = new User();
        noFirstNameUser.setEmail("e");
        noFirstNameUser.setPassword("p");
        noFirstNameUser.setFirstName("");
        noFirstNameUser.setLastName("l");
        failingUsers.add(noFirstNameUser);
        User noLastNameUser = new User();
        noLastNameUser.setEmail("e");
        noLastNameUser.setPassword("p");
        noLastNameUser.setFirstName("f");
        noLastNameUser.setLastName("");
        failingUsers.add(noLastNameUser);

        failingUsers.forEach(user -> {
            HederaException thrown = assertThrows(HederaException.class, () -> {
                userService.addNewUser(user);
            }, "HederaException was expected");
            assertEquals(ErrorCode.NEW_USER_FIELD_MISSING, thrown.getErrorCode());
        });
    }

}