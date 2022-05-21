package com.ayh.graphql.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;

    public Comment(String content, Article article) {
        this.content = content;
        this.article = article;
    }
}
