package com.rainier.gc.system.gc.services;

import java.util.List;

import com.rainier.gc.system.gc.model.Book;
import com.rainier.gc.system.gc.services.generic.GenericEntityService;

public interface BookService extends GenericEntityService<Long, Book>{
	//Book findById(Long id);
	void saveOrUpdate(Book book);

	List<Book> findAllBooks();
}
