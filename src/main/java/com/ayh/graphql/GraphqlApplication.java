package com.ayh.graphql;

import com.ayh.graphql.domain.Article;
import com.ayh.graphql.service.ArticleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

	@Bean
	public CommandLineRunner insertSampleData(ArticleService articleService) {
		return args -> {

			Article article = articleService.addArticle("GraphQL with Spring Boot", "Ayh");

			articleService.addComment(article.getId(), "First comment..");
			articleService.addComment(article.getId(), "Second comment..");
			articleService.addComment(article.getId(), "Third comment..");

		};
	}

}
