package com.project.fenix.services.impl;

import com.project.fenix.exceptions.ResponseError;
import com.project.fenix.dto.TokenDto;
import com.project.fenix.dto.user.UserDto;
import com.project.fenix.entities.user.User;
import com.project.fenix.enums.EnumStatus;
import com.project.fenix.repository.UserRepository;
import com.project.fenix.security.AuthCredential;
import com.project.fenix.security.TokenUtils;
import com.project.fenix.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<User> index() {
        return userRepository.findAll();
    }

    @Override
    public UserDto create(UserDto userDto) {
        User user = userRepository.save(modelMapper.map(userDto, User.class));
        user.setPassword("");
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public ResponseEntity login(AuthCredential presenter) throws ResponseError {
        //TODO: Valida empresa y usuarios activos
        Optional<User> user = userRepository.findOneByEmailOrUsername(presenter.getUsername(), presenter.getUsername());

        if (user.isEmpty())
            throw new ResponseError(HttpStatus.NOT_FOUND, "Error: no existe el usuario ingresado");

        if (user.get().getStatus().equals(EnumStatus.INA))
            throw new ResponseError(HttpStatus.BAD_REQUEST, "Error: Usuario Bloqueado");

        if (passwordEncoder.matches(presenter.getPassword(), user.get().getPassword())) {
            UserDto userDto = modelMapper.map(user.get(), UserDto.class);
            userDto.setPassword("");
            return new ResponseEntity(new TokenDto(TokenUtils.generateToken(user.get().getUsername(), user.get().getEmail()), userDto), HttpStatus.OK);
        } else {
            throw new ResponseError(HttpStatus.BAD_REQUEST, "Error: Credenciales incorrectas");
        }
    }

    @Override
    public UserDto update(Long userId, UserDto userDto) throws ResponseError {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty())
            throw new ResponseError(HttpStatus.NOT_FOUND,"Error: Usuario no encontrado");

        user.get().setUsername(userDto.getUsername());
        user.get().setEmail(userDto.getEmail());

        return modelMapper.map(userRepository.save(user.get()), UserDto.class);
    }
}
