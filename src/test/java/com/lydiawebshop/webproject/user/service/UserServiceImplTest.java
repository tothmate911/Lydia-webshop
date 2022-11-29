package com.lydiawebshop.webproject.user.service;

import com.lydiawebshop.webproject.user.model.User;
import com.lydiawebshop.webproject.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles(profiles = "test")
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getUserById_returnSavedUser() {
        User user = User.builder()
                .firstName("first")
                .lastName("last")
                .build();
        userService.saveUser(user);

        User resultUser = userService.getUserById(1);
        assertEquals("first", resultUser.getFirstName());
        assertEquals("last", resultUser.getLastName());
    }

    @Test
    public void getUserById_userNotFound_throwException () {
        assertThrows(EntityNotFoundException.class, () -> userService.getUserById(122));
    }

}