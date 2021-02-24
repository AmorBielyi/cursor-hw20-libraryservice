package com.cursor.libraryservice.controller;

import com.cursor.libraryservice.model.Book;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class LibraryController {

    RestTemplate restTemplate;

    @GetMapping("/library/books")
    public List<Book> getBooks(){
        ResponseEntity<List<Book>> books  = restTemplate.exchange("http://book-service/api/books/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
        return books.getBody();
    }

    @GetMapping("/library/books/get/{id}")
    public Optional<Book> getBook(@PathVariable Long id) {
        ResponseEntity<Optional<Book>> book = restTemplate.exchange("http://book-service/api/books/get/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {

                });
        return book.getBody();
    }

}
