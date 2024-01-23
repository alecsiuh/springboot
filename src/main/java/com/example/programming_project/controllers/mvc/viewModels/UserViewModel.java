package com.example.programming_project.controllers.mvc.viewModels;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserViewModel {
    private long id;
    private String username;
    private String email;
    private String password;
}
