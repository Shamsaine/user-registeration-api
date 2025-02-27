package main.java.com.example.user_api;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@Service
public class UserService {

    private User user = new User();

    //setters
    public String setFirstName(User user){
        if (this.FirstName == null){
            throw new IllegalArgumentException("Enter a valid Name")
        } else {
            this.firstName = firstName;
        }
    }
     public String setLastName(User user){
        if (this.lastName == null){
            throw new IllegalArgumentException("Enter a valid Name")
        } else {
            this.lastName = lastName;
        }
     }
     public String setEmail(User user){
        if (this.email == null || this.email.IsEmpty()){
            throw new IllegalArgumentException("enter a valid email")
        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9])"
     }
    
}
