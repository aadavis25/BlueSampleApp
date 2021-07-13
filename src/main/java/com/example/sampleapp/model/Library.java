package com.example.sampleapp.model;

import java.util.Set;
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
public class Library {

    @Id
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String address1;

    @Column
    private String address2;

    @Column
    private String city;

    @OneToMany(mappedBy = "library")
    private Set<Shelf> shelves;
}
