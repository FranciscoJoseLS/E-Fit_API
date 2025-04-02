package org.EFit_API.service;

import org.EFit_API.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<User> findAll();
    User save(User user);
    void delete(User user);

    Optional<User> findById(UUID id);
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
}
