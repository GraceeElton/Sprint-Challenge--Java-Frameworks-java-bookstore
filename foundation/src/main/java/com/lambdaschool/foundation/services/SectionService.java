package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Section;

public interface SectionService
{

    Section findbyid(long id);

//    Section findbyname(String name);

    Section save(Section section);
}
