package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.BookstoreApplication;
import com.lambdaschool.bookstore.exceptions.ResourceNotFoundException;
import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.models.Section;
import com.lambdaschool.bookstore.models.Wrote;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookstoreApplication.class)
//**********
// Note security is handled at the controller, hence we do not need to worry about security here!
//**********
public class BookServiceImplTest
{

    @Autowired
    private BookService bookService;

    @Autowired
    private SectionService sectionService;

    @Before
    public void setUp() throws
            Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws
            Exception
    {
    }

    @Test
    public void findAll()
    {
        assertEquals(5,bookService.findAll().size());
    }

    @Test
    public void findBookById()
    {
        // use id 1 to make it fail
        assertEquals("Flatterland", bookService.findBookById(26).getTitle());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void notFindBookById()
    {
    }

    @Test
    public void delete()
    {
        bookService.delete(30);
        assertEquals(4,bookService.findAll().size());
    }

    @Test
    public void save()
    {
        //  private String title;
        //    private String isbn;
        //    private int copy;
        //private Section section;
       // private Set<Wrote> wrotes

        // great thinking gracee

        Section s1 = new Section("ELTONNN");
        s1 = sectionService.save(s1);


        List<Wrote> wroteList = new ArrayList<>();

        Book newbook = new Book("Gracee","123",123, s1 );

        Book addbook = bookService.save(newbook);

        assertNotNull(addbook);
        Book foundBook = bookService.findBookById(addbook.getBookid());
        assertEquals(addbook.getTitle(),foundBook.getTitle());

    }

    @Test
    public void update()
    {
    }

    @Test
    public void deleteAll()
    {
    }
}