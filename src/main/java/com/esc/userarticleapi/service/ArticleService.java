package com.esc.userarticleapi.service;

import java.util.List;

public interface ArticleService {
    void fillUpArticleTable();

    List<Integer> findUserIdByColor(String color);

    List<Integer> getUserIdByArticleNumberGreaterThan(Integer number);
}
