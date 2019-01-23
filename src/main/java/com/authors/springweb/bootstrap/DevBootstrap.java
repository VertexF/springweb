package com.authors.springweb.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.authors.springweb.model.Author;
import com.authors.springweb.model.Book;
import com.authors.springweb.model.Publisher;
import com.authors.springweb.repositories.AuthorRepository;
import com.authors.springweb.repositories.BookRepository;
import com.authors.springweb.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	public void initData() {
		Publisher harper = new Publisher("Harper Collins", "23 Carrot Road Cupcake Town LN34");
		publisherRepository.save(harper);
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", harper);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		Publisher worx = new Publisher("Worx", "34 Faraway Road Pixy City CC88");
		publisherRepository.save(worx);
		
		Author rob = new Author("Rob", "Johnson");
		Book noEJB = new Book("J2EE Developement without EJB", "23444", worx);
		rob.getBooks().add(noEJB);
		noEJB.getAuthors().add(rob);
		
		authorRepository.save(rob);
		bookRepository.save(noEJB);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}

}
