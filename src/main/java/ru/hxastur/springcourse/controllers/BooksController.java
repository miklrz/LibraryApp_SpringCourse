package ru.hxastur.springcourse.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String show(Model model, @PathVariable("book_id") int book_id){
        model.addAttribute("book", bookDAO.show(book_id));
        model.addAttribute("people", personDAO.index());
        model.addAttribute("person", personDAO.getPersonFromBook(book_id));
        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book, Model model){
        model.addAttribute("people", personDAO.index());
        return "books/new";
    }

    @PostMapping
    public String create(@ModelAttribute @Valid Book book, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "books/new";
        bookDAO.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{book_id}/edit")
    public String edit(Model model,@ModelAttribute("book") Book book){
        model.addAttribute("people", personDAO.index());
        return "/books/edit";
    }

    @PatchMapping("/{book_id}")
    public String update(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult,
                         @PathVariable("book_id") int book_id){
        if(bindingResult.hasErrors()) return "books/edit";
        bookDAO.update(book,book_id);
        return "redirect:/books";
    }

    @PatchMapping("/{book_id}/clearOwner")
    public String clearOwner(@PathVariable("book_id") int book_id){
        bookDAO.clearOwner(book_id);
        return "redirect:/books/{book_id}";
    }

    @PatchMapping("/{book_id}/setOwner")
    public String setOwner(@ModelAttribute("book") Book book, @PathVariable("book_id") int book_id){
        bookDAO.setOwner(book.getPerson_id(), book_id);
        return "redirect:/books/{book_id}";
    }

    @DeleteMapping("/{book_id}")
    public String delete(@PathVariable("book_id") int book_id){
        bookDAO.delete(book_id);
        return "redirect:/books";
    }
}
