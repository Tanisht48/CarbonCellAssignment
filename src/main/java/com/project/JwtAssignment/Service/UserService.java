package com.project.JwtAssignment.Service;

import com.project.JwtAssignment.Entities.User;
import com.project.JwtAssignment.Exception.UserAlreadyExistsException;
import com.project.JwtAssignment.Model.UserDto;
import com.project.JwtAssignment.Model.UserResponseDto;
import com.project.JwtAssignment.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class UserService  {

    @Autowired
    private IUserRepository iUserRepository;

  @Autowired
    private  PasswordEncoder passwordEncoder;





    public  List<UserResponseDto> getAllUsers(){
        List<User>userList =  iUserRepository.findAll();

        if(userList.isEmpty())return new ArrayList<>();

        List<UserResponseDto> userResponseDtoList = new ArrayList<>();

        for(User u : userList)
        {
            userResponseDtoList.add(new UserResponseDto(u.getName(),u.getEmail(),u.getAbout()));
        }
        return userResponseDtoList;
    }

    public User createUser(UserDto userDto) throws Exception {
        Optional<User> user = findByEmail(userDto.getEmail());
        if(user.isPresent()) throw new UserAlreadyExistsException("User already exists");

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








    public Optional<User> findByEmail(String email) {
        return iUserRepository.findByEmail(email);
    }
}
