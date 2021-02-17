package com.lambdaschool.foundation.controllers;


import com.lambdaschool.foundation.models.Author;
import com.lambdaschool.foundation.models.Book;
import com.lambdaschool.foundation.models.Section;
import com.lambdaschool.foundation.services.AuthorService;
import com.lambdaschool.foundation.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController
{
    ///books/books


    @Autowired
    private BookService bookService;


    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/books", produces = {"application/json"})
    public ResponseEntity<?> listAllbooks()
    {
        List<Book> allbook = bookService.findall();
        return new ResponseEntity<>(allbook, HttpStatus.OK);

    }
}
