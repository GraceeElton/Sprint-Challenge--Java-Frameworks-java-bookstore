package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
public class Section
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long  sectionid;

    @Column(nullable = false, unique = true)
    private String sectioname;

    @OneToMany(mappedBy = "section",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties(value = "section",
            allowSetters = true)
    private List<Book> book = new ArrayList<>();

    public Section()
    {
    }

    public Section(String sectioname)
    {
        this.sectioname = sectioname;

    }

    public long getsectionid()
    {
        return sectionid;
    }

    public void setsectionid(long asectionid)
    {
        this.sectionid = asectionid;
    }

    public String getSectioname()
    {
        return sectioname;
    }

    public void setSectioname(String sectioname)
    {
        this.sectioname = sectioname;
    }

    public List<Book> getBook()
    {
        return book;
    }

    public void setBook(List<Book> book)
    {
        this.book = book;
    }
}
