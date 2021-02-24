package com.cursor.libraryservice.model;

import lombok.Data;

@Data
public class Book {
    private Long id;
    private String name;
    private int releaseDate;
    private int numOfPages;
}
