package com.project.carparkv1.Controller;

import com.project.carparkv1.Security.RequestForm.LoginForm;
import com.project.carparkv1.Security.RequestForm.RegisterForm;
import com.project.carparkv1.Security.ResponseForm.LoginResponse;
import com.project.carparkv1.Security.SecurityService.LoginService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Login")
public class LoginController {

    private final LoginService loginService;

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/SignIn")
    public LoginResponse login(@RequestBody LoginForm loginForm) {
        return loginService.login(loginForm); }

    @PostMapping("/SignUp")
    public String registerUser(@RequestBody RegisterForm registerForm) {
        return loginService.registerUser(registerForm);
    }

}



