package com.project.fenix.services;

import com.project.fenix.exceptions.ResponseError;
import com.project.fenix.dto.user.UserDto;
import com.project.fenix.entities.user.User;
import com.project.fenix.security.AuthCredential;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface UserService {
    List<User> index();
    UserDto create(UserDto userDto);
    ResponseEntity login(AuthCredential presenter) throws ResponseError;
    UserDto update(Long userId, UserDto userDto) throws ResponseError;
}
