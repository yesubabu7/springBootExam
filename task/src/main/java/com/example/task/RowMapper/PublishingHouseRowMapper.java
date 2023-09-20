package com.example.task.RowMapper;
import org.springframework.jdbc.core.RowMapper;
import com.example.task.models.PublishingHouse;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PublishingHouseRowMapper implements RowMapper<PublishingHouse> {
    @Override
    public PublishingHouse mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");

        // You can add additional columns as needed and set them here

        PublishingHouse publishingHouse = new PublishingHouse();
        publishingHouse.setId(id);
        publishingHouse.setName(name);

        // You can set other properties of the PublishingHouse entity here based on the ResultSet

        return publishingHouse;
    }
}
