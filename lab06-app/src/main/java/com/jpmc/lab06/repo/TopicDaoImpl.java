package com.jpmc.lab06.repo;

import com.jpmc.lab06.domain.Topic;
import com.jpmc.lab06.repo.exception.TopicAlreadyExistsException;
import com.jpmc.lab06.repo.util.TopicRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TopicDaoImpl implements TopicDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TopicRowMapper topicRowMapper;

    @Override
    public void addTopic(String title, int duration) {
        if(!topicExists(title)) {
            String query = "insert into topics(title, duration) values(?, ?)";
            jdbcTemplate.update(query, title, duration);
        } else {
          throw new TopicAlreadyExistsException(title);
        }
    }

    @Override
    public List<Topic> getTopics() {
        String query = "select * from topics";
        return jdbcTemplate.query(query, topicRowMapper);
    }

    @Override
    public boolean topicExists(String title) {
        boolean exists = true;
        String query = "select id from topics where title like ?";
        try {
            jdbcTemplate.queryForObject(query,Integer.class, title);
        }
        catch(Exception ex) {
            exists = false;
        }
        return exists;
    }
}
