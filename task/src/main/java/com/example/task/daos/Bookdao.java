package com.example.task.daos;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.task.contracts.BookDaoInterface;
import com.example.task.models.Book;
import com.example.task.models.PublishingHouse;
import com.example.task.RowMapper.PublishingHouseRowMapper;
import com.example.task.RowMapper.BookRowMapper;

@Repository

public class Bookdao implements BookDaoInterface {
	
	JdbcTemplate jdbc;

	@Autowired
	public Bookdao(DataSource datasource) {
		this.jdbc = new JdbcTemplate(datasource);

	}

	public List<PublishingHouse> getPublishersFromDao() {
		
		return jdbc.query("select * from publishing_house", new PublishingHouseRowMapper());

	}

	

	// This method fetches books by publisher ID
    @SuppressWarnings("deprecation")
	public List<Book> getBooksByIdFromDao(Long publisherId) {
        String sql = "SELECT * FROM book WHERE id = ?";
        return jdbc.query(sql, new Object[]{publisherId}, new BookRowMapper());
    }

    @SuppressWarnings("deprecation")
	public Book getBookByIdFromDao(Long id) {
        String sql = "SELECT * FROM book WHERE id = ?";
        return jdbc.queryForObject(sql, new Object[]{id}, new BookRowMapper());
    }

    public void deleteBookByIdFromDao(Long id) {
        String sql = "DELETE FROM book WHERE id = ?";
        jdbc.update(sql, id);
    }

}



					