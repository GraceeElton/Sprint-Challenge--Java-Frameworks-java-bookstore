package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Author;
import com.lambdaschool.foundation.models.Book;
import com.lambdaschool.foundation.models.Section;
import com.lambdaschool.foundation.repository.BookRepo;
import com.lambdaschool.foundation.repository.SectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value =" bookService")
public class BookServiceIMPL implements BookService
{

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private SectionService sectionService;

    @Override
    public List<Book> findall()
    {
        List<Book> list = new ArrayList<>();
        bookRepo.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public Book save(Book book)
    {
        Book newbook = new Book();

        newbook.setBookid(book.getBookid());
        newbook.setBooktitle(book.getBooktitle());
        newbook.setIsbn(book.getIsbn());
        newbook.setCopy(book.getCopy());
//        newbook.setSection(book.getSection());

        if (book.getSection() != null)
        {
            newbook.setSection(sectionService.findbyid(book.getSection()
                    .getsectionid()));
        }

        return bookRepo.save(newbook);
    }

    @Override
    public Book delete()
    {
        return null;
    }
}
