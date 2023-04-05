package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exceptions.BookNotFoundException;
import com.example.model.Book;

import reactor.core.publisher.Mono;

@RestController
public class BookController {

	@GetMapping("/book")
	public Mono<ResponseEntity<Book>> getBookById() {
		return Mono.error(new BookNotFoundException("Book Not found in db"));
	}

}
