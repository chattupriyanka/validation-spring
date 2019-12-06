package com.example.demo;
import java.awt.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface validationRepository extends MongoRepository<validatepojo, String> {

//	static List findByUserName(String userName) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
} 
