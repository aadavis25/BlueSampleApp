package com.example.sampleapp.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Shelf {

    @Id
    @Column
    private int id;

    @Column(length = 3, nullable = false)
    private String location;

    @Column(nullable = false)
    private int libraryId;

    @ManyToOne
    @JoinColumn(name = "libraryId", insertable = false, updatable = false)
    private Library library;

    @OneToMany(mappedBy = "shelf")
    Set<Book> book;
}
