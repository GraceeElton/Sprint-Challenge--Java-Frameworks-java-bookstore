package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "book")
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long  bookid;

    @Column(nullable = false)
    private String booktitle;

    @Column(nullable = false, unique = true)
    private String isbn;

    private int copy;

    @ManyToOne
    @JoinColumn(name = "sectionid", nullable = false)
    @JsonIgnoreProperties(value = "book", allowSetters = true)
    private Section section;

    @OneToMany(mappedBy = "book",cascade =CascadeType.ALL)
    @JsonIgnoreProperties(value = "book",
            allowSetters = true)
    private List<Wrote> authors = new ArrayList<>();


    public Book()
    {
    }

    public Book(String booktitle, String isbn, int copy, Section section)
    {
        this.booktitle = booktitle;
        this.isbn = isbn;
        this.copy = copy;
        this.section = section;
    }

    public long getBookid()
    {
        return bookid;
    }

    public void setBookid(long bookid)
    {
        this.bookid = bookid;
    }

    public String getBooktitle()
    {
        return booktitle;
    }

    public void setBooktitle(String booktitle)
    {
        this.booktitle = booktitle;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public int getCopy()
    {
        return copy;
    }

    public void setCopy(int copy)
    {
        this.copy = copy;
    }

    public Section getSection()
    {
        return section;
    }

    public void setSection(Section section)
    {
        this.section = section;
    }


    public void setWrotes(List<Wrote> authors)
    {
        this.authors = authors;
    }


}
