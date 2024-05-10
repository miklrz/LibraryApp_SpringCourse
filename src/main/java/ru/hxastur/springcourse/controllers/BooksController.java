package ru.hxastur.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.hxastur.springcourse.dao.BookDAO;
import ru.hxastur.springcourse.model.Book;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookDAO bookDAO;

    public BooksController(BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("books", bookDAO.index());
        return "books/index";
    }

    @GetMapping("/{book_id}")
    public String show(Model model, @ModelAttribute Book book){
        model.addAttribute("book", bookDAO.show(book.getBook_id()));
        return "books/show";
    }
}
