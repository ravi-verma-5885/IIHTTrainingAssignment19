package com.iiht.training.dao;

import com.iiht.training.entity.Book;
import com.iiht.training.entity.Subject;

public interface ILibrarySystem {
	
	public String insertSubject(Subject subject);
	
	public String insertBook(Book addedBook, String subjectTitle);
	
	public String deleteSubject(String subjectTitleToDelete);
	
	public String deleteBook(String bookTitleToDelete);
	
	public Subject searchSubject(String subjectTitleToSearch);
	
	public Book searchBook(String bookTitleToSearch);
	
	

}
