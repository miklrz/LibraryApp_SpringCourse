package ru.hxastur.springcourse.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.hxastur.springcourse.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        System.out.println(rs.getInt("person_id"));
        Book book = new Book();
        book.setBook_id(rs.getInt("book_id"));
        book.setAuthor(rs.getString("author"));
        book.setYear(rs.getInt("year"));
        book.setTitle(rs.getString("title"));
        if(rs.getInt("person_id") != 0) {
            book.setPerson_id(rs.getInt("person_id"));
        }
        return book;

    }
}
