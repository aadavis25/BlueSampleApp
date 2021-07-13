package com.example.sampleapp.controller;

import com.example.sampleapp.bo.AuthorBo;
import com.example.sampleapp.criteria.AuthorCriteria;
import com.example.sampleapp.model.Author;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    AuthorBo authorBo;

    @GetMapping("/author")
    public List<Author> getAllRecords() {
        return authorBo.getAllRecords();
    }

    @PostMapping("/author/getAllMatching")
    public List<Author> getAllMatching(@RequestBody AuthorCriteria criteria) {
        return authorBo.getAllMatching(criteria);
    }

    @GetMapping("/author/{authorid}")
    public Author getRecord(@PathVariable("authorid") int authorid) {
        return authorBo.getRecord(authorid);
    }

    @DeleteMapping("/author/{authorid}")
    public void deleteAuthor(@PathVariable("authorid") int authorid) {
        authorBo.delete(authorid);
    }

    @PostMapping("/author")
    public void saveAuthor(@RequestBody Author author) {
        authorBo.saveOrUpdate(author);
    }

    @PutMapping("/author")
    public void update(@RequestBody Author authors) {
        authorBo.saveOrUpdate(authors);
    }
}
