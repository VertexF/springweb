package com.authors.springweb.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

//This is a JRA which connects OOP to Relational Databases.
//The @Entity tells JRA that this needs connect. 
@Entity
public class Book {
	
	//With relational DB we need and id, this is a bleed because we don't care in OOP about ID normally.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String isbn;
	@OneToOne
	private Publisher publisher;
	
	//When we have a set we need to tell JRA how to handle the sets if there are 2 sets that are used in different classes it is a Many to Many relationship.
	@ManyToMany
	//@JoinTable is how you join to tables that will generated separately by default together.
	//@JoinColumn tells JRA how to join columns together and the name that new merged column should be called.
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
	inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authors = new HashSet<>();
	
	public Book() {}

	public Book(String title, String isbn, Set<Author> authors, Publisher publisher) {
		this.setTitle(title);
		this.setIsbn(isbn);
		this.setAuthors(authors);
		this.setPublisher(publisher);
	}

	public Book(String title, String isbn, Publisher publisher) {
		this.setTitle(title);
		this.setIsbn(isbn);
		this.setPublisher(publisher);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	//Hash code and equals is needed when you need a unique id BUT don't have a real world business key.
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + ", authors=" + authors + "]";
	}
	
	
}
