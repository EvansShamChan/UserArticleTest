package com.esc.userarticleapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "text")
    private String text;

    @Enumerated(EnumType.STRING)
    @Column(name = "color")
    private SelectedColor color;

    enum SelectedColor {
        BLACK,
        WHITE,
        GREEN,
        BLUE,
        YELLOW
    }

    @Column(name = "user_id")
    private Integer userId;

    public Article(String text, String color, Integer userId) {
        this.text = text;
        this.color = Enum.valueOf(SelectedColor.class, color);
        this.userId = userId;
    }
}
