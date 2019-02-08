package com.persado.assignment.project.Repositories.BookRepository;//package com.persado.assignment.project.Repository;

import com.persado.assignment.project.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
