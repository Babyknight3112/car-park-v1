package com.project.carparkv1.Security.SecurityService;

import com.project.carparkv1.Security.RequestForm.LoginForm;
import com.project.carparkv1.Security.RequestForm.RegisterForm;
import com.project.carparkv1.Security.ResponseForm.LoginResponse;
import com.project.carparkv1.Security.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    Logger logger = LoggerFactory.getLogger(LoginService.class);

    public LoginResponse login(LoginForm loginForm) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword());
            Authentication authenticate = authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            logger.info("Mọi thứ đều tốt");
            User user = (User) authenticate.getPrincipal();
            com.project.carparkv1.Security.Entity.User myUser = userService.getUser(loginForm.getUsername());
            List<String> authorities = myUser.getRoles().stream().map(role -> role.getName()).collect(Collectors.toList());
            return new LoginResponse(myUser.getName(), myUser.getUsername(), authorities, jwtUtil.generateToken(user));
        } catch (BadCredentialsException e) {
            logger.error("{}", e.getMessage());
            return null;
        }
    }

    public String registerUser(@RequestBody RegisterForm registerForm) {
        if (userService.existUser(registerForm.getUsername())) {
            return "Existed this username in database";
        }
        com.project.carparkv1.Security.Entity.User user = new com.project.carparkv1.Security.Entity.User();
        user.setName(registerForm.getName());
        user.setUsername(registerForm.getUsername());
        user.setPassword(registerForm.getPassword());
        userService.saveUser(user);
        userService.addRoleToUser(user.getUsername(), "ROLE_USER");
        logger.info("Đăng ký thành công");
        return "Successfully Register an account";
    }
}
