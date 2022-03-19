package com.portfolioLucia.PortfolioLucia.dao;

import com.portfolioLucia.PortfolioLucia.models.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class AuthorDaoImp implements AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Author> getAuthor() {
        String query = "FROM Author";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Author getAuthorByCredentials(Author author) {
        String query = "FROM Author WHERE email = :email AND password = :password";
        List<Author> lista = entityManager.createQuery(query)
                .setParameter("email", author.getEmail())
                .setParameter("password", author.getPassword())
                .getResultList();
        if (lista.isEmpty())
            return null;
        else
            return lista.get(0);

    }

    @Override
    public void deleteAuthor(Long user_name) {
        Author author = entityManager.find(Author.class, user_name);
        entityManager.remove(author);
    }

    @Override
    public void addAuthor(Author author) {
        entityManager.merge(author);
    }

    @Override
    public Author updateAuthor(Author author) {
        Author authorToModify = entityManager.find(Author.class, author.getUser_name());
        entityManager.detach(authorToModify);
        authorToModify = author;
        return entityManager.merge(authorToModify);

    }
}
