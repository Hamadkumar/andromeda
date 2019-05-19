package com.io.andromeda.com.io.andromeda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.io.andromeda.com.io.andromeda.Dao.FeedbackDaoImpl;
import com.io.andromeda.com.io.andromeda.Entity.FeedbackEntity;

@RestController
public class AndromedaRestController {
	
	@Autowired
	FeedbackDaoImpl feedbackDao;
	
	@PostMapping(value = "/sendfeedback")
	@ResponseBody
    public ResponseEntity<FeedbackEntity> feedback(@RequestBody FeedbackEntity feedBackEntity) {
		feedbackDao.insertWithQuery(feedBackEntity);
        return new ResponseEntity<FeedbackEntity>(feedBackEntity,HttpStatus.OK) ;
    }
}
