package com.ayh.graphql.resolver;

import com.ayh.graphql.service.ArticleService;
import com.ayh.graphql.domain.Article;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ArticleQueryResolver implements GraphQLQueryResolver {

    private final ArticleService articleService;

    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    public Article getArticleById(Long id) {
        return articleService.getArticle(id);
    }
}
