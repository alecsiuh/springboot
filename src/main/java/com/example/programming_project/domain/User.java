package com.example.programming_project.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;
    @Column(name = "userrole")
    private UserRole role;

    @OneToMany(orphanRemoval = true, mappedBy = "admin")
    List<Artist> artists;
    @OneToMany(orphanRemoval = true, mappedBy = "admin")
    List<Album> albums;
    @OneToMany(orphanRemoval = true, mappedBy = "admin")
    List<Song> songs;

    public User(String username, String password, String email, UserRole role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
