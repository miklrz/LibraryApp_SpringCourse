package ru.hxastur.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import ru.hxastur.springcourse.model.Book;

import java.util.List;

@Controller
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index(){
        System.out.println(jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class)));
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int book_id){
        return jdbcTemplate.query("SELECT * FROM Book WHERE book_id = ?", new Object[]{book_id},
                new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public void save(Book book) {
        System.out.println(book.getPerson_id());
        jdbcTemplate.update("INSERT INTO Book(person_id,title,author,year) VALUES (?,?,?,?)",
                book.getPerson_id() == 0 ? null : book.getPerson_id(),
                book.getTitle(), book.getAuthor(), book.getYear());
//        if (book.getPerson_id() == 0){
//            jdbcTemplate.update("UPDATE Book SET person_id = NULL, title = ?, author = ?, year = ?",
//                    book.getTitle(), book.getAuthor(), book.getYear());
//        }
//        else{
//            jdbcTemplate.update("UPDATE Book SET person_id = ?, title = ?, author = ?, year = ?",
//                    book.getPerson_id(), book.getTitle(), book.getAuthor(), book.getYear());
//        }
    }
}
