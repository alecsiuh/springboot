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
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String gender;
    @Column(name = "debutyear", nullable = false, length = 4)
    private int debutYear;
    @OneToMany(orphanRemoval = true, mappedBy = "artist")
    private List<Album> albums;

    @ManyToOne
    private User admin;

    public Artist(String name, String gender, int debutYear, User admin) {
        this.name = name;
        this.gender = gender;
        this.debutYear = debutYear;
        this.admin = admin;
    }

    public Artist(long id, String name, String gender, int debutYear) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.debutYear = debutYear;
    }

    public Artist(String name, String gender, int debutYear) {
        this.name = name;
        this.gender = gender;
        this.debutYear = debutYear;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }
}
