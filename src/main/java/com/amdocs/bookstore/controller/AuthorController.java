package com.amdocs.bookstore.controller;

import com.amdocs.bookstore.dto.request.service.CreateAuthorRequest;
import com.amdocs.bookstore.dto.response.service.AuthorResponse;
import com.amdocs.bookstore.dto.response.web.BaseWebResponse;
import com.amdocs.bookstore.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/author")
public class AuthorController {
    @Autowired
    private IAuthorService authorService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<BaseWebResponse> createAuthor(@RequestBody CreateAuthorRequest request) {
        final String id = authorService.createAuthor(request);

        return ResponseEntity.created(URI.create("/api/authors/" + id)).body(BaseWebResponse.successWithData(id));
    }

    @PatchMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<BaseWebResponse> updateAuthor(@RequestBody CreateAuthorRequest request) {
        authorService.updateAuthor(request);

        return ResponseEntity.noContent().build();
    }

    @GetMapping(consumes = "application/json", produces = "application/json")
    @RequestMapping(path = "/{id}")
    public ResponseEntity<BaseWebResponse> findAuthor(@PathVariable("id") String id) {
        final AuthorResponse authorResponse = authorService.findAuthor(id);

        return ResponseEntity.created(URI.create("/api/authors/" + id)).body(BaseWebResponse.successWithData(authorResponse));
    }

    @GetMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<BaseWebResponse> listAuthors() {
        final List<AuthorResponse> authors = authorService.listAuthors();

        return ResponseEntity.created(URI.create("/api/authors/")).body(BaseWebResponse.successWithData(authors));
    }

    @DeleteMapping(consumes = "application/json", produces = "application/json")
    @RequestMapping(path = "/delete/{id}")
    public ResponseEntity<BaseWebResponse> removeAuthor(@PathVariable("id") String id) {
        authorService.removeAuthor(id);

        return ResponseEntity.created(URI.create("/api/authors/" + id)).body(BaseWebResponse.successWithData(id));
    }
}
