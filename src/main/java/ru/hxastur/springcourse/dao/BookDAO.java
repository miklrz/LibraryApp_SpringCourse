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
        return jdbcTemplate.query("SELECT * FROM Book", new BookMapper());
    }

    public Book show(int book_id){
        return jdbcTemplate.query("SELECT * FROM Book WHERE book_id = ?", new Object[]{book_id},
                new BookMapper())
                .stream().findAny().orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book(person_id,title,author,year) VALUES (?,?,?,?) ",
                book.getPerson_id() == 0 ? null : book.getPerson_id(),
                book.getTitle(), book.getAuthor(), book.getYear());
    }

    public void update(Book updatedBook, int book_id){
        jdbcTemplate.update("UPDATE Book SET person_id = ?, title = ?, author = ?, year = ? WHERE book_id = ?",
                updatedBook.getPerson_id() == 0 ? null : updatedBook.getPerson_id(), updatedBook.getTitle(),
                updatedBook.getAuthor(), updatedBook.getYear(), book_id);
    }

    public void clearOwner(int book_id){
        jdbcTemplate.update("UPDATE Book SET person_id = null WHERE book_id = ?", book_id);
    }

    public void setOwner(int person_id, int book_id){
        jdbcTemplate.update("UPDATE Book SET person_id = ? WHERE book_id = ?",
                person_id, book_id);
    }

    public void delete(int book_id){
        jdbcTemplate.update("DELETE FROM Book WHERE book_id = ?", book_id);
    }

}
