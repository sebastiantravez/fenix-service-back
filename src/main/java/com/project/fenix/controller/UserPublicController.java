package com.project.fenix.controller;

import com.project.fenix.exceptions.ResponseError;
import com.project.fenix.security.AuthCredential;
import com.project.fenix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class UserPublicController {

    @Autowired
    private UserService userService;

    @PostMapping("/change/password/{userId}")
    public ResponseEntity changePassword(@PathVariable Long userId){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthCredential authCredential) throws ResponseError {
        return userService.login(authCredential);
    }
}
