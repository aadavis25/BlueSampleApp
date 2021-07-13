package com.example.sampleapp.dao;

import com.example.sampleapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookDao extends CrudRepository<Book, Integer> {

}
