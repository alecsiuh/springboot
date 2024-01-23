package com.example.programming_project.controllers.api;

import com.example.programming_project.controllers.api.dtos.NewUserDTO;
import com.example.programming_project.controllers.api.dtos.UserDTO;
import com.example.programming_project.domain.User;
import com.example.programming_project.exceptions.UserNotFoundException;
import com.example.programming_project.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UsersController {
    private final UserService userService;

    @PostMapping("register")
    public ResponseEntity<UserDTO> addUser(
            @RequestBody @Valid NewUserDTO userDTO) {
        try {
            User createdUser = userService.addUser(
                    userDTO.getUsername(),
                    userDTO.getEmail(),
                    userDTO.getPassword());
            return new ResponseEntity<>(
                    new UserDTO(
                            createdUser.getId(),
                            createdUser.getUsername(),
                            createdUser.getEmail(),
                            createdUser.getPassword()),
                    HttpStatus.CREATED);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
