package com.portfolioLucia.PortfolioLucia.dao;

import com.portfolioLucia.PortfolioLucia.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Author> getAuthor() {
        String query = "FROM Author";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void setEncodedPassword(String password) {
        Author authorToModify = entityManager.find(Author.class, this.getAuthor().get(0).getUsername());
        entityManager.detach(authorToModify);
        authorToModify.setPassword(passwordEncoder.encode(password));
        entityManager.merge(authorToModify);
    }

    @Override
    public void updateAuthor(Author author) {
        Author authorToModify = entityManager.find(Author.class, author.getUsername());
        entityManager.detach(authorToModify);
        authorToModify = author;
        entityManager.merge(authorToModify);

    }


}
