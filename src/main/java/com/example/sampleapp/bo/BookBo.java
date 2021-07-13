package com.example.sampleapp.bo;

import com.example.sampleapp.criteria.BookCriteria;
import com.example.sampleapp.dao.BookDao;
import com.example.sampleapp.model.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookBo {

    @Autowired
    BookDao booksDao;

    public List<Book> getAllRecords() {
        List<Book> books = new ArrayList<>();
        booksDao.findAll().forEach(b -> books.add(b));
        return books;
    }

    public List<Book> getAllMatching(BookCriteria criteria) {
        List<Book> books = getAllRecords();
        if (criteria.getAuthorFirstName() != null) {
            books = books.stream().filter(b -> b.getAuthor().getFirstName() == criteria.getAuthorFirstName()).collect(Collectors.toList());
        }

        if (criteria.getAuthorLastName() != null) {
            books = books.stream().filter(b -> b.getAuthor().getLastName() == criteria.getAuthorLastName()).collect(Collectors.toList());
        }

        return books;
    }

    public Book getRecord(int id) {
        return booksDao.findById(id).get();
    }

    public Book saveOrUpdate(Book books) {
        Book book = booksDao.save(books);
        return book;
    }

    public void delete(int id) {
        booksDao.deleteById(id);
    }

    public void update(Book books, int bookid) {
        booksDao.save(books);
    }
}
