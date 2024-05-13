package ru.hxastur.springcourse.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.hxastur.springcourse.dao.BookDAO;
import ru.hxastur.springcourse.model.Book;

public class BookValidator implements Validator {
    private final BookDAO bookDAO;

    public BookValidator(BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Book book = (Book) target;

//        if(bookDAO.show())
    }
}
