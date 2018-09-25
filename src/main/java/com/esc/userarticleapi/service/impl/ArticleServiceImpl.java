package com.esc.userarticleapi.service.impl;

import com.esc.userarticleapi.entity.Article;
import com.esc.userarticleapi.repository.ArticleRepository;
import com.esc.userarticleapi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Value("${db.articletext}")
    private String[] articleText;

    @Value("${db.articlecolor}")
    private String[] articleColor;

    @Value("${db.articleuserid}")
    private String[] articleUserId;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public void fillUpArticleTable() {
        for (int i = 0; i < 8; i++) {
            Article article = new Article(articleText[i], articleColor[i], Integer.valueOf(articleUserId[i]));
            articleRepository.save(article);
        }
    }

    @Override
    public List<Integer> findUserIdByColor(String color) {
        return articleRepository.findUserIdByColor(color);
    }

    @Override
    public List<Integer> getUserIdByArticleNumberGreaterThan(Integer number) {
        return articleRepository.getUserIdByArticleNumberGreaterThan(number);
    }

    @Override
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }
}
