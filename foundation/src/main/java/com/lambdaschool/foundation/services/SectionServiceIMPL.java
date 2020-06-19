package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Section;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value =" sectionService")
public class SectionServiceIMPL implements SectionService
{


    @Override
    public Section save(Section section)
    {


        return null;
    }

}
