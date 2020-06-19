package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "author")
public class Author extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long  authorid;

    private String lastname;
    private String firstname;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "author", allowSetters = true)
    private List<Wrote> book = new ArrayList<>();


    public Author()
    {
    }

    public String getCreatedBy()
    {
        return createdBy;
    }

    public Date getCreatedDate()
    {
        return createdDate;
    }

    public String getLastModifiedBy()
    {
        return lastModifiedBy;
    }

    public Date getLastModifiedDate()
    {
        return  lastModifiedDate;
    }



    public Author(String lastname, String firstname )
    {
        this.lastname = lastname;
        this.firstname = firstname;

    }

    public long getAuthorid()
    {
        return authorid;
    }

    public void setAuthorid(long authorid)
    {
        this.authorid = authorid;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public List<Wrote> getBook()
    {
        return book;
    }

    public void setBook(List<Wrote> book)
    {
        this.book = book;
    }
}
