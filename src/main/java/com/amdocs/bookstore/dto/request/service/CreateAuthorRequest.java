package com.amdocs.bookstore.dto.request.service;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAuthorRequest {
    private String name;

    private String authorId;
}
