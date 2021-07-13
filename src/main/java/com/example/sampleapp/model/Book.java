package com.example.sampleapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Book {

    @Column
    private String bookname;
    @Column
    private int authorid;

    @Id
    @Column
    private int id;

    @Column
    private int price;
    @Column
    private int shelfid;

    @ManyToOne
    @JoinColumn(name = "authorid", updatable = false, insertable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "shelfid", updatable = false, insertable = false)
    private Shelf shelf;

}
