package com.example.sampleapp.controller;

import com.example.sampleapp.bo.BookBo;
import com.example.sampleapp.criteria.BookCriteria;
import com.example.sampleapp.model.Book;
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
public class BookController {

    @Autowired
    BookBo bookBo;

    @GetMapping("/book")
    public List<Book> getAllRecords() {
        return bookBo.getAllRecords();
    }

    @PostMapping("/book/getAllMatching")
    public List<Book> getAllMatching(@RequestBody BookCriteria criteria) {
        return bookBo.getAllMatching(criteria);
    }

    @GetMapping("/book/{bookid}")
    public Book getRecord(@PathVariable("bookid") int bookid) {
        return bookBo.getRecord(bookid);
    }

    @DeleteMapping("/book/{bookid}")
    public void deleteBook(@PathVariable("bookid") int bookid) {
        bookBo.delete(bookid);
    }

    @PostMapping("/book")
    public void saveBook(@RequestBody Book book) {
        bookBo.saveOrUpdate(book);
    }

    @PutMapping("/book")
    public void update(@RequestBody Book books) {
        bookBo.saveOrUpdate(books);
    }
}
