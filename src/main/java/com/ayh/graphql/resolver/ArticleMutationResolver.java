package com.ayh.graphql.resolver;

import com.ayh.graphql.service.ArticleService;
import com.ayh.graphql.domain.Article;
import com.ayh.graphql.domain.Comment;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ArticleMutationResolver implements GraphQLMutationResolver {

    private final ArticleService articleService;

    public Article addArticle(String title, String author) {
        return articleService.addArticle(title, author);
    }

    public Comment addComment(String comment, Long articleId) {
        return articleService.addComment(articleId, comment);
    }

}
