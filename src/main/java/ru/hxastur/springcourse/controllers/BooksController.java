package ru.hxastur.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.hxastur.springcourse.dao.BookDAO;
import ru.hxastur.springcourse.dao.PersonDAO;
import ru.hxastur.springcourse.model.Book;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookDAO bookDAO;
    private final PersonDAO personDAO;

    public BooksController(BookDAO bookDAO, PersonDAO personDAO){
        this.bookDAO = bookDAO;
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("books", bookDAO.index());
        return "books/index";
    }

    @GetMapping("/{book_id}")
    public String show(Model model, @ModelAttribute Book book){
        model.addAttribute("book", bookDAO.show(book.getBook_id()));
        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute Book book, Model model){
        model.addAttribute("people", personDAO.index());
        return "books/new";
    }

    @PostMapping
    public String create(@ModelAttribute Book book){
        bookDAO.save(book);
        return "redirect:/books";
    }

//    @GetMapping("/{book_id}/edit")
//    public String edit(){
//        return null;
//    }
//
//    @PatchMapping
//    public String update(){
//        return null;
//
//    }
//
//    @DeleteMapping
//    public String delete(){
//        return null;
//
//    }

}
