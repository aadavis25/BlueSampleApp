package com.example.sampleapp.dao;

import com.example.sampleapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorDao extends CrudRepository<Author, Integer> {

}
