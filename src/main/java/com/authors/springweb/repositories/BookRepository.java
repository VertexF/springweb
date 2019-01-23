package com.authors.springweb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.authors.springweb.model.Book;


public interface BookRepository extends CrudRepository<Book, Long>{

}
