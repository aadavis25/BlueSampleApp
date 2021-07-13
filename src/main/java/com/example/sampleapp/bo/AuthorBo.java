package com.example.sampleapp.bo;

import com.example.sampleapp.criteria.AuthorCriteria;
import com.example.sampleapp.dao.AuthorDao;
import com.example.sampleapp.model.Author;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorBo {

    @Autowired
    AuthorDao authorsDao;

    public List<Author> getAllRecords() {
        List<Author> authors = new ArrayList<>();
        authorsDao.findAll().forEach(b -> authors.add(b));
        return authors;
    }

    public List<Author> getAllMatching(AuthorCriteria criteria) {
        List<Author> authors = getAllRecords();
        if (criteria.getAuthorFirstName() != null) {
            authors = authors.stream().filter(b -> b.getFirstName() == criteria.getAuthorFirstName()).collect(Collectors.toList());
        }

        if (criteria.getAuthorLastName() != null) {
            authors = authors.stream().filter(b -> b.getLastName() == criteria.getAuthorLastName()).collect(Collectors.toList());
        }

        return authors;
    }

    public Author getRecord(int id) {
        return authorsDao.findById(id).get();
    }

    public void saveOrUpdate(Author authors) {
        authorsDao.save(authors);
    }

    public void delete(int id) {
        authorsDao.deleteById(id);
    }

    public void update(Author authors, int authorid) {
        authorsDao.save(authors);
    }
}
