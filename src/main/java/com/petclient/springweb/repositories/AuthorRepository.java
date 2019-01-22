package com.petclient.springweb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.petclient.springweb.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
