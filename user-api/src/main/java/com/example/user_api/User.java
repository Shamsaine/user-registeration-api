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
    
    //getters
    public void getUserId(){return userId;}

    public void getFirstName(){return firstName;}

    public void getLastName(){return lastName;}

    public void getEmail(){return email;}

    public void getGender(){return gender;}

    public void getPhoneNumber(){return phoneNumber;}
}
