package com.authors.springweb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.authors.springweb.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
