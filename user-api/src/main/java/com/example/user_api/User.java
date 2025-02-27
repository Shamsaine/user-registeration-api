package com.example.user_api;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false, length = 255)
    private String firstName;

    @Column (nullable = false, length = 255)
    private String lastName;

    @Column (nullable = false, unique = true, length = 255)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = true, length = 255)
    private String phoneNumber;

    public User(){}

    public User(String firstName, String lastName, String email, Gender gender, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }
    
    // Getters
    public int getUserId() { return userId; }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getEmail() { return email; }

    public Gender getGender() { return gender; }

    public String getPhoneNumber() { return phoneNumber; }

    // Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setEmail(String email) { this.email = email; }

    public void setGender(Gender gender) { this.gender = gender; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    // Enum for Gender
    public enum Gender {
        MALE, FEMALE, OTHER
    }
}
