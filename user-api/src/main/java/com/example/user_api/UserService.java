package com.example.user_api;

import org.springframework.stereotype.Service;
import java.util.*;
import java.util.regex.Pattern;

@Service
public class UserService {

    private final Map<Integer, User> userDatabase = new HashMap<>();
    private int userIdCounter = 1; // Simulates auto-increment ID in a real DB

    // CREATE: Add a new user
    public User createUser(String firstName, String lastName, String email, User.Gender gender, String phoneNumber) {
        validateInput(firstName, lastName, email, phoneNumber);

        User user = new User(firstName, lastName, email, gender, phoneNumber);
        userDatabase.put(userIdCounter++, user);
        return user;
    }

    // READ: Get user by ID
    public Optional<User> getUserById(int userId) {
        return Optional.ofNullable(userDatabase.get(userId));
    }

    // READ: Get all users
    public List<User> getAllUsers() {
        return new ArrayList<>(userDatabase.values());
    }

    // UPDATE: Update user details
    public User updateUser(int userId, String firstName, String lastName, String email, User.Gender gender, String phoneNumber) {
        if (!userDatabase.containsKey(userId)) {
            throw new NoSuchElementException("User with ID " + userId + " not found.");
        }

        validateInput(firstName, lastName, email, phoneNumber);

        User user = userDatabase.get(userId);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setGender(gender);
        user.setPhoneNumber(phoneNumber);

        return user;
    }

    // DELETE: Remove user by ID
    public boolean deleteUser(int userId) {
        if (!userDatabase.containsKey(userId)) {
            throw new NoSuchElementException("User with ID " + userId + " not found.");
        }
        userDatabase.remove(userId);
        return true;
    }

    // Validation method for user inputs
    private void validateInput(String firstName, String lastName, String email, String phoneNumber) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("Enter a valid first name.");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Enter a valid last name.");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Enter a valid email.");
        }

        // Email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email format.");
        }

        // Phone number validation
        if (phoneNumber != null && !phoneNumber.matches("^\\+?[0-9]{7,15}$")) {
            throw new IllegalArgumentException("Invalid phone number format.");
        }
    }
}
