package com.iiht.training.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	public final static String books_for_subject ="Select b from Book b Where b.subject = :subject";
	
	public final static String book_from_fitle ="Select b from Book b Where b.title = :bookTitle";

	@Query(books_for_subject)
	public List<Book> findBooksForSubject(@Param("subject") Subject subject);
	

	@Query(book_from_fitle)
	public Book findBookByTitle(@Param("bookTitle") String bookTitle);

}
