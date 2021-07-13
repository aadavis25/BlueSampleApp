package com.example.sampleapp.bo;

import com.example.sampleapp.dao.BookDao;
import com.example.sampleapp.model.Book;
import com.example.sampleapp.model.BookId;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class BookBoTest {

    @Autowired
    private BookBo bo;

    @Autowired
    private BookDao dao;

    @Test
    void testGet() {
        BookId id = new BookId("BookId", 1);
        Mockito.when(dao.findById(1)).thenReturn(Optional.of(new Book("BookId", 1, 1, 1, 5, null, null)));
        Book book = bo.getRecord(1);

        Assertions.assertEquals(1, book.getId());
    }

    @Test
    void testSave() {
        BookId id = new BookId("BookId", 1);
        Book book = new Book("BookId", 1, 1, 1, 5, null, null);
        Mockito.when(dao.save(book)).thenReturn(book);
        book = bo.saveOrUpdate(book);

        Assertions.assertEquals(1, book.getId());
    }

    @Test
    void testUpdate() {
//        BookId id = new BookId("BookId", 1);
        Book book = new Book("BookId", 1, 1, 1, 5, null, null);
        Mockito.when(dao.save(book)).thenReturn(book);
        book = bo.saveOrUpdate(book);

        Assertions.assertEquals(1, book.getId());
    }

    @Test
    void testDelete() {
        BookId id = new BookId("BookId", 1);
        Book book = new Book("BookId", 1, 1, 1, 5, null, null);
        dao.delete(book);

        Mockito.verify(dao, Mockito.times(1)).delete(book);
    }
}
