package com.rainier.gc.system.gc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rainier.gc.system.gc.model.Book;
import com.rainier.gc.system.gc.services.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	@RequestMapping(value="book/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Book getBook(@PathVariable Long id){
		return bookService.getById(id);
	}

	@PostMapping(value="saveBook")
	@ResponseBody
	public Book saveBook(@RequestBody Book book){
		bookService.saveOrUpdate(book);;
		return book;
	}
	
	@GetMapping("books")
	public List<Book> getAllBooks(){
		return bookService.findAllBooks();
	}
}
