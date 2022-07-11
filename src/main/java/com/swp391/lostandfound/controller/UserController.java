package com.swp391.lostandfound.controller;

import com.swp391.lostandfound.DTO.*;
import com.swp391.lostandfound.dataFormat.ListUsersData;
import com.swp391.lostandfound.dataFormat.UserData;
import com.swp391.lostandfound.entity.User;
import com.swp391.lostandfound.jwt.JwtConfig;
import com.swp391.lostandfound.service.UserService;

import io.jsonwebtoken.Jwts;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.crypto.SecretKey;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;

@RestController
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    private UserService userService;

    public UserController(AuthenticationManager authenticationManager, JwtConfig jwtConfig, SecretKey secretKey,
                          PasswordEncoder passwordEncoder, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtConfig = jwtConfig;
        this.secretKey = secretKey;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @GetMapping("/user")
    ListUsersData getAllUsers() {
        ListUsersData users = new ListUsersData();
        users.setData(userService.getAllUsers());
        if (userService.getAllUsers().isEmpty()) {
            users.setMessage("List is empty");
        } else
            users.setMessage("get all enable users successfully");
        users.setStatus("success");
        return users;
    }

    @PostMapping("/user/authenticate")
    @PermitAll
    public ResponseEntity<ResponseDTO> authenticate(@Valid @RequestBody AuthenticateDTO userLogin) {
        ResponseDTO responseDTO = new ResponseDTO();
        Authentication authentication = new UsernamePasswordAuthenticationToken(userLogin.getStudentCode(), userLogin.getPassword());
        try {
            Authentication authenticate = authenticationManager.authenticate(authentication);

            if (authenticate.isAuthenticated()) {
                User userAuthen = userService.findUserByStudentCode(userLogin.getStudentCode());
                String token = Jwts.builder().setSubject(authenticate.getName())
                        .claim("authorities", authenticate.getAuthorities())
                        .claim("userId", userAuthen.getId())
                        .setIssuedAt((new Date())).setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(1)))
                        .signWith(secretKey).compact();

                LoginResponseDTO loginResponseDTO = LoginResponseDTO.builder().firstName(userAuthen.getFirstName())
                        .lastName(userAuthen.getLastName()).studentCode(userAuthen.getStudentCode())
                        .email(userAuthen.getEmail()).role(userAuthen.getRole()).token(jwtConfig.getTokenPrefix() + token).build();

                responseDTO.setData(loginResponseDTO);
                responseDTO.setSuccessCode("Login success");
                return ResponseEntity.ok().body(responseDTO);
            }else {
                responseDTO.setErrorCode("login fail");
                return ResponseEntity.ok().body(responseDTO);
            }

        } catch (Exception e) {
            responseDTO.setErrorCode(e.getMessage());
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @GetMapping("/user/{id}")
    UserData getUserById(@PathVariable int id) {
        UserData userData = new UserData();
        User user = userService.findUserById(id);
        if (user != null) {
            userData.setMessage("Find User Succcessfully");
            userData.setUser(user);
            userData.setStatus("Success");
        } else {
            userData.setMessage("User is not exist");
            userData.setStatus("Fail");
        }
        return userData;
    }

    @PutMapping("/user/edit/{id}")
    UserData updateUser(@PathVariable int id, UserUpdateDTO updateDTO) {
        UserData userData = new UserData();
        User user = userService.updateUser(id, updateDTO);
        if (user != null) {
            userData.setMessage("Update User Succcessfully");
            userData.setUser(user);
            userData.setStatus("Success");
        } else {
            userData.setMessage("User is not exist");
            userData.setStatus("Fail");
        }
        return userData;
    }

    @PostMapping("/user")
    public ResponseEntity<ResponseDTO> createUser(UserAddDTO userAddDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        this.userService.addUser(UserAddDTO.builder().firstName(userAddDTO.getFirstName()).lastName(userAddDTO.getLastName())
                .birthday(userAddDTO.getBirthday()).gender(userAddDTO.getGender()).studentCode(userAddDTO.getStudentCode())
                .email(userAddDTO.getEmail()).phoneNumber(userAddDTO.getPhoneNumber())
                .password(passwordEncoder.encode(userAddDTO.getPassword())).build());
        Authentication authentication = new UsernamePasswordAuthenticationToken(userAddDTO.getStudentCode(), userAddDTO.getPassword());
        try {
            Authentication authenticate = authenticationManager.authenticate(authentication);
        if(authenticate.isAuthenticated()){
        User userAuthenticated = userService.findUserByStudentCode(userAddDTO.getStudentCode());

        String token = Jwts.builder().setSubject(authenticate.getName())
                .claim("authorities", authenticate.getAuthorities()).claim("userId", userAuthenticated.getId())
                .setIssuedAt((new Date())).setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(1)))
                .signWith(secretKey).compact();

        LoginResponseDTO loginResponseDTO = LoginResponseDTO.builder().firstName(userAuthenticated.getFirstName())
                .lastName(userAuthenticated.getLastName()).studentCode(userAuthenticated.getStudentCode())
                .email(userAuthenticated.getEmail()).role(userAuthenticated.getRole()).token(jwtConfig.getTokenPrefix() + token).build();

        responseDTO.setData(loginResponseDTO);
        responseDTO.setSuccessCode("Create User Succcessfully");
        return ResponseEntity.ok().body(responseDTO);
        }else {
            responseDTO.setErrorCode("Create User Failed");
            return ResponseEntity.badRequest().body(responseDTO);
        }
        }catch (Exception e){
                responseDTO.setErrorCode(e.getMessage());
                return ResponseEntity.badRequest().body(responseDTO);
        }
//        User user = userService.addUser(userAddDTO);
//        if (user != null) {
//            userData.setMessage("Create User Succcessfully");
//            userData.setUser(user);
//            userData.setStatus("Success");
//        } else {
//            userData.setMessage("Create User Failed");
//            userData.setStatus("Fail");
//        }
//
//        return userData;
    }

    @DeleteMapping("/user/{id}")
    UserData deleteUserById(@PathVariable int id) {
        UserData userData = new UserData();
        if (userService.deleteUserById(id)) {
            userData.setMessage("Delete User Succcessfully");
            userData.setStatus("Success");
        } else {
            userData.setMessage("User is not exist");
            userData.setStatus("Fail");
        }

        return userData;
    }

    @GetMapping("/user/findByPhone")
    UserData findUserByPhone(String phoneNumber) {
        UserData userData = new UserData();
        User user = userService.findUserByPhone(phoneNumber);
        if (user != null) {
            userData.setMessage("Find User successfully");
            userData.setUser(user);
            userData.setStatus("Success");
        } else {
            userData.setMessage("User is not exist");
            userData.setStatus("Fail");
        }
        return userData;
    }

    @GetMapping("/user/findByEmail")
    UserData findUserByEmail(String email) {
        UserData userData = new UserData();
        User user = userService.findUserByEmail(email);
        if (user != null) {
            userData.setMessage("Find User successfully");
            userData.setUser(user);
            userData.setStatus("Success");
        } else {
            userData.setMessage("User is not exist");
            userData.setStatus("Fail");
        }
        return userData;
    }

    @GetMapping("/user/findByStudentCode")
    UserData findUserByStudentCode(String studentCode) {
        UserData userData = new UserData();
        User user = userService.findUserByStudentCode(studentCode);
        if (user != null) {
            userData.setMessage("Find User successfully");
            userData.setUser(user);
            userData.setStatus("Success");
        } else {
            userData.setMessage("User is not exist");
            userData.setStatus("Fail");
        }
        return userData;
    }

}
