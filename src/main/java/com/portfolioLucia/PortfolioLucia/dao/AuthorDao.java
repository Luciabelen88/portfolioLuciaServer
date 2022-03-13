package com.portfolioLucia.PortfolioLucia.dao;

import com.portfolioLucia.PortfolioLucia.models.Author;

import java.util.List;

public interface AuthorDao {
    List<Author> getAuthor();
   Author getAuthorByCredentials(Author author);
}
