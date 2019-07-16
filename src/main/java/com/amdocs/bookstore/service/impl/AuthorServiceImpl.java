package com.amdocs.bookstore.service.impl;

import com.amdocs.bookstore.dto.request.service.CreateAuthorRequest;
import com.amdocs.bookstore.entity.Author;
import com.amdocs.bookstore.repository.IAuthorRepository;
import com.amdocs.bookstore.service.IAuthorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthorServiceImpl implements IAuthorService {
    @Autowired
    private IAuthorRepository authorRepository;

    @Override
    public String createAuthor(final CreateAuthorRequest authorRequest) {
        final Author author = new Author();

        BeanUtils.copyProperties(authorRequest, author);
        author.setId(UUID.randomUUID().toString());

        return authorRepository.save(author).getId();
    }
}
