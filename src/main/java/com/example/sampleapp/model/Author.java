package com.example.sampleapp.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Author {

    @Id
    @Column
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    Set<Book> books;
}
