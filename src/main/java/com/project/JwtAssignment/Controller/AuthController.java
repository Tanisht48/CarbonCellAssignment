package com.project.JwtAssignment.Controller;

import com.project.JwtAssignment.Entities.User;
import com.project.JwtAssignment.Exception.UnauthorizedAccessException;
import com.project.JwtAssignment.Model.JwtRequest;
import com.project.JwtAssignment.Model.JwtResponse;
import com.project.JwtAssignment.Model.UserDto;
import com.project.JwtAssignment.Security.JwtHelper;
import com.project.JwtAssignment.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login (@RequestBody JwtRequest request, Principal principal){

        if (principal != null) {
            System.out.println(principal);
            throw new UnauthorizedAccessException("You Currently Logged in Unauthorized Access");
        }

        this.doAuthenticate(request.getEmail(),request.getPassword() );


        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());

        String token = this.jwtHelper.generateToken(userDetails);

        JwtResponse response  = JwtResponse.builder()
                .token(token)
                .username(userDetails.getUsername()).build();

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email,password);

        try{
            manager.authenticate(authenticationToken);
        }
        catch(BadCredentialsException e){
            throw new BadCredentialsException(" Invalid Username or Password !!");
        }
    }

    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody UserDto user) {
        try {

            User savedUser = userService.createUser(user);
            return ResponseEntity.ok("User created successfully with ID: " + savedUser.getUsername());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating user: " + e.getMessage());
        }
    }

}
