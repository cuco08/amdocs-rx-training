package com.amdocs.bookstore.controller;

import com.amdocs.bookstore.dto.request.service.CreateAuthorRequest;
import com.amdocs.bookstore.dto.response.web.BaseWebResponse;
import com.amdocs.bookstore.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/v1/authors")
public class AuthorController {
    @Autowired
    private IAuthorService authorService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<BaseWebResponse> createAuthor(@RequestBody CreateAuthorRequest request) {
        final String id = authorService.createAuthor(request);

        return ResponseEntity.created(URI.create("/api/authors/" + id)).body(BaseWebResponse.successWithData(id));
    }
}
