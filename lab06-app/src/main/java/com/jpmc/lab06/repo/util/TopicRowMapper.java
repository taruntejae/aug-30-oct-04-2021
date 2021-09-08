package com.jpmc.lab06.repo.util;

import com.jpmc.lab06.domain.Topic;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TopicRowMapper implements RowMapper<Topic> {
    @Override
    public Topic mapRow(ResultSet rs, int rowNum) throws SQLException {
        Topic topic = new Topic();
        topic.setId(rs.getInt("id"));
        topic.setTitle(rs.getString("title"));
        topic.setDuration(rs.getInt("duration"));
        return topic;
    }
}
