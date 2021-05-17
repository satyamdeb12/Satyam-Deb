package com.eshoppingzone.user.controller;

import com.eshoppingzone.user.models.AuthRequest;
import com.eshoppingzone.user.models.AuthResponse;
import com.eshoppingzone.user.models.User;
import com.eshoppingzone.user.repository.UserRepository;
import com.eshoppingzone.user.service.UserService;
import com.eshoppingzone.user.util.JwtUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    @ApiOperation(value = "Add a new User.",
            notes = "Provide the user details in the request body.",
            response = User.class)
    public User registerNewUser(@RequestBody User user){
        log.info("registerNewUser method of UserController is called");
        return userService.registerNewUser(user);
    }


    @PostMapping("/authenticate")
    @ApiOperation(value = "Authenticate User.",
            notes = "Provide the authentication request details in the request body.",
            response = User.class)
    public AuthResponse generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        log.info("generateToken method of UserController is called");
        AuthResponse authResponse = new AuthResponse();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (Exception e) {
            authResponse.setStatus(0);
            authResponse.setMessage("Invalid Username/Password");
            authResponse.setUserName(null);
            authResponse.setIsSeller(0);
            return authResponse;
        }
        User u = userRepository.findByUsername(authRequest.getUsername());

        authResponse.setStatus(1);
        authResponse.setMessage(jwtUtil.generateToken(authRequest.getUsername()));
        authResponse.setUserName(jwtUtil.extractUsername(jwtUtil.generateToken(authRequest.getUsername())));
        authResponse.setIsSeller(u.getIsSeller());
        return authResponse;
    }

    @GetMapping("/welcome")
    @ApiOperation(value = "Validate token verification.",
            notes = "Provide the jwt token in the request header.",
            response = User.class)
    public String welcome(){
        log.info("welcome method of UserController is called to check if JWT is valid");
        return "Token Verification is Working";
    }

    @GetMapping("/get/{username}")
    @ApiOperation(value = "Get User by username.",
            notes = "Provide the username in the url.",
            response = User.class)
    public User getUserById(@PathVariable("username") String id){
        log.info("getUserById method of UserController is called");
        return userService.getUserById(id);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update the user.",
            notes = "Provide the user details in the request body.",
            response = User.class)
    public User updateUser(@RequestBody User user){
        log.info("updateUser method of UserController is called");
        return userService.updateUser(user);
    }

}
