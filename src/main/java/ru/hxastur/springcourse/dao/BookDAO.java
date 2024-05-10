package ru.hxastur.springcourse.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import ru.hxastur.springcourse.model.Book;

import java.util.List;

@Controller
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index(){
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int book_id){
        return jdbcTemplate.query("SELECT * FROM Book WHERE book_id = ?", new Object[]{book_id},
                new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }
}
