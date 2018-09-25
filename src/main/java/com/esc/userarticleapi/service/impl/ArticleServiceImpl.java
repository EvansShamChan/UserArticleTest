package com.esc.userarticleapi.service.impl;

import com.esc.userarticleapi.entity.Article;
import com.esc.userarticleapi.repository.ArticleRepository;
import com.esc.userarticleapi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

    public void fillUpArticleTable() {
        for (int i = 0; i < 8; i++) {
            Article article = new Article(articleText[i], articleColor[i], Integer.valueOf(articleUserId[i]));
            articleRepository.save(article);
        }
    }
}
