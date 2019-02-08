package com.persado.assignment.project.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


    @Entity
    @Table(name = "Borrow")
    public class Borrow {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="borrow_id")
        private long id;

        @Column(name = "loanDate")
        @DateTimeFormat(pattern = "dd-MM-yyyy")
        private LocalDate loanDate;

        @Column(name = "returnDate")
        @DateTimeFormat(pattern = "dd-MM-yyyy")
        private LocalDate returnDate = null;

        @Column(name = "book_id")
        private Long bookid;

        @Column(name = "user_id")
        private Long userid;



        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public LocalDate getLoanDate() {
            return loanDate;
        }

        public void setLoanDate(LocalDate loanDate) {
            this.loanDate = loanDate;
        }

        public LocalDate getReturnDate() {
            return returnDate;
        }

        public void setReturnDate(LocalDate returnDate) {
            this.returnDate = returnDate;
        }

        public Long getBookid() {
            return bookid;
        }

        public void setBookid(Long bookid) {
            this.bookid = bookid;
        }

        public Long getUserid() {
            return userid;
        }

        public void setUserid(Long userid) {
            this.userid = userid;
        }

        @Override
        public String toString() {
            return "Loans{" +
                    "id=" + id +
                    ", loanDate=" + loanDate +
                    ", returnDate=" + returnDate +
                    ", bookid=" + bookid +
                    ", userid=" + userid +
                    '}';
        }
    }

