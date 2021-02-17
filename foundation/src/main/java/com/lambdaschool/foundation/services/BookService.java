package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Book;

import java.util.List;

public interface BookService
{
    List<Book> findall();

    Book save(Book book);

    Book delete();

}
