package com.petclient.springweb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.petclient.springweb.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{

}
