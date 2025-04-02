package org.EFit_API.controller;

import org.EFit_API.entity.User;
import org.EFit_API.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl service;

    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    /*
     * GET http://localhost:8080/user/users
     */
    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll() {
        List<User> users = service.findAll();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(users);
        }
    }

    /*
     * GET http://localhost:8080/user/users/{id}
     */
    @GetMapping("/users/{id}")
    public ResponseEntity<User> findById(@PathVariable UUID id) {
        Optional<User> user = service.findById(id);
        return user.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*
     * POST http://localhost:8080/user/users
     */
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = service.save(user);
        if (savedUser == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.status(201).body(savedUser);
    }

    /*
     * DELETE http://localhost:8080/user/users/{id}
     */
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        Optional<User> user = service.findById(id);
        if (user.isPresent()) {
            service.delete(user.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    /*
     * PUT http://localhost:8080/user/users/{id}
     */
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody User user) {
        Optional<User> existingUser = service.findById(id);
        if (existingUser.isPresent()) {
            user.setUserId(id);
            User updatedUser = service.save(user);
            return ResponseEntity.ok(updatedUser);
        }
        return ResponseEntity.notFound().build();
    }

    /*
     * GET http://localhost:8080/user/users/email/{email}
     */
    @GetMapping("/users/email/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email) {
        Optional<User> user = service.findByEmail(email);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*
     * POST http://localhost:8080/user/users/login
     */
    @PostMapping("/users/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        Optional<User> existingUser = service.findByEmailAndPassword(user.getEmail(), user.getPassword());
        return existingUser.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.status(401).build());
    }

}