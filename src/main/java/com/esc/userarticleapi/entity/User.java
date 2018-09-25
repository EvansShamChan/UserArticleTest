package com.esc.userarticleapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;


    @OneToMany(mappedBy = "userId")
    private List<Article> articleList;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
