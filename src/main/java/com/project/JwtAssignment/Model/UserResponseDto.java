package com.project.JwtAssignment.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserResponseDto {

        private String name;
        private String email;
        private String about;
}
