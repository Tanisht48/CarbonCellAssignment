package com.project.JwtAssignment.Service;

import com.project.JwtAssignment.Entities.User;
import com.project.JwtAssignment.Model.UserDto;
import com.project.JwtAssignment.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService  {

    @Autowired
    private IUserRepository iUserRepository;

  @Autowired
    private  PasswordEncoder passwordEncoder;





    public  List<User> getAllUsers(){
        return  iUserRepository.findAll();
    }

    public User createUser(UserDto userDto) throws Exception {
        // Additional validation or logic can be added here before saving the user
        try {

            String encryptPassword = passwordEncoder.encode(userDto.getPassword());
            if (encryptPassword == null) {
                throw new RuntimeException("Failed to encrypt password");
            }

            userDto.setPassword(encryptPassword);

            return iUserRepository.save(new User(userDto.getName(), userDto.getEmail(), userDto.getPassword(),userDto.getAbout()));
        } catch (Exception e) {
            throw new Exception("Failed to create user: " + e.getMessage());
        }
    }








    public User findByEmail(String email) {
        return null;
    }
}
