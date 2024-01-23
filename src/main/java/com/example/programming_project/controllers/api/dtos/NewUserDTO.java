package com.example.programming_project.controllers.api.dtos;

import lombok.*;

import javax.validation.constraints.NotBlank;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewUserDTO {
    private long id;
    @NotBlank
    private String username;
    @NotBlank
    private String email;

    private String password;
}
