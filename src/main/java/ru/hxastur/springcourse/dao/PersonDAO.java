package ru.hxastur.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import ru.hxastur.springcourse.model.Book;
import ru.hxastur.springcourse.model.Person;

import java.util.List;

@Controller
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index(){
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int person_id){
        return jdbcTemplate.query("SELECT * FROM Person WHERE person_id = ?", new Object[]{person_id}
                , new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public List<Book> getBooks(int person_id){
        return jdbcTemplate.query("SELECT * FROM Person JOIN Book ON Person.person_id = Book.person_id WHERE person.person_id = ?",
                new Object[]{person_id}, new BeanPropertyRowMapper<>(Book.class));
    }

    public void save(Person person){
        jdbcTemplate.update("INSERT INTO Person(name, year_of_birth) VALUES(?,?)",
                person.getName(), person.getYear_of_birth());
    }

    public void update(int person_id, Person updatedPerson){
        jdbcTemplate.update("UPDATE Person SET name = ?, year_of_birth = ? WHERE person_id = ?",
                updatedPerson.getName(), updatedPerson.getYear_of_birth(), person_id);
    }

    public void delete(int person_id){
        jdbcTemplate.update("DELETE FROM Person WHERE person_id = ?", person_id);
    }

}
