package com.ayh.graphql.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Article(String title, String author) {
        this.title = title;
        this.author = author;
    }

    private String title;

    private String author;

    // @TODO GraphQL can not lazily load relational data !!!
    @OneToMany(mappedBy = "article", fetch = FetchType.EAGER)
    private List<Comment> comments;

}
