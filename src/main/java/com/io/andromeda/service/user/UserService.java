package com.io.andromeda.service.user;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.io.andromeda.domain.User;
import com.io.andromeda.domain.UserCreateForm;

/**
 * @author hamad
 *
 */
@Component
public interface UserService extends Serializable {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}
