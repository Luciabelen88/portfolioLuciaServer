package com.portfolioLucia.PortfolioLucia.service;

import com.portfolioLucia.PortfolioLucia.dao.AuthorDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthorDaoImp authorDaoImp;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        if (Objects.equals(username, authorDaoImp.getAuthor().get(0).getUsername())) {
            return new User(authorDaoImp.getAuthor().get(0).getUsername(),authorDaoImp.getAuthor().get(0).getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User is not registered");
        }
    }
}
