package com.amdocs.bookstore.service;

import com.amdocs.bookstore.dto.request.service.CreateAuthorRequest;
import com.amdocs.bookstore.dto.response.service.AuthorResponse;

import java.util.List;

public interface IAuthorService {
    String createAuthor(CreateAuthorRequest authorRequest);

    void updateAuthor(CreateAuthorRequest authorRequest);

    List<AuthorResponse> listAuthors();

    AuthorResponse findAuthor(String id);

    void removeAuthor(String id);
}
