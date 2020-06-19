package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "wrote",uniqueConstraints = {@UniqueConstraint(columnNames = {"bookid", "authorid"})})
public class Wrote extends Auditable implements Serializable
{

    @Id
    @ManyToOne
    @JoinColumn(name="bookid")
    @JsonIgnoreProperties(value ="book", allowSetters = true)
    private Book book;

    @Id
    @ManyToOne
    @JoinColumn(name= "authorid")
    @JsonIgnoreProperties(value ="author", allowSetters = true)
    private Author author;

    public Wrote()
    {
    }

    public Wrote(Author author, Book book )
    {
        this.book = book;
        this.author = author;
    }

    public Book getBook()
    {
        return book;
    }

    public void setBook(Book book)
    {
        this.book = book;
    }

    public Author getAuthor()
    {
        return author;
    }

    public void setAuthor(Author author)
    {
        this.author = author;
    }
}
