# Spring Boot CRUD Application with GraphQL

## GraphQL Schema
~~~
type Article {
    id: ID!
    title: String!
    author: String!
    comments: [Comment]
}


type Comment {
    id: ID!
    content: String!
    article: Article!
}


# Mutation: to add entities
type Mutation {
	addArticle(title: String!, author: String!): Article!
	addComment(comment: String!, articleId:Int!): Comment!
}

# The Root Query for the application
type Query {
    getAllArticles: [Article]
    getArticleById(id:Int): Article
}
~~~


## GraphQL Client

~~~
http://localhost:8080
~~~

## Mutation Example
~~~
mutation {
  addComment(comment:"very good", articleId:1) {
    id,
    content
   
  }
}
~~~

## Query Example
~~~
query {
  getAllArticles {
    id,
    title,
    author
    comments {id, content}
  }
}
~~~

