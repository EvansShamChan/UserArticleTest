package com.esc.userarticleapi.controller;

import com.esc.userarticleapi.entity.Article;
import com.esc.userarticleapi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Article saveArticle(@RequestBody Article article) {
        return articleService.saveArticle(article);
    }
}
