package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.exceptions.ResourceNotFoundException;
import com.lambdaschool.foundation.models.Section;
import com.lambdaschool.foundation.repository.SectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value =" sectionService")
public class SectionServiceIMPL implements SectionService
{
    @Autowired
    private SectionRepo sectionRepo;

    @Override
    public Section save(Section section)
    {

        return null;
    }

    @Override
    public Section findbyid(long id)

         throws
        EntityNotFoundException
        {
            return sectionRepo.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("User id " + id + " not found!"));
    }

//    @Override
//    public Section findbyname(String name)
//    {
//        return null;
//    }
}
