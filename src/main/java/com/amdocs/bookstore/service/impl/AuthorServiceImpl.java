package com.amdocs.bookstore.service.impl;

import com.amdocs.bookstore.dto.request.service.CreateAuthorRequest;
import com.amdocs.bookstore.dto.response.service.AuthorResponse;
import com.amdocs.bookstore.entity.Author;
import com.amdocs.bookstore.repository.IAuthorRepository;
import com.amdocs.bookstore.service.IAuthorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements IAuthorService {
    @Autowired
    private IAuthorRepository authorRepository;

    @Override
    public String createAuthor(final CreateAuthorRequest authorRequest) {
        return saveOrUpdate(authorRequest).getId();
    }

    @Override
    public void updateAuthor(final CreateAuthorRequest authorRequest) {
        findById(authorRequest.getAuthorId());

        saveOrUpdate(authorRequest);
    }

    @Override
    public List<AuthorResponse> listAuthors() {
        return authorRepository.findAll().stream()
                .map(author -> buildAuthorResponse(author))
                .collect(Collectors.toList());
    }

    @Override
    public AuthorResponse findAuthor(final String id) {
        return buildAuthorResponse(findById(id));
    }

    @Override
    public void removeAuthor(final String id) {
        authorRepository.delete(findById(id));
    }

    private Author saveOrUpdate(final CreateAuthorRequest authorRequest) {
        final Author author = new Author();

        BeanUtils.copyProperties(authorRequest, author);

        if (authorRequest.getAuthorId() == null) {
            author.setId(UUID.randomUUID().toString());
        }

        return authorRepository.save(author);
    }

    private Author findById(final String id) {
        final Optional<Author> authorOptional = authorRepository.findById(id);

        authorOptional.orElseThrow(() -> new RuntimeException("Author does not exist."));

        return authorOptional.get();
    }

    private AuthorResponse buildAuthorResponse(final Author author) {
        return AuthorResponse.builder()
                .id(author.getId())
                .name(author.getName())
                .build();
    }
}
