package com.persado.assignment.project.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity //maps the class User to database
@Table(name="users")
public class User {

    @Column(name="user_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;


    @Column(name = "address")
    private String address;

    @ManyToMany(cascade = { CascadeType.ALL })  //joins in the borrow table
    @JoinTable(
            name = "Borrow",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "book_id") }
    )
    Set<Book> books = new HashSet<>();



    public User() {

    }


    public User(long id, String firstName, String lastName, String address) {
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;

    }
    public User(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
