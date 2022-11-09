package com.lydiawebshop.webproject.user.service;

import com.lydiawebshop.webproject.user.model.User;

public interface UserService {

    User saveUser(User user);

    User getUserById(long id);
}
