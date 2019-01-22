package com.petclient.springweb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.petclient.springweb.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
