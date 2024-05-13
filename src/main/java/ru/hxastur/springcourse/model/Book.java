package ru.hxastur.springcourse.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class Book {
    private int book_id;
    private int person_id;

    @NotEmpty(message = "Title should not be empty")
    @Size(min  = 1, max = 40, message = "Title should be greater than 1 and less than 40")
    private String title;

    @NotEmpty(message = "Author should not be empty")
    @Size(min = 2, max = 30, message = "Author name should be greater than 2 and less than 30")
    private String author;

    @Max(value = 2025, message = "Year should be less than 2025")
    private int year;

    public Book(){}

    public Book(int book_id, int person_id, String title, String author, int year) {
        this.book_id = book_id;
        this.person_id = person_id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }
}
