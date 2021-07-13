package com.example.sampleapp.controller;

import com.example.sampleapp.bo.LibraryBo;
import com.example.sampleapp.criteria.LibraryCriteria;
import com.example.sampleapp.model.Library;
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
public class LibraryController {

    @Autowired
    LibraryBo libraryBo;

    @GetMapping("/library")
    public List<Library> getAllRecords() {
        return libraryBo.getAllRecords();
    }

    @PostMapping("/library/getAllMatching")
    public List<Library> getAllMatching(@RequestBody LibraryCriteria criteria) {
        return libraryBo.getAllMatching(criteria);
    }

    @GetMapping("/library/{libraryid}")
    public Library getRecord(@PathVariable("libraryid") int libraryid) {
        return libraryBo.getRecord(libraryid);
    }

    @DeleteMapping("/library/{libraryid}")
    public void deleteLibrary(@PathVariable("libraryid") int libraryid) {
        libraryBo.delete(libraryid);
    }

    @PostMapping("/library")
    public void saveLibrary(@RequestBody Library library) {
        libraryBo.saveOrUpdate(library);
    }

    @PutMapping("/library")
    public void update(@RequestBody Library librarys) {
        libraryBo.saveOrUpdate(librarys);
    }
}
