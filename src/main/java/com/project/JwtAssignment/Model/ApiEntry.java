package com.project.JwtAssignment.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiEntry {


        private String api;
        private String description;
        private String auth;
        private boolean https;
        private String cors;
        private String link;
        private String category;

        // Getters and setters

        // Constructors

}
