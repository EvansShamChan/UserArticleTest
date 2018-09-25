package com.esc.userarticleapi.repository;

import com.esc.userarticleapi.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query(value = "select distinct user_id from articles where color = :color", nativeQuery = true)
    List<Integer> findUserIdByColor(@Param("color") String color);

    @Query(value = "select distinct user_id from articles group by user_id having count(*) > :number",
            nativeQuery = true)
    List<Integer> getUserIdByArticleNumberGreaterThan(@Param("number") Integer number);
}
