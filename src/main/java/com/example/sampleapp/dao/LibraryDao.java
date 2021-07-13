package com.example.sampleapp.dao;

import com.example.sampleapp.model.Library;
import org.springframework.data.repository.CrudRepository;

public interface LibraryDao extends CrudRepository<Library, Integer> {

}
