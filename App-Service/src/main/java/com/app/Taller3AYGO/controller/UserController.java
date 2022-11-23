package com.app.Taller3AYGO.controller;

import com.app.Taller3AYGO.constant.RestEndpoint;
import com.app.Taller3AYGO.dto.UserDto;
import com.app.Taller3AYGO.service.api.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestEndpoint.USERS)
@CrossOrigin(origins = "https://localhost:3000")
public class UserController {

    private IUserService userService;
    private SessionRegistry sessionRegistry;

    public UserController(IUserService userService, SessionRegistry sessionRegistry){
        this.userService = userService;
        this.sessionRegistry = sessionRegistry;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDto user){

        try {
            var existingUser = userService.findUserByEmailAndUsername(user.getEmail(), user.getUserName());
            if(existingUser == null){
                userService.createUser(user);
                return new ResponseEntity<>("User created", HttpStatus.OK);
            }else{
                String errorMessage = String.format("User already exists with email: [%s] or user name: [%s]",
                        user.getEmail(), user.getUserName());
                return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e){
            return new ResponseEntity<>("There was a problem creating the user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> getUsers(){

        try {
            List<UserDto> users = userService.getUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("There was a problem getting the users", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/logged")
    public Integer getLoggedUsers() {
        List<Object> allPrincipals = sessionRegistry.getAllPrincipals();
        return allPrincipals.size();
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<?> deleteUser(@PathVariable String userName){

        try {
            userService.deleteUserByUserName(userName);
            return new ResponseEntity<>("User has been deleted", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("There was a problem deleting the user", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
