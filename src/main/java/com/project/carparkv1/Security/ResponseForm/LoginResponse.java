package com.project.carparkv1.Security.ResponseForm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String name;
    private String username;
    private List<String> roles;
    private String jwtToken;
}
