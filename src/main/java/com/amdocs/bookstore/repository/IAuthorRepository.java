package com.amdocs.bookstore.repository;

import com.amdocs.bookstore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<Author, String> {

}
