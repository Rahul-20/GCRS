package com.rainier.gc.system.gc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rainier.gc.system.gc.model.Book;
import com.rainier.gc.system.gc.repositories.BookRepository;
import com.rainier.gc.system.gc.services.generic.GenericrEntityServiceImpl;

@Service
@Transactional
public class BookServiceImpl extends GenericrEntityServiceImpl<Long, Book>
							 implements BookService {

	@Autowired
	BookRepository bookRepository;

	public BookServiceImpl(BookRepository repository) {
		super(repository);
		this.bookRepository = repository;
	}


	@Override
	public void saveOrUpdate(Book book) {
		this.save(book);
	}
	
	@Override
	public List<Book> findAllBooks(){
		return this.list();
	}

}
