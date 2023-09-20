package com.example.task.RowMapper;
import org.springframework.jdbc.core.RowMapper;
import com.example.task.models.Book;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String title = resultSet.getString("title");
        String author = resultSet.getString("author");

        // You can add additional columns as needed and set them here

        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setAuthor(author);

        // You can set other properties of the Book entity here based on the ResultSet

        return book;
    }
}
