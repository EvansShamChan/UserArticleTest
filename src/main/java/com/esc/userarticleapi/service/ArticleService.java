package com.esc.userarticleapi.service;

import com.esc.userarticleapi.entity.Article;

import java.util.List;

public interface ArticleService {
    void fillUpArticleTable();

    List<Integer> findUserIdByColor(String color);

    List<Integer> getUserIdByArticleNumberGreaterThan(Integer number);

    Article saveArticle(Article article);
}
