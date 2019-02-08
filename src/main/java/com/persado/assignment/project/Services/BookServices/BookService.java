package com.persado.assignment.project.Services.BookServices;

import com.persado.assignment.project.Entities.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    void save(Book theBook);

    void deleteById(long theId);
}
