package com.iiht.training.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iiht.training.dao.ILibrarySystem;
import com.iiht.training.entity.Book;
import com.iiht.training.entity.Subject;
import com.iiht.training.helper.LibraryUtilities;

@Controller
public class LibraryMainController {

	@Autowired
	ILibrarySystem libraryService;

	@RequestMapping("/addSubject")
	public ModelAndView addSubject(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView modelAndView = new ModelAndView("result");

		int subjectId = Integer.parseInt(request.getParameter("subjectId"));

		String subjectTitle = request.getParameter("subjectTitle");

		int duration = Integer.parseInt(request.getParameter("duration"));

		Subject subject = new Subject(subjectId, subjectTitle, duration);

		String message = libraryService.insertSubject(subject);

		modelAndView.addObject("message", message);

		return modelAndView;

	}

	@RequestMapping("/addBook")
	public ModelAndView addBook(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView modelAndView = new ModelAndView("result");

		int bookId = Integer.parseInt(request.getParameter("bookId"));

		String bookTitle = request.getParameter("bookTitle");

		double price = Double.parseDouble(request.getParameter("bookPrice"));

		int volume = Integer.parseInt(request.getParameter("volume"));

		String sDate = request.getParameter("publishDate");

		Date publishDate = LibraryUtilities.dateFromString(sDate, LibraryUtilities.SDF_MMDDYYYY);

		Book newBook = new Book(bookId, bookTitle, price, volume, publishDate);

		String subjectTitle = request.getParameter("subjectTitle");

		String message = libraryService.insertBook(newBook, subjectTitle);

		modelAndView.addObject("message", message);

		return modelAndView;

	}

	@RequestMapping("/deleteSubject")
	public ModelAndView deleteSubject(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView modelAndView = new ModelAndView("result");

		String subjectTitle = request.getParameter("subjectTitle");

		String message = libraryService.deleteSubject(subjectTitle);

		modelAndView.addObject("message", message);

		return modelAndView;

	}

	@RequestMapping("/deleteBook")
	public ModelAndView deleteBook(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView modelAndView = new ModelAndView("result");

		String bookTitle = request.getParameter("bookTitle");

		String message = libraryService.deleteBook(bookTitle);

		modelAndView.addObject("message", message);

		return modelAndView;

	}

	@RequestMapping("/searchBook")
	public ModelAndView searchBook(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView modelAndView = new ModelAndView("result");

		String bookTitle = request.getParameter("bookTitle");

		Book book = libraryService.searchBook(bookTitle);

		if (null != book) {

			modelAndView.addObject("message", "Book found successfully.");
			
			modelAndView.addObject("book", book);

		} else {

			modelAndView.addObject("message", "Book not found.");

		}

		return modelAndView;

	}

	@RequestMapping("/searchSubject")
	public ModelAndView searchSubject(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView modelAndView = new ModelAndView("result");

		String subjectTitle = request.getParameter("subjectTitle");

		Subject subject = libraryService.searchSubject(subjectTitle);

		if (null != subject) {

			modelAndView.addObject("message", "Subject found successfully.");
			
			modelAndView.addObject("subject", subject);

		} else {

			modelAndView.addObject("message", "Subject not found.");

		}

		return modelAndView;

	}

}
