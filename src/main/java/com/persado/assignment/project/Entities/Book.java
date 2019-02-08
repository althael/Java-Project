package com.persado.assignment.project.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity //maps the  Book class to database
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id", nullable = false)
    private long id;

    @Column(name = "ISBN", nullable = false)
    private String ISBN;

    @Column(name = "name")
    private String Name;

    @Column(name = "summary")
    private String Summary;

    @Column(name = "copies_purchased")
    private int copiesPurchased;

    @Column(name = "copies_available")
    private int copiesAvailable;

    @ManyToMany(mappedBy = "books")  //joins in the borrow table
    private Set<User> users = new HashSet<>();

    



    public Book() {

    }

    public Book(long id, String ISBN, String name, String summary, int copiesPurchased, int copiesAvailable) {
        this.id = id;
        this.ISBN = ISBN;
        Name = name;
        Summary = summary;
        this.copiesPurchased = copiesPurchased;
        this.copiesAvailable = copiesAvailable;
        
    }

    public Book(String ISBN, String name, String summary, int copiesPurchased, int copiesAvailable) {
        this.ISBN = ISBN;
        Name = name;
        Summary = summary;
        this.copiesPurchased = copiesPurchased;
        this.copiesAvailable = copiesAvailable;
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public int getCopiesPurchased() {
        return copiesPurchased;
    }

    public void setCopiesPurchased(int copiesPurchased) {
        this.copiesPurchased = copiesPurchased;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    
    

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", ISBN='" + ISBN + '\'' +
                ", Name='" + Name + '\'' +
                ", Summary='" + Summary + '\'' +
                ", copiesPurchased=" + copiesPurchased +
                ", copiesAvailable=" + copiesAvailable +
                '}';
    }
}


