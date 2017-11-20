package com.rainier.gc.system.gc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rainier.gc.system.gc.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}