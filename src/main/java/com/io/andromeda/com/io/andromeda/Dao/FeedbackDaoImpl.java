package com.io.andromeda.com.io.andromeda.Dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.io.andromeda.com.io.andromeda.Entity.FeedbackEntity;

@Component
public class FeedbackDaoImpl {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    public void setDataSource(DataSource dataSource) {
            this.dataSource = dataSource;
            this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public void insertWithQuery(FeedbackEntity feedbackEntity){
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update("INSERT INTO fds_feedback (first_name, last_name, email_id, mobile_no, message) VALUES (?,?,?,?,?)",
            		feedbackEntity.getFirstName(),feedbackEntity.getLastName(),feedbackEntity.getEmailId(),
            		feedbackEntity.getMobileNo(),feedbackEntity.getMessage());
            
    }
	
}
