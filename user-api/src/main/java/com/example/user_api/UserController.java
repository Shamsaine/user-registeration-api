package com.example.user_api;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // Constructor Injection for Dependency Injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE: Add a new user
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getGender(), user.getPhoneNumber());
        return ResponseEntity.ok(createdUser);
    }

    // READ: Get all users
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // READ: Get a single user by ID
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable int userId) {
        Optional<User> user = userService.getUserById(userId);
        return user.<ResponseEntity<Object>>map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.status(404).body("User not found"));
    }

    // UPDATE: Modify an existing user
    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable int userId, @RequestBody User updatedUser) {
        try {
            User user = userService.updateUser(userId, updatedUser.getFirstName(), updatedUser.getLastName(), updatedUser.getEmail(), updatedUser.getGender(), updatedUser.getPhoneNumber());
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    // DELETE: Remove a user
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable int userId) {
        try {
            boolean deleted = userService.deleteUser(userId);
            return ResponseEntity.ok("User deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
