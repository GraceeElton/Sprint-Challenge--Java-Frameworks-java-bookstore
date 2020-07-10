package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.exceptions.ResourceNotFoundException;
import com.lambdaschool.foundation.models.*;
import com.lambdaschool.foundation.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value =" authorService")
public class AuhtorServiceIMPL implements AuthorService
{
    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public List<Author> findall()
    {
        List<Author> list = new ArrayList<>();
        authorRepo.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Author save(Author author)
    {

        Author newAuthor = new Author();

        newAuthor.setFirstname(author.getFirstname());
        newAuthor.setLastname(author.getLastname());

        for (Wrote w : author.getWrote())
        {
            newAuthor.getWrote()
                    .add(new Wrote(newAuthor,
                            w.getBook()));
        }

        return authorRepo.save(newAuthor);
    }
}
