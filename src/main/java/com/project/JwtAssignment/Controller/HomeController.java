package com.project.JwtAssignment.Controller;

import com.project.JwtAssignment.Entities.User;
import com.project.JwtAssignment.Model.ApiResponse;
import com.project.JwtAssignment.Service.ApiService;
import com.project.JwtAssignment.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")

public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private ApiService apiService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal) {
        return principal.getName();
    }

    @GetMapping("/api/entries")
    @PreAuthorize("hasRole('USER')") // Ensure only authenticated users can access
    public ResponseEntity<ApiResponse> getEntries(
            @RequestParam(required = false) String category,
            @RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(apiService.getEntries(category, limit));

    }
}