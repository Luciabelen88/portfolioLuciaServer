package com.portfolioLucia.PortfolioLucia.dao;

import com.portfolioLucia.PortfolioLucia.models.Author;

import java.util.List;

public interface AuthorDao {
    List<Author> getAuthor();
   Author getAuthorByCredentials(Author author);

    void deleteAuthor(Long user_name);

    void addAuthor(Author author);

    Author updateAuthor(Author author);
}
