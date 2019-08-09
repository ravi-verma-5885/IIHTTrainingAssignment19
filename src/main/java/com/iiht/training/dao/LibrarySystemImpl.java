package com.iiht.training.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iiht.training.entity.Book;
import com.iiht.training.entity.BookRepository;
import com.iiht.training.entity.Subject;
import com.iiht.training.entity.SubjectRepository;

@Service
@Transactional
public class LibrarySystemImpl implements ILibrarySystem {

	@Autowired
	BookRepository bookRepo;

	@Autowired
	SubjectRepository subjectRepo;

	@Override
	public String insertSubject(Subject subject) {

		String status = "";
		try {

			subjectRepo.save(subject);

			status = "Subject added successfully.";

		} catch (Exception e) {
			status = "Subject could not be added: " + e.getMessage();
		}

		return status;
	}

	@Override
	public String insertBook(Book addedBook, String subjectTitle) {

		String status = "";
		try {

			Subject subjectReturned = findSubjectOnTitle(subjectTitle);

			if (null != subjectReturned) {
				addedBook.setSubject(subjectReturned);

				bookRepo.save(addedBook);

				status = "Book added successfully.";

			} else {
				status = "Book could not be added due to Subject does not exist for this associated book.";
			}

		} catch (Exception e) {
			status = "Book could not be added: " + e.getMessage();
		}

		return status;
	}

	@Override
	public String deleteSubject(String subjectTitleToDelete) {

		String status = "";
		try {
			Subject subjectToDelete = findSubjectOnTitle(subjectTitleToDelete);

			if (null != subjectToDelete) {

				Set<Book> booksToDelete = findBooksForSubject(subjectToDelete);

				subjectToDelete.setRefences(booksToDelete);

				subjectRepo.delete(subjectToDelete);

				status = "Subject removed successfully.";

			} else {
				status = "Subject could not be removed due to subject table is empty currently.";
			}

		} catch (Exception e) {
			status = "Subject could not be removed: " + e.getMessage();
		}

		return status;

	}

	@Override
	public String deleteBook(String bookTitleToDelete) {

		String status = "";
		try {

			Book bookToDelete = findBookOnTitle(bookTitleToDelete);

			bookRepo.delete(bookToDelete);

			status = "Book removed successfully. ";

		} catch (Exception e) {
			status = "Book could not be removed: " + e.getMessage();
		}

		return status;

	}

	@Override
	public Subject searchSubject(String subjectTitleToSearch) {

		Subject subjectFound = findSubjectOnTitle(subjectTitleToSearch);

		return subjectFound;

	}

	@Override
	public Book searchBook(String bookTitleToSearch) {

		Book bookReturned = findBookOnTitle(bookTitleToSearch);

		return bookReturned;

	}

	private Book findBookOnTitle(String bookTitleToSearch) {

		Book bookReturned = bookRepo.findBookByTitle(bookTitleToSearch);

		return bookReturned;

	}

	private Subject findSubjectOnTitle(String subjectTitleToSearch) {

		Subject subjectReturned = subjectRepo.findSubjectByTitle(subjectTitleToSearch);

		return subjectReturned;

	}

	private Set<Book> findBooksForSubject(Subject subject) {


		Set<Book> refences = new HashSet<>();

		List<Book> bookList = bookRepo.findBooksForSubject(subject);

		refences.addAll(bookList);

		return refences;

	}

}
