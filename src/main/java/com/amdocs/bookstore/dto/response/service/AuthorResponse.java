package com.amdocs.bookstore.dto.response.service;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthorResponse {
    private String id;

    private String name;
}
