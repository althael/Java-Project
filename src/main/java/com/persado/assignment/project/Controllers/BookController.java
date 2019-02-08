package com.persado.assignment.project.Controllers;

import com.persado.assignment.project.Entities.Book;
import com.persado.assignment.project.Services.BookServices.BookService;
import com.persado.assignment.project.Services.UserServices.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;
    private UserService userService;

    public BookController(BookService theBookService) {
        bookService = theBookService;
    }


    // add mapping for "/list"

    @GetMapping("/list")
    public String listBooks(Model theModel) {

        // get books from db
        List<Book> theBooks = bookService.findAll();

        // add to the spring model
        theModel.addAttribute("books", theBooks);

        return "/books/list-books";
    }

    @GetMapping("/addNewBook")
    public String showFormForAddBook(Model theModel) {

        // create model attribute to bind form data
        Book theBook = new Book();

        theModel.addAttribute("books", theBook);

        return "/books/book-form";
    }



    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("books") Book theBook) {

        theBook.setCopiesAvailable(theBook.getCopiesPurchased());

        // save the book
        bookService.save(theBook);


        // use a redirect to prevent duplicate submissions
        return "redirect:/books/list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("bookId") long theId) {

        // delete the book
        bookService.deleteById(theId);

        // redirect to /book/list
        return "redirect:/books/list";

    }

    @GetMapping("/loanBook")
        public String loanBook(Model theModel) {
        // get books from db
        List<Book> theBooks = bookService.findAll();




        // add to the spring model
        theModel.addAttribute("books", theBooks);



        return "/books/book-loan";
    }

    @GetMapping("/returnBook")
    public String returnBook(Model theModel) {


        return "/books/book-return";
    }

}
