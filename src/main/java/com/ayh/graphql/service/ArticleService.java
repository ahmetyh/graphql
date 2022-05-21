package com.ayh.graphql.service;

import com.ayh.graphql.domain.Article;
import com.ayh.graphql.domain.Comment;
import com.ayh.graphql.repository.ArticleRepository;
import com.ayh.graphql.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {

    final private ArticleRepository articleRepository;
    final private  CommentRepository commentRepository;

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article addArticle(String title, String author) {

        Article article = new Article();
        article.setTitle(title);
        article.setAuthor(author);

        return articleRepository.save(article);
    }


    public Article getArticle(Long articleId) {
        return articleRepository.findById(articleId).orElseThrow(()->new RuntimeException("Article not found!"));
    }


    public Comment addComment(Long articleId, String comment) {
        Article article = articleRepository.findById(articleId).orElseThrow(()->new RuntimeException("Article not found!"));
        return commentRepository.save(new Comment(comment, article));
    }

}
